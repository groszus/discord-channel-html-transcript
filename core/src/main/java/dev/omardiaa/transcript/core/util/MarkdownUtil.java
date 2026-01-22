package dev.omardiaa.transcript.core.util;

import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
import dev.omardiaa.transcript.core.model.payload.common.Role;
import dev.omardiaa.transcript.core.model.payload.message.User;
import gg.jte.html.escape.Escape;
import gg.jte.output.StringOutput;
import org.jspecify.annotations.NullMarked;

import java.util.ArrayList;
import java.util.List;
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

  // Standard
  private final static Pattern CODE_BLOCK = Pattern.compile("```(.*?)```", Pattern.DOTALL);
  private final static Pattern CODE_INLINE = Pattern.compile("`(?!`)(.*)`");

  private final static Pattern BOLD = Pattern.compile("\\*\\*(?!\\*)(.+?)\\*\\*");
  private final static Pattern UNDERLINE = Pattern.compile("__(?!_)(.+?)__");
  private final static Pattern ITALIC = Pattern.compile("[*_](?![*_])(.+?)[_*]");
  private final static Pattern STRIKE_THROUGH = Pattern.compile("~~(.+?)~~");
  private final static Pattern LINK = Pattern.compile("\\[(.*?)]\\((\\S*?)\\)");
  private final static Pattern TIMESTAMP = Pattern.compile("&lt;t:(\\d+)(?::[tTdDfFsSR])?&gt;");

  private final static Pattern HEADER_1 = Pattern.compile("^\\s*#\\s+(.+)", Pattern.MULTILINE);
  private final static Pattern HEADER_2 = Pattern.compile("^\\s*##\\s+(.+)", Pattern.MULTILINE);
  private final static Pattern HEADER_3 = Pattern.compile("^\\s*###\\s+(.+)", Pattern.MULTILINE);
  private final static Pattern SUBTEXT = Pattern.compile("^\\s*-#\\s+(.+)", Pattern.MULTILINE);

  // Extras
  private final static Pattern MENTION_USER = Pattern.compile("&lt;@(\\d+)&gt;");
  private final static Pattern MENTION_ROLE = Pattern.compile("&lt;@&amp;(\\d+)&gt;");
  private final static Pattern MENTION_CHANNEL = Pattern.compile("&lt;#(\\d+)&gt;");
  private final static Pattern MENTION_EVERYONE = Pattern.compile("@(everyone|here)");

  private final static Pattern CUSTOM_EMOJI = Pattern.compile("&lt;a?:(\\w+):(\\d+)&gt;");

  private MarkdownUtil() {}

  /**
   * Parses the specified {@code content} into styled HTML.
   *
   * @param content
   *   The content to parse.
   *
   * @return The styled HTML.
   */
  public static String parseMarkup(String content) {
    if (content.isBlank()) {
      return "";
    }

    List<String> codeMasks = new ArrayList<>();

    String current = CODE_BLOCK.matcher(content).replaceAll(m -> {
      codeMasks.add("<pre><code class=\"markup\" data-code-style=\"BLOCK\">%s</code></pre>".formatted(m.group(1)));
      return "{CODE_" + (codeMasks.size() - 1) + "}";
    });

    current = CODE_INLINE.matcher(current).replaceAll(m -> {
      codeMasks.add("<code class=\"markup\" data-code-style=\"INLINE\">%s</code>".formatted(m.group(1)));
      return "{CODE_" + (codeMasks.size() - 1) + "}";
    });

    current = escape(current).replaceAll("\n", "<br>\n");

    current = BOLD.matcher(current).replaceAll(m -> "<strong>$1</strong>");
    current = UNDERLINE.matcher(current).replaceAll(m -> "<u>$1</u>");
    current = ITALIC.matcher(current).replaceAll(m -> "<em>$1</em>");
    current = STRIKE_THROUGH.matcher(current).replaceAll(m -> "<s>$1</s>");
    current = LINK.matcher(current).replaceAll(m -> "<a href=\"$2\" target=\"_blank\" class=\"markup\">$1</a>");
    current = TIMESTAMP.matcher(current).replaceAll(
      m -> "<time class=\"markup\">%s</time>".formatted(TimeUtil.formatTimestamp(m.group(1))));

    current = HEADER_1.matcher(current).replaceAll(m -> "<h1 class=\"markup\">$1</h1>");
    current = HEADER_2.matcher(current).replaceAll(m -> "<h2 class=\"markup\">$1</h2>");
    current = HEADER_3.matcher(current).replaceAll(m -> "<h3 class=\"markup\">$1</h3>");
    current = SUBTEXT.matcher(current).replaceAll(m -> "<small class=\"markup\">$1</small>");

    current = MENTION_EVERYONE.matcher(current).replaceAll(m -> "<span class=\"mention\">@$1</span>");

    current = wrapTextNodes(current);

    for (int i = 0; i < codeMasks.size(); i++) {
      current = current.replace("{CODE_" + i + "}", codeMasks.get(i));
    }

    return current;
  }

  /**
   * Parses the specified {@code content} into styled HTML.
   *
   * @param guild
   *   The guild the message was sent in.
   * @param message
   *   The message that contains {@code content}.
   * @param content
   *   The content to parse.
   *
   * @return The styled HTML with extras.
   *
   * @see <a href="https://discord.com/developers/docs/reference#message-formatting">Message Formatting</a>
   */
  public static String parseMarkup(Guild guild, Message message, String content) {
    String current = parseMarkup(content);

    current = MENTION_USER.matcher(current).replaceAll(m -> {
      String userId = m.group(1);
      User user = message.getMentionsMap().get(userId);

      if (user == null) {
        return "<span class=\"mention\"><@%s></span>".formatted(userId);
      } else {
        return "<a href=\"https://discord.com/users/%s\" class=\"mention\">@%s</a>".formatted(
          userId, user.getGlobalName());
      }
    });

    current = MENTION_ROLE.matcher(current).replaceAll(m -> {
      String roleId = m.group(1);
      Role role = guild.getRolesMap().get(roleId);

      if (role == null) {
        return "<span class=\"mention\">@unknown-role</span>";
      } else {
        if (role.getColors().getPrimaryColor() == 0) {
          return "<span class=\"mention\">@%s</span>".formatted(role.getName());
        } else {
          return "<span class=\"mention\" style=\"color: #%1$06X; background-color: #%1$06X10;\" onmouseover=\"this.style.backgroundColor='#%1$06X30';\" onmouseout=\"this.style.backgroundColor='#%1$06X10';\">@%2$s</span>\n".formatted(
            role.getColors().getPrimaryColor(), role.getName());
        }
      }
    });

    current = MENTION_CHANNEL.matcher(current).replaceAll(m -> {
      return "<span class=\"mention\">%s<em>unknown</em></span>\n".formatted(SVG_CHANNEL_ICON);
      /* if (channel == null) {
         return "<span class=\"mention\">%s<em>unknown</em></span>\n".formatted(SVG_CHANNEL_ICON);
       } else {
         return "<a href=\"https:discord.com/channels/%s/%s\" class=\"mention\">%s<span class=\"mention__channel-name\">%s</span></a>\n".formatted(
           guild.getId(), channelId, SVG_CHANNEL_ICON, channel.getName());
       }*/
    });

    current = CUSTOM_EMOJI.matcher(current).replaceAll(m -> {
      String emojiName = m.group(1);
      String emojiUrl = Emoji.Custom.CUSTOM_EMOJI.formatted(m.group(2));

      return "<img src=\"%1$s\" alt=\"%2$s\" title=\"%2$s\" class=\"markup\"/>".formatted(emojiUrl, emojiName);
    });

    return current;
  }

  private static String escape(String input) {
    StringOutput output = new StringOutput();
    Escape.htmlContent(input, output);
    return output.toString();
  }

  private static String wrapTextNodes(String html) {
    StringBuilder sb = new StringBuilder();
    StringBuilder textBuffer = new StringBuilder();
    boolean insideTag = false;

    for (int i = 0; i < html.length(); i++) {
      char c = html.charAt(i);

      if (c == '<') {
        // Entering a tag.
        // 1. Flush any text we collected into a span
        if (!textBuffer.isEmpty()) {
          sb.append("<span>").append(textBuffer).append("</span>");
          textBuffer.setLength(0);
        }
        // 2. Start the tag
        insideTag = true;
        sb.append(c);
      } else if (c == '>') {
        // Exiting a tag
        insideTag = false;
        sb.append(c);
      } else {
        if (insideTag) {
          // Inside a tag (e.g. class="..."), just append
          sb.append(c);
        } else {
          // Outside a tag (Raw Text), buffer it
          textBuffer.append(c);
        }
      }
    }

    // Flush any remaining text at the end of the string
    if (!textBuffer.isEmpty()) {
      sb.append("<span>").append(textBuffer).append("</span>");
    }

    return sb.toString();
  }
}
