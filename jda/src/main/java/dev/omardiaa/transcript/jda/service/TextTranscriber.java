package dev.omardiaa.transcript.jda.service;

import dev.omardiaa.transcript.core.model.Payload;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.PayloadOptions;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
import dev.omardiaa.transcript.core.model.payload.common.Role;
import dev.omardiaa.transcript.core.model.payload.message.*;
import dev.omardiaa.transcript.core.model.payload.message.component.*;
import dev.omardiaa.transcript.core.util.Helper;
import dev.omardiaa.transcript.core.util.TimeUtil;
import dev.omardiaa.transcript.jda.model.TextTranscript;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class TextTranscriber {
  private static final int BOX_WIDTH = 44;
  private static final Pattern BOLD_PATTERN = Pattern.compile("\\*\\*(.+?)\\*\\*");
  private static final Pattern UNDERLINE_PATTERN = Pattern.compile("__(.+?)__");
  private static final Pattern ITALIC_STAR_PATTERN = Pattern.compile("\\*(.+?)\\*");
  private static final Pattern ITALIC_UNDER_PATTERN = Pattern.compile("_(.+?)_");
  private static final Pattern STRIKETHROUGH_PATTERN = Pattern.compile("~~(.+?)~~");
  private static final Pattern CODE_BLOCK_PATTERN = Pattern.compile("```(?:\\w+\\n)?(.*?)```", Pattern.DOTALL);
  private static final Pattern INLINE_CODE_PATTERN = Pattern.compile("`(.+?)`");
  private static final Pattern LINK_PATTERN = Pattern.compile("\\[(.+?)]\\((.+?)\\)");
  private static final Pattern BARE_URL_PATTERN = Pattern.compile("(https?://\\S+)");
  private static final Pattern HEADER_PATTERN = Pattern.compile("(?m)^#{1,3} ");
  private static final Pattern BLOCKQUOTE_PATTERN = Pattern.compile("(?m)^> ");
  private static final Pattern SUBTEXT_PATTERN = Pattern.compile("(?m)^-# ");
  private static final Pattern MENTION_USER_PATTERN = Pattern.compile("<@!?(\\d+)>");
  private static final Pattern MENTION_ROLE_PATTERN = Pattern.compile("<@&(\\d+)>");
  private static final Pattern MENTION_CHANNEL_PATTERN = Pattern.compile("<#(\\d+)>");
  private static final Pattern CUSTOM_EMOJI_PATTERN = Pattern.compile("<a?:([^:]+):(\\d+)>");
  private static final Pattern TIMESTAMP_PATTERN = Pattern.compile("<t:(\\d+)(?::[tTdDfFR])?>");
  private static final String SEPARATOR_LINE = "────────────────────────────────────────────";

  TextTranscript transcribe(Payload payload, PayloadOptions options) {
    Guild guild = payload.guild();
    dev.omardiaa.transcript.core.model.payload.Channel channel = payload.channel();
    StringBuilder sb = new StringBuilder();

    sb.append(SEPARATOR_LINE).append("\n");
    sb.append("  #").append(channel.name()).append(" | ").append(guild.name()).append("\n");
    sb.append(SEPARATOR_LINE).append("\n\n");

    Message previousMessage = null;
    for (Message message : payload.messages()) {
      if (message.type() == Message.Type.UNKNOWN) {
        continue;
      }

      if (message.showDivider(previousMessage)) {
        sb.append("── ").append(TimeUtil.formatDateLong(message.timestamp())).append(" ──\n\n");
      }

      renderMessage(sb, message, previousMessage, guild);

      previousMessage = message;
    }

    sb.append(SEPARATOR_LINE).append("\n");
    return new TextTranscript(sb.toString());
  }

  private void renderMessage(StringBuilder sb, Message message, Message previousMessage, Guild guild) {
    boolean showAuthor = message.showAuthor(previousMessage);

    if (message.type() == Message.Type.DEFAULT) {
      if (showAuthor) {
        sb.append(message.author().username());
        if (message.author().tag() != null) {
          sb.append(" ").append(message.author().tag());
        }
        sb.append(" • ").append(TimeUtil.formatTimeShort(message.timestamp())).append("\n");
      }

      String content = stripMarkdown(message.content(), message.mentionsMap(), guild.rolesMap());
      if (!content.isBlank()) {
        sb.append(content).append("\n");
      }

      if (message.editedTimestamp() != null) {
        sb.append("(edited)\n");
      }

      if (message.messageSnapshots() != null && !message.messageSnapshots().isEmpty()) {
        for (MessageSnapshot snapshot : message.messageSnapshots()) {
          sb.append("  ╎ Forwarded: ");
          sb.append(stripMarkdown(snapshot.message().content(), Map.of(), guild.rolesMap())).append("\n");
        }
      }

      renderAccessories(sb, message, guild);

    } else if (message.type() == Message.Type.THREAD_CREATED) {
      if (showAuthor) {
        sb.append(message.author().username()).append(" started a thread: ");
        sb.append(message.content()).append("\n");
      }
    }

    sb.append("\n");
  }

  private void renderAccessories(StringBuilder sb, Message message, Guild guild) {
    String indent = "    ";

    if (message.poll() != null) {
      renderPoll(sb, message.poll(), indent);
      return;
    }

    if (!message.attachments().isEmpty()) {
      renderAttachments(sb, message);
    }

    if (!message.embeds().isEmpty()) {
      renderEmbeds(sb, message.embeds(), indent);
    }

    if (message.components() != null && !message.components().isEmpty()) {
      renderComponents(sb, message.components(), indent);
    }

    if (message.stickerItems() != null && !message.stickerItems().isEmpty()) {
      renderStickers(sb, message.stickerItems(), indent);
    }

    if (message.reactions() != null && !message.reactions().isEmpty()) {
      renderReactions(sb, message.reactions(), indent);
    }
  }

  private void renderAttachments(StringBuilder sb, Message message) {
    String indent = "    ";
    List<Attachment> images = message.getImages();

    for (Attachment image : images) {
      sb.append(indent).append("[Image: ").append(image.filename()).append("]\n");
    }

    List<dev.omardiaa.transcript.core.model.payload.message.component.File> files = message.getFiles();
    for (dev.omardiaa.transcript.core.model.payload.message.component.File file : files) {
      String label = file.name();
      String url = file.file().url();
      String size = Helper.formatBytes(file.size());
      String icon = isVideo(label) ? "[Video" : "[File";
      sb.append(indent).append(icon).append(": ").append(label).append("]");
      if (url != null && !url.isEmpty()) {
        sb.append(" -> ").append(url);
      }
      sb.append(" (").append(size).append(")\n");
    }
  }

  private static boolean isVideo(String filename) {
    String lower = filename.toLowerCase();
    return lower.endsWith(".mp4") || lower.endsWith(".webm") || lower.endsWith(".mov")
      || lower.endsWith(".avi") || lower.endsWith(".mkv") || lower.endsWith(".flv")
      || lower.endsWith(".wmv") || lower.endsWith(".m4v") || lower.endsWith(".ogv");
  }

  private void renderEmbeds(StringBuilder sb, List<Embed> embeds, String indent) {
    for (Embed embed : embeds) {
      if (embed.type() == Embed.Type.GIFV) {
        String label = "[GIFV]";
        if (embed.url() != null) {
          label = label + " -> " + embed.url();
        }
        sb.append(indent).append(label).append("\n");
        continue;
      }

      String title = embed.title() != null ? embed.title() : (embed.type() == Embed.Type.ARTICLE ? "Article" : "Embed");
      String boxTop = "╔══ " + title + " ";
      sb.append(indent).append(padRight(boxTop, '═', BOX_WIDTH)).append("╗\n");

      if (embed.author() != null && embed.author().name() != null) {
        sb.append(indent).append("║ Author: ").append(embed.author().name()).append("\n");
      }

      if (embed.description() != null && !embed.description().isBlank()) {
        for (String line : wrapText(embed.description(), BOX_WIDTH - 4)) {
          sb.append(indent).append("║ ").append(line).append("\n");
        }
      }

      if (embed.fields() != null) {
        for (Embed.Field field : embed.fields()) {
          String fieldText = field.name() + ": " + field.value();
          for (String line : wrapText(fieldText, BOX_WIDTH - 4)) {
            sb.append(indent).append("║ ").append(line).append("\n");
          }
        }
      }

      if (embed.footer() != null && embed.footer().text() != null) {
        sb.append(indent).append("║ --- ").append(embed.footer().text()).append("\n");
      }

      sb.append(indent).append(padRight("╚", '═', BOX_WIDTH)).append("╝\n\n");
    }
  }

  private void renderComponents(StringBuilder sb, List<Component> components, String indent) {
    for (Component component : components) {
      if (component instanceof ActionRow actionRow) {
        renderActionRow(sb, actionRow, indent);
      } else if (component instanceof Container container) {
        renderContainer(sb, container, indent);
      } else if (component instanceof Section section) {
        renderSection(sb, section, indent);
      } else if (component instanceof TextDisplay textDisplay) {
        renderTextDisplay(sb, textDisplay, indent);
      } else if (component instanceof dev.omardiaa.transcript.core.model.payload.message.component.File file) {
        renderFile(sb, file, indent);
      } else if (component instanceof MediaGallery mediaGallery) {
        renderMediaGallery(sb, mediaGallery, indent);
      } else if (component instanceof Separator separator) {
        renderSeparator(sb, separator, indent);
      }
    }
  }

  private void renderActionRow(StringBuilder sb, ActionRow actionRow, String indent) {
    StringBuilder rowContent = new StringBuilder();
    for (ActionRowChildComponent child : actionRow.components()) {
      if (child instanceof Button button) {
        if (rowContent.length() > 0) rowContent.append("  ");
        String label = button.label() != null ? button.label() : (button.emoji() != null ? emojiToString(button.emoji()) : "Button");
        if (button.disabled()) {
          rowContent.append("[").append(label).append("]");
        } else {
          rowContent.append("【").append(label).append("】");
        }
      } else if (child instanceof SelectMenu selectMenu) {
        if (rowContent.length() > 0) rowContent.append("  ");
        rowContent.append("▽ ").append(selectMenu.placeholder());
      }
    }

    String content = rowContent.toString();
    if (content.length() > BOX_WIDTH - 4) {
      content = content.substring(0, BOX_WIDTH - 7) + "...";
    }

    sb.append(indent).append("┌").append(repeat("─", BOX_WIDTH - 2)).append("┐\n");
    sb.append(indent).append("│ ").append(padRight(content, ' ', BOX_WIDTH - 4)).append(" │\n");
    sb.append(indent).append("└").append(repeat("─", BOX_WIDTH - 2)).append("┘\n\n");
  }

  private void renderContainer(StringBuilder sb, Container container, String indent) {
    sb.append(indent).append("╔══ Container ").append(repeat("═", BOX_WIDTH - 16)).append("╗\n");

    for (ContainerChildComponent child : container.components()) {
      if (child instanceof ActionRow actionRow) {
        renderActionRow(sb, actionRow, indent + "║ ");
      } else if (child instanceof Section section) {
        renderSection(sb, section, indent + "║ ");
      } else if (child instanceof TextDisplay textDisplay) {
        for (String line : wrapText(stripMarkdown(textDisplay.content(), Map.of(), Map.of()), BOX_WIDTH - 6)) {
          sb.append(indent).append("║ ").append(line).append("\n");
        }
      } else if (child instanceof dev.omardiaa.transcript.core.model.payload.message.component.File file) {
        renderFile(sb, file, indent + "║ ");
      } else if (child instanceof MediaGallery mediaGallery) {
        renderMediaGallery(sb, mediaGallery, indent + "║ ");
      } else if (child instanceof Separator separator) {
        sb.append(indent).append("║ ").append(repeat("─", BOX_WIDTH - 4)).append("\n");
      }
    }

    sb.append(indent).append(repeat("╚", 1)).append(repeat("═", BOX_WIDTH - 2)).append("╝\n\n");
  }

  private void renderSection(StringBuilder sb, Section section, String indent) {
    for (SectionChildComponent child : section.components()) {
      if (child instanceof TextDisplay textDisplay) {
        for (String line : wrapText(stripMarkdown(textDisplay.content(), Map.of(), Map.of()), BOX_WIDTH - 6)) {
          sb.append(indent).append("┊ ").append(line).append("\n");
        }
      }
    }

    if (section.accessory() instanceof Button button) {
      String label = button.label() != null ? button.label() : "Button";
      sb.append(indent).append("┊ ").append(repeat("─", BOX_WIDTH - 6 - label.length() - 2));
      sb.append("【").append(label).append("】\n");
    } else if (section.accessory() instanceof Thumbnail thumbnail) {
      sb.append(indent).append("┊ [Thumbnail: ").append(thumbnail.media().url()).append("]\n");
    }
  }

  private void renderTextDisplay(StringBuilder sb, TextDisplay textDisplay, String indent) {
    for (String line : wrapText(stripMarkdown(textDisplay.content(), Map.of(), Map.of()), BOX_WIDTH - 4)) {
      sb.append(indent).append("┊ ").append(line).append("\n");
    }
  }

  private void renderFile(StringBuilder sb, dev.omardiaa.transcript.core.model.payload.message.component.File file, String indent) {
    String size = Helper.formatBytes(file.size());
    sb.append(indent).append("┊ [File: ").append(file.name()).append("]");
    sb.append(" -> ").append(file.file().url());
    sb.append(" (").append(size).append(")\n");
  }

  private void renderMediaGallery(StringBuilder sb, MediaGallery mediaGallery, String indent) {
    int count = mediaGallery.items().size();
    sb.append(indent).append("[Gallery: ").append(count).append(" image");
    if (count > 1) sb.append("s");
    sb.append("]\n");
  }

  private void renderSeparator(StringBuilder sb, Separator separator, String indent) {
    sb.append(indent).append(repeat("─", BOX_WIDTH - 4)).append("\n");
  }

  private void renderPoll(StringBuilder sb, Poll poll, String indent) {
    sb.append(indent).append("╔══ Poll ").append(repeat("═", BOX_WIDTH - 12)).append("╗\n");
    sb.append(indent).append("║ Q: ").append(poll.question().text()).append("\n");

    if (poll.answers() != null) {
      for (Poll.Answer answer : poll.answers()) {
        sb.append(indent).append("║  ○ ").append(answer.pollMedia().text());
        if (answer.pollMedia().emoji() != null) {
          sb.append("  ").append(emojiToString(answer.pollMedia().emoji()));
        }
        sb.append("\n");
      }
    }

    if (poll.results() != null && poll.results().answerCounts() != null) {
      sb.append(indent).append("║ Votes: ");
      for (Poll.AnswerCount ac : poll.results().answerCounts()) {
        sb.append(ac.count()).append(" ");
      }
      sb.append("\n");
    }

    sb.append(indent).append(repeat("╚", 1)).append(repeat("═", BOX_WIDTH - 2)).append("╝\n\n");
  }

  private void renderStickers(StringBuilder sb, List<StickerItem> stickers, String indent) {
    for (StickerItem sticker : stickers) {
      sb.append(indent).append("[Sticker]");
      if (sticker.iconUrl() != null) {
        sb.append(" -> ").append(sticker.iconUrl());
      }
      sb.append("\n");
    }
  }

  private void renderReactions(StringBuilder sb, List<Reaction> reactions, String indent) {
    StringBuilder reactionsLine = new StringBuilder();
    for (Reaction reaction : reactions) {
      if (reactionsLine.length() > 0) reactionsLine.append("  ");
      reactionsLine.append(emojiToString(reaction.emoji()));
      reactionsLine.append(" ").append(reaction.count());
    }
    sb.append(indent).append(reactionsLine).append("\n");
  }

  private String emojiToString(Emoji emoji) {
    if (emoji instanceof Emoji.Custom custom) {
      return ":" + custom.id() + ":";
    } else if (emoji instanceof Emoji.Unicode unicode) {
      return unicode.asUTF8();
    }
    return ":?:";
  }

  String stripMarkdown(String input, Map<String, User> mentionsMap, Map<String, Role> rolesMap) {
    if (input == null || input.isEmpty()) {
      return "";
    }

    String result = input;

    result = CODE_BLOCK_PATTERN.matcher(result).replaceAll(mr -> {
      String code = mr.group(1).stripTrailing();
      return "```" + code + "```";
    });

    result = INLINE_CODE_PATTERN.matcher(result).replaceAll(mr -> "`" + mr.group(1) + "`");

    result = BOLD_PATTERN.matcher(result).replaceAll(mr -> mr.group(1));
    result = UNDERLINE_PATTERN.matcher(result).replaceAll(mr -> mr.group(1));
    result = STRIKETHROUGH_PATTERN.matcher(result).replaceAll(mr -> mr.group(1));
    result = ITALIC_STAR_PATTERN.matcher(result).replaceAll(mr -> mr.group(1));
    result = ITALIC_UNDER_PATTERN.matcher(result).replaceAll(mr -> mr.group(1));

    result = LINK_PATTERN.matcher(result).replaceAll(mr -> {
      String text = mr.group(1);
      String url = mr.group(2);
      if (text.equals(url)) return url;
      return text + " (" + url + ")";
    });

    result = HEADER_PATTERN.matcher(result).replaceAll("");
    result = BLOCKQUOTE_PATTERN.matcher(result).replaceAll("");
    result = SUBTEXT_PATTERN.matcher(result).replaceAll("");

    result = MENTION_USER_PATTERN.matcher(result).replaceAll(mr -> {
      String userId = mr.group(1);
      User user = mentionsMap.get(userId);
      if (user != null) {
        return "@" + user.username();
      }
      return "@" + userId;
    });

    result = MENTION_ROLE_PATTERN.matcher(result).replaceAll(mr -> {
      String roleId = mr.group(1);
      Role role = rolesMap.get(roleId);
      if (role != null) {
        return "@" + role.name();
      }
      return "@role-" + roleId;
    });

    result = MENTION_CHANNEL_PATTERN.matcher(result).replaceAll(mr -> "#channel-" + mr.group(1));

    result = CUSTOM_EMOJI_PATTERN.matcher(result).replaceAll(mr -> ":" + mr.group(1) + ":");

    result = TIMESTAMP_PATTERN.matcher(result).replaceAll(mr -> {
      try {
        return TimeUtil.formatTimestamp(mr.group(1));
      } catch (Exception e) {
        return mr.group();
      }
    });

    if (result.contains("@everyone")) {
      result = result.replace("@everyone", "@everyone");
    }
    if (result.contains("@here")) {
      result = result.replace("@here", "@here");
    }

    return result.trim();
  }

  private static String repeat(String s, int count) {
    if (count <= 0) return "";
    StringBuilder sb = new StringBuilder(s.length() * count);
    for (int i = 0; i < count; i++) {
      sb.append(s);
    }
    return sb.toString();
  }

  private static String padRight(String prefix, char pad, int totalWidth) {
    int toPad = totalWidth - prefix.length();
    if (toPad <= 0) return prefix;
    return prefix + repeat(String.valueOf(pad), toPad);
  }

  private static List<String> wrapText(String text, int maxWidth) {
    if (text == null || text.isEmpty()) return List.of();
    if (maxWidth < 10) return List.of(text);

    List<String> lines = new java.util.ArrayList<>();
    StringBuilder currentLine = new StringBuilder();

    for (String word : text.split(" ")) {
      if (currentLine.length() + word.length() + 1 > maxWidth) {
        if (currentLine.length() > 0) {
          lines.add(currentLine.toString().stripTrailing());
          currentLine = new StringBuilder();
        }
        while (word.length() > maxWidth) {
          lines.add(word.substring(0, maxWidth));
          word = word.substring(maxWidth);
        }
        currentLine.append(word);
      } else {
        if (currentLine.length() > 0) currentLine.append(" ");
        currentLine.append(word);
      }
    }

    if (currentLine.length() > 0) {
      lines.add(currentLine.toString().stripTrailing());
    }

    return lines;
  }
}
