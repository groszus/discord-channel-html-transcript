package dev.omardiaa.transcript.core.util;

import dev.omardiaa.transcript.core.exception.TranscriberException;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
import dev.omardiaa.transcript.core.model.payload.common.Role;
import dev.omardiaa.transcript.core.model.payload.message.User;
import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NullMarked
public final class MarkdownUtil {
  private static final String SVG_CHANNEL_ICON =
    """
    <svg
      xmlns="http://www.w3.org/2000/svg"
      viewBox="0 0 24 24"
      fill="currentColor"
      class="mention__channel-icon"
    >
      <path
        fill-rule="evenodd"
        d="M10.99 3.16A1 1 0 1 0 9 2.84L8.15 8H4a1 1 0 0 0 0 2h3.82l-.67 4H3a1 1 0 1 0 0 2h3.82l-.8 4.84a1 1 0 0 0 1.97.32L8.85 16h4.97l-.8 4.84a1 1 0 0 0 1.97.32l.86-5.16H20a1 1 0 1 0 0-2h-3.82l.67-4H21a1 1 0 1 0 0-2h-3.82l.8-4.84a1 1 0 1 0-1.97-.32L15.15 8h-4.97l.8-4.84ZM14.15 14l.67-4H9.85l-.67 4h4.97Z"
      />
    </svg>
    """;

  // Standard Markdown
  private final static Pattern CODE_BLOCK = Pattern.compile("```(.*?)```", Pattern.DOTALL);
  private final static Pattern CODE_INLINE = Pattern.compile("`(?!`)(.*)`");

  private final static Pattern BOLD = Pattern.compile("\\*\\*(?!\\*)(.+?)\\*\\*");
  private final static Pattern UNDERLINE = Pattern.compile("__(?!_)(.+?)__");
  private final static Pattern ITALIC = Pattern.compile("[*_](?![*_])(.+?)[_*]");
  private final static Pattern STRIKE_THROUGH = Pattern.compile("~~(.+?)~~");
  private final static Pattern LINK = Pattern.compile(
    "\\[(.*?)]\\((https?://[\\w.:/?#\\[\\]@-]*)\\)|(https?://[\\w.:/?#\\[\\]@-]*)");

  private final static Pattern HEADER = Pattern.compile("^\\s*(#{1,3})\\s+(.+)", Pattern.MULTILINE);
  private final static Pattern SUBTEXT = Pattern.compile("^\\s*-#\\s+(.+)", Pattern.MULTILINE);
  private final static Pattern QUOTE = Pattern.compile("^(&gt; .+(?:\\n&gt; .+)*)", Pattern.MULTILINE);

  // Discord Markdown
  private final static Pattern MENTION_USER = Pattern.compile("&lt;@(\\d+)&gt;");
  private final static Pattern MENTION_ROLE = Pattern.compile("&lt;@&amp;(\\d+)&gt;");
  private final static Pattern MENTION_CHANNEL = Pattern.compile("&lt;#(\\d+)&gt;");
  private final static Pattern MENTION_EVERYONE = Pattern.compile("@(everyone|here)");
  private final static Pattern CUSTOM_EMOJI = Pattern.compile("&lt;a?:(\\w+):(\\d+)&gt;");
  private final static Pattern TIMESTAMP = Pattern.compile("&lt;t:(\\d+)(?::[tTdDfFsSR])?&gt;");

  private MarkdownUtil() {}

  /**
   * Parses the provided {@code content} into markdown as HTML.
   *
   * @param content
   *   the content to parse.
   *
   * @return the markdown as HTML.
   *
   * @throws TranscriberException
   *   if the provided {@code content} is blank.
   */
  public static String parseMarkup(String content) {
    if (content.isBlank()) {
      throw new TranscriberException("Received empty content.");
    }

    boolean hasCode = CODE_BLOCK.asPredicate().test(content) || CODE_INLINE.asPredicate().test(content);
    Map<String, String> codeMasks = hasCode ? new HashMap<>() : null;

    if (hasCode) {
      content = CODE_BLOCK.matcher(content).replaceAll(m -> {
        String codeMaskId = "%%" + (codeMasks.size() + 1) + "%%";

        String codeBlock = HtmlBuilder
          .create("code")
          .attribute("data-code-style", "BLOCK")
          .build(m.group(1));

        codeMasks.put(
          codeMaskId,
          HtmlBuilder.create("pre").build(codeBlock));

        return codeMaskId;
      });

      content = CODE_INLINE.matcher(content).replaceAll(m -> {
        String code = "%%" + (codeMasks.size() + 1) + "%%";

        codeMasks.put(
          code,
          HtmlBuilder
            .create("code")
            .attribute("data-code-style", "INLINE")
            .build(m.group(1)));

        return code;
      });
    }

    content = StringUtil.escape(content).replace("\n", "<br>\n");

    content = BOLD.matcher(content).replaceAll(m -> HtmlBuilder.create("strong").build(m.group(1)));
    content = UNDERLINE.matcher(content).replaceAll(m -> HtmlBuilder.create("u").build(m.group(1)));
    content = ITALIC.matcher(content).replaceAll(m -> HtmlBuilder.create("em").build(m.group(1)));
    content = STRIKE_THROUGH.matcher(content).replaceAll(m -> HtmlBuilder.create("s").build(m.group(1)));

    content = LINK.matcher(content).replaceAll(m -> {
      String markdownText = m.group(1);

      if (markdownText != null && markdownText.isBlank()) {
        return m.group(0);
      }

      String markdownUrl = m.group(2);
      String url = m.group(3);

      String href = markdownUrl != null ? markdownUrl : url;
      String text = markdownText != null ? markdownText : url;

      return HtmlBuilder
        .create("a")
        .attribute("href", href)
        .attribute("target", "_blank")
        .build(text);
    });

    content = TIMESTAMP.matcher(content).replaceAll(
      m -> HtmlBuilder
        .create("time")
        .build(TimeUtil.formatTimestamp(m.group(1))));

    content = HEADER.matcher(content).replaceAll(
      m -> HtmlBuilder
        .create("h" + m.group(1).length())
        .build(m.group(2)));

    content = SUBTEXT.matcher(content).replaceAll(
      m -> HtmlBuilder
        .create("s")
        .build(m.group(1)));

    content = QUOTE.matcher(content).replaceAll(
      m -> HtmlBuilder
        .create("blockquote")
        .build(m.group(1).replace("&gt; ", "")));

    content = MENTION_EVERYONE.matcher(content).replaceAll(
      m -> HtmlBuilder
        .create("span")
        .classes("mention")
        .build("@" + m.group(1)));

    content = wrapText(content);

    if (hasCode) {
      for (Map.Entry<String, String> mask : codeMasks.entrySet()) {
        content = content.replace(mask.getKey(), mask.getValue());
      }
    }

    return content;
  }

