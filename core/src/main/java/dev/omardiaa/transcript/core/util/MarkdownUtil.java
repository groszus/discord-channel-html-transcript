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
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NullMarked
public final class MarkdownUtil {
  private MarkdownUtil() {}

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

  private final static Pattern CODE_BLOCK = Pattern.compile("```\\n(.*)\\n```", Pattern.DOTALL);
  private final static Pattern CODE_INLINE = Pattern.compile("`(?!`)(.*)`");

  private final static Pattern BOLD = Pattern.compile("\\*\\*(?!\\*)(.+?)\\*\\*");
  private final static Pattern UNDERLINE = Pattern.compile("__(?!_)(.+?)__");
  private final static Pattern ITALIC = Pattern.compile("[*_](?![*_])(.+?)[_*]");
  private final static Pattern STRIKE_THROUGH = Pattern.compile("~~(.+?)~~");
  private final static Pattern LINK = Pattern.compile("\\[(.*?)]\\((\\S*?)\\)");

  private final static Pattern HEADER_1 = Pattern.compile("^#\\s+(.*)", Pattern.MULTILINE);
  private final static Pattern HEADER_2 = Pattern.compile("^#{2}\\s+(.*)", Pattern.MULTILINE);
  private final static Pattern HEADER_3 = Pattern.compile("^#{3}\\s+(.*)", Pattern.MULTILINE);
  private final static Pattern SUBTEXT = Pattern.compile("^-#\\s+(.*)", Pattern.MULTILINE);

  private final static Pattern MENTION_USER = Pattern.compile("&lt;@(\\d+)&gt;");
  private final static Pattern MENTION_ROLE = Pattern.compile("&lt;@&amp;(\\d+)&gt;");
  private final static Pattern MENTION_CHANNEL = Pattern.compile("&lt;#(\\d+)&gt;");
  private final static Pattern MENTION_EVERYONE = Pattern.compile("@(everyone|here)");

  private final static Pattern CUSTOM_EMOJI = Pattern.compile("&lt;a?:(\\w+):(\\d+)&gt;");

  public static String parseMarkup(Guild guild, Message message, String content) {
    if (content.isEmpty()) {
      return "";
    }

    List<String> codeMasks = new ArrayList<>();

    String current = replace(
      content, CODE_BLOCK, m -> {
        codeMasks.add("<code class=\"markup\" data-code-style=\"block\">%s</code>".formatted(m.group(1)));
        return "{CODE_" + (codeMasks.size() - 1) + "}";
      });

    current = replace(
      current, CODE_INLINE, m -> {
        codeMasks.add("<code class=\"markup\" data-code-style=\"inline\">%s</code>".formatted(m.group(1)));
        return "{CODE_" + (codeMasks.size() - 1) + "}";
      });

    current = escape(current).replaceAll("\n", "<br>\n");

    current = replace(current, BOLD, m -> "<strong>%s</strong>".formatted(m.group(1)));
    current = replace(current, UNDERLINE, m -> "<u>%s</u>".formatted(m.group(1)));
    current = replace(current, ITALIC, m -> "<em>%s</em>".formatted(m.group(1)));
    current = replace(current, STRIKE_THROUGH, m -> "<s>%s</s>".formatted(m.group(1)));
    current = replace(current, LINK, m -> "<a href=\"%s\" class=\"markup\">%s</a>".formatted(m.group(2), m.group(1)));

    current = replace(current, HEADER_1, m -> "<h1 class=\"markup\">%s</h1>".formatted(m.group(1)));
    current = replace(current, HEADER_2, m -> "<h2 class=\"markup\">%s</h2>".formatted(m.group(1)));
    current = replace(current, HEADER_3, m -> "<h3 class=\"markup\">%s</h3>".formatted(m.group(1)));
    current = replace(current, SUBTEXT, m -> "<small class=\"markup\">%s</small>".formatted(m.group(1)));

    current = replace(current, MENTION_EVERYONE, m -> "<span class=\"mention\">@%s</span>".formatted(m.group(1)));

    current = replace(
      current, MENTION_USER, m -> {
        String userId = m.group(1);
        User user = message.getMentionsMap().get(userId);

        if (user == null) {
          return "<span class=\"mention\"><@%s></span>".formatted(userId);
        } else {
          return "<a href=\"https://discord.com/users/%s\" class=\"mention\">@%s</a>".formatted(
            userId, user.getGlobalName());
        }
      });

    current = replace(
      current, MENTION_ROLE, m -> {
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

    current = replace(
      current, MENTION_CHANNEL, m -> {
        return "<span class=\"mention\">%s<em>unknown</em></span>\n".formatted(SVG_CHANNEL_ICON);
        /* if (channel == null) {
           return "<span class=\"mention\">%s<em>unknown</em></span>\n".formatted(SVG_CHANNEL_ICON);
         } else {
           return "<a href=\"https:discord.com/channels/%s/%s\" class=\"mention\">%s<span class=\"mention__channel-name\">%s</span></a>\n".formatted(
             guild.getId(), channelId, SVG_CHANNEL_ICON, channel.getName());
         }*/
      });

    current = replace(
      current, CUSTOM_EMOJI, m -> {
        String emojiName = m.group(1);
        String emojiUrl = Emoji.Custom.CUSTOM_EMOJI.formatted(m.group(2));

        return "<img src=\"%1$s\" alt=\"%2$s\" title=\"%2$s\" class=\"markup\"/>".formatted(emojiUrl, emojiName);
      });

    for (int i = 0; i < codeMasks.size(); i++) {
      current = current.replace("{CODE_" + i + "}", codeMasks.get(i));
    }

    return current.replaceAll("\n", "");
  }

  private static String replace(String input, Pattern pattern, Function<Matcher, String> replacementFunc) {
    Matcher matcher = pattern.matcher(input);
    StringBuilder sb = new StringBuilder();

    while (matcher.find()) {
      String replacement = replacementFunc.apply(matcher);
      matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
    }

    matcher.appendTail(sb);
    return sb.toString();
  }

  private static String escape(String input) {
    StringOutput output = new StringOutput();
    Escape.htmlContent(input, output);
    return output.toString();
  }
}
