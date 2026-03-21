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
import java.util.regex.MatchResult;
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

  // Standard
  private final static Pattern CODE_BLOCK = Pattern.compile("```(.*?)```", Pattern.DOTALL);
  private final static Pattern CODE_INLINE = Pattern.compile("`(?!`)(.*)`");
  private final static Pattern BOLD = Pattern.compile("\\*\\*(?!\\*)(.+?)\\*\\*");
  private final static Pattern UNDERLINE = Pattern.compile("__(?!_)(.+?)__");
  private final static Pattern ITALIC = Pattern.compile("[*_](?![*_])(.+?)[_*]");
  private final static Pattern STRIKE_THROUGH = Pattern.compile("~~(.+?)~~");
  private final static Pattern LINK = Pattern.compile(
    "\\[(.*?)]\\((https?://[a-zA-Z0-9.-]+[/\\w .-]*/?)\\)|(https?://[a-zA-Z0-9.-]+[/\\w .-]*/?)");
  private final static Pattern HEADER = Pattern.compile("^\\s*(#{1,3})\\s+(.+)", Pattern.MULTILINE);
  private final static Pattern SUBTEXT = Pattern.compile("^\\s*-#\\s+(.+)", Pattern.MULTILINE);

  // Discord Markdown
  private final static Pattern TIMESTAMP = Pattern.compile("&lt;t:(\\d+)(?::[tTdDfFsSR])?&gt;");

  // Discord Markdown Extra
  private final static Pattern MENTION_USER = Pattern.compile("&lt;@(\\d+)&gt;");
  private final static Pattern MENTION_ROLE = Pattern.compile("&lt;@&amp;(\\d+)&gt;");
  private final static Pattern MENTION_CHANNEL = Pattern.compile("&lt;#(\\d+)&gt;");
  private final static Pattern MENTION_EVERYONE = Pattern.compile("@(everyone|here)");
  private final static Pattern CUSTOM_EMOJI = Pattern.compile("&lt;a?:(\\w+):(\\d+)&gt;");

  private MarkdownUtil() {}

  /**
   * Parses the provided {@code content} into styled HTML.
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

    current = BOLD.matcher(current).replaceAll("<strong>$1</strong>");

    current = UNDERLINE.matcher(current).replaceAll("<u>$1</u>");

    current = ITALIC.matcher(current).replaceAll("<em>$1</em>");

    current = STRIKE_THROUGH.matcher(current).replaceAll("<s>$1</s>");

    current = LINK.matcher(current).replaceAll(m -> {
      String markdownText = m.group(1);

      if (markdownText != null && markdownText.isBlank()) {
        return m.group(0);
      }

      String markdownUrl = m.group(2);
      String url = m.group(3);

      String href = markdownUrl != null ? markdownUrl : url;
      String text = markdownText != null ? markdownText : url;

      return "<a href=\"%s\" target=\"_blank\" class=\"markup\">%s</a>".formatted(href, text);
    });

    current = TIMESTAMP.matcher(current).replaceAll(
      m -> "<time class=\"markup\">%s</time>".formatted(TimeUtil.formatTimestamp(m.group(1))));

    current = HEADER.matcher(current).replaceAll(
      m -> "<h%1$s class=\"markup\">%2$s</h%1$s>".formatted(m.group(1).length(), m.group(2)));

    current = SUBTEXT.matcher(current).replaceAll("<small class=\"markup\">$1</small>");

    current = MENTION_EVERYONE.matcher(current).replaceAll("<span class=\"mention\">@$1</span>");

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
   * @see <a href="https://docs.discord.com/developers/reference#message-formatting">Message Formatting</a>
   */
  public static String parseMarkup(Guild guild, Message message, String content) {
    String current = parseMarkup(content);

    current = MENTION_USER.matcher(current).replaceAll(m -> parseMarkupUserMention(m, message));
    current = MENTION_ROLE.matcher(current).replaceAll(m -> parseMarkupRoleMention(m, guild));

    // parses to "unknown" since there's no reliable way to retrieve a guild's channels' names.
    current = MENTION_CHANNEL.matcher(current).replaceAll(
      m -> "<span class=\"mention\">%s<em>unknown</em></span>\n".formatted(SVG_CHANNEL_ICON));

    current = CUSTOM_EMOJI.matcher(current).replaceAll(
      m -> "<img src=\"%2$s\" alt=\"%1$s\" title=\"%1$s\" class=\"markup\">"
        .formatted(m.group(1), Emoji.Custom.CUSTOM_EMOJI.formatted(m.group(2))));

    return current;
  }

  private static String parseMarkupUserMention(MatchResult m, Message message) {
    String userId = m.group(1);
    User user = message.getMentionsMap().get(userId);

    if (user == null) {
      return Matcher.quoteReplacement("<span class=\"mention\"><@%s></span>".formatted(userId));
    }

    return Matcher.quoteReplacement(
      "<a href=\"https://discord.com/users/%s\" class=\"mention\">@%s</a>".formatted(userId, user.getGlobalName()));
  }

  private static String parseMarkupRoleMention(MatchResult m, Guild guild) {
    String roleId = m.group(1);
    Role role = guild.getRolesMap().get(roleId);

    if (role == null) {
      return "<span class=\"mention\">@unknown-role</span>";
    }

    int primaryColor = role.getColors().getPrimaryColor();

    if (primaryColor == 0) {
      return Matcher.quoteReplacement("<span class=\"mention\">@%s</span>".formatted(role.getName()));
    }

    String hexColor = Integer.toHexString(primaryColor);

    return Matcher.quoteReplacement(
      "<span class=\"mention\" style=\"color: #%1$s; background-color: #%1$s10;\" onmouseover=\"this.style.backgroundColor='#%1$s30';\" onmouseout=\"this.style.backgroundColor='#%1$s10';\">@%2$s</span>"
        .formatted(hexColor, role.getName()));
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
        if (!textBuffer.isEmpty()) {
          sb.append("<span>").append(textBuffer).append("</span>");
          textBuffer.setLength(0);
        }

        insideTag = true;
        sb.append(c);
      } else if (c == '>') {
        insideTag = false;
        sb.append(c);
      } else {
        if (insideTag) {
          sb.append(c);
        } else {
          textBuffer.append(c);
        }
      }
    }

    if (!textBuffer.isEmpty()) {
      sb.append("<span>").append(textBuffer).append("</span>");
    }

    return sb.toString();
  }
}