  /**
   * Parses the provided {@code content} into Discord's extra markdown as HTML.
   *
   * @param guild
   *   the guild the {@code message} belongs to.
   * @param message
   *   the message that contains {@code content}.
   * @param content
   *   the content to parse.
   *
   * @return Discord's extra markdown as HTML.
   *
   * @throws TranscriberException
   *   if the provided {@code content} is blank.
   * @see <a href="https://docs.discord.com/developers/reference#message-formatting">Message Formatting</a>
   */
  public static String parseMarkup(Guild guild, Message message, String content) {
    content = parseMarkup(content);

    content = MENTION_USER.matcher(content).replaceAll(
      m -> {
        String userId = m.group(1);
        User user = Optional.ofNullable(message.mentionsMap()).map(mentions -> mentions.get(userId)).orElse(null);

        if (user == null) {
          return HtmlBuilder.create("span").classes("mention").build("<@" + userId + ">");
        }

        return HtmlBuilder
          .create("a")
          .attribute("href", "https://discord.com/users/" + userId)
          .classes("mention")
          .build(Matcher.quoteReplacement("@" + user.globalName()));
      });

    content = MENTION_ROLE.matcher(content).replaceAll(
      m -> {
        Role role = guild.rolesMap().get(m.group(1));

        if (role == null) {
          return HtmlBuilder.create("span").classes("mention").build("@unknown-role");
        }

        int primaryColor = role.colors().primaryColor();

        if (primaryColor == 0) {
          return HtmlBuilder.create("span").classes("mention").build("@" + Matcher.quoteReplacement(role.name()));
        }

        String hexColor = Integer.toHexString(primaryColor);

        return HtmlBuilder
          .create("span")
          .attribute("style", "color: #" + hexColor + "; background-color: #" + hexColor + "10;")
          .attribute("onmouseover", "this.style.backgroundColor='#" + hexColor + "30';")
          .attribute("onmouseout", "this.style.backgroundColor='#" + hexColor + "10';")
          .classes("mention")
          .build(Matcher.quoteReplacement(role.name()));
      });

    // parses to "unknown" since there's no reliable way to retrieve a guild's channels' names.
    content = MENTION_CHANNEL.matcher(content).replaceAll(
      m -> HtmlBuilder
        .create("span")
        .classes("mention")
        .build(SVG_CHANNEL_ICON + "<i>unknown</i>"));

    content = CUSTOM_EMOJI.matcher(content).replaceAll(
      m -> {
        String name = m.group(1);
        String src = Emoji.Custom.CUSTOM_EMOJI_URL.formatted(m.group(2));

        return HtmlBuilder
          .create("img")
          .attribute("title", name)
          .attribute("alt", name)
          .attribute("src", src)
          .build();
      });

    return content;
  }

  private static String wrapText(String html) {
    int length = html.length();

    StringBuilder output = new StringBuilder(length + 32);
    StringBuilder buffer = new StringBuilder();

    boolean insideTag = false;

    for (int i = 0; i < length; i++) {
      char c = html.charAt(i);

      switch (c) {
        case '<' -> {
          flushBuffer(output, buffer);
          insideTag = true;
          output.append(c);
        }
        case '>' -> {
          insideTag = false;
          output.append(c);
        }
        default -> {
          if (insideTag) {
            output.append(c);
          } else {
            buffer.append(c);
          }
        }
      }
    }

    flushBuffer(output, buffer);
    return output.toString();
  }

  private static void flushBuffer(StringBuilder output, StringBuilder buffer) {
    if (buffer.isEmpty()) {
      return;
    }

    if (isBufferBlank(buffer)) {
      output.append(buffer);
    } else {
      output.append("<span>").append(buffer).append("</span>");
    }

    buffer.setLength(0);
  }

  /**
   * Checks if a StringBuilder is blank without allocating new Strings.
   */
  private static boolean isBufferBlank(StringBuilder sb) {
    for (int i = 0; i < sb.length(); i++) {
      if (!Character.isWhitespace(sb.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
