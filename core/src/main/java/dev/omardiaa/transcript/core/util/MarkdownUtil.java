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
import java.util.function.Predicate;
import java.util.regex.Pattern;

@NullMarked
public final class MarkdownUtil {
  private static final String SVG_CHANNEL_ICON =
    """
    <svg
      viewBox="0 0 24 24"
      height="16"
      width="16"
    >
      <path
        fill-rule="evenodd"
        d="M10.99 3.16A1 1 0 1 0 9 2.84L8.15 8H4a1 1 0 0 0 0 2h3.82l-.67 4H3a1 1 0 1 0 0 2h3.82l-.8 4.84a1 1 0 0 0 1.97.32L8.85 16h4.97l-.8 4.84a1 1 0 0 0 1.97.32l.86-5.16H20a1 1 0 1 0 0-2h-3.82l.67-4H21a1 1 0 1 0 0-2h-3.82l.8-4.84a1 1 0 1 0-1.97-.32L15.15 8h-4.97l.8-4.84ZM14.15 14l.67-4H9.85l-.67 4h4.97Z"
      />
    </svg>
    """;

  private static final Pattern CODE_BLOCK = Pattern.compile("```(.*?)```", Pattern.DOTALL);
  private static final Pattern CODE_INLINE = Pattern.compile("`(?!`)(.*)`");

  private static final Pattern BOLD = Pattern.compile("\\*\\*(?!\\*)(.+?)\\*\\*");
  private static final Pattern UNDERLINE = Pattern.compile("__(?!_)(.+?)__");
  private static final Pattern ITALIC = Pattern.compile("[*_](?![*_])(.+?)[_*]");
  private static final Pattern STRIKE_THROUGH = Pattern.compile("~~(.+?)~~");
  private static final Pattern LINK = Pattern.compile(
    "\\[(.*?)]\\((https?://[\\w.:/?#\\[\\]@-]*)\\)|(https?://[\\w.:/?#\\[\\]@-]*)");

  private static final Pattern HEADER = Pattern.compile("^\\s*(#{1,3})\\s+(.+)", Pattern.MULTILINE);
  private static final Pattern SUBTEXT = Pattern.compile("^\\s*-#\\s+(.+)", Pattern.MULTILINE);
  private static final Pattern QUOTE = Pattern.compile("^(&gt; .+(?:\\n&gt; .+)*)", Pattern.MULTILINE);

  private static final Pattern MENTION_USER = Pattern.compile("&lt;@(\\d+)&gt;");
  private static final Pattern MENTION_ROLE = Pattern.compile("&lt;@&amp;(\\d+)&gt;");
  private static final Pattern MENTION_CHANNEL = Pattern.compile("&lt;#(\\d+)&gt;");
  private static final Pattern MENTION_EVERYONE = Pattern.compile("@(everyone|here)");
  private static final Pattern CUSTOM_EMOJI = Pattern.compile("&lt;a?:(\\w+):(\\d+)&gt;");
  private static final Pattern TIMESTAMP = Pattern.compile("&lt;t:(\\d+)(?::[tTdDfFsSR])?&gt;");

  private static final Pattern NEWLINE = Pattern.compile("\n");
  private static final Pattern CODE_MASK = Pattern.compile("%%\\d+%%");

  private static final Predicate<String> CONTAINS_CODE = CODE_BLOCK.asPredicate().or(CODE_INLINE.asPredicate());

  private MarkdownUtil() {}

  /**
   * Parses the provided markdown {@code input} as HTML.
   *
   * @param input
   *   the markup input to parse.
   *
   * @return the markdown as HTML.
   *
   * @throws TranscriberException
   *   if the provided {@code input} is blank.
   */
  public static String parseMarkup(String input) {
    if (input.isBlank()) {
      throw new TranscriberException("Received empty markdown input.");
    }

    CharSequence sequence = StringUtil.escape(input);

    Map<String, String> codeMasksMap = CONTAINS_CODE.test(input) ? new HashMap<>() : null;

    if (codeMasksMap != null) {
      sequence = StringUtil.replace(
        CODE_BLOCK, sequence, m -> {
          String id = "%%" + (codeMasksMap.size() + 1) + "%%";

          String code = HtmlBuilder
            .create("code")
            .attribute("data-code-style", "BLOCK")
            .build(m.group(1));

          codeMasksMap.put(id, HtmlBuilder.create("pre").build(code));

          return id;
        }
      );

      sequence = StringUtil.replace(
        CODE_INLINE, sequence, m -> {
          String id = "%%" + (codeMasksMap.size() + 1) + "%%";

          codeMasksMap.put(
            id,
            HtmlBuilder
              .create("code")
              .attribute("data-code-style", "INLINE")
              .build(m.group(1))
          );

          return id;
        }
      );
    }

    sequence = StringUtil.replace(NEWLINE, sequence, m -> "<br>\n");

    sequence = StringUtil.replace(BOLD, sequence, m -> HtmlBuilder.create("b").build(m.group(1)));
    sequence = StringUtil.replace(UNDERLINE, sequence, m -> HtmlBuilder.create("u").build(m.group(1)));
    sequence = StringUtil.replace(ITALIC, sequence, m -> HtmlBuilder.create("em").build(m.group(1)));
    sequence = StringUtil.replace(STRIKE_THROUGH, sequence, m -> HtmlBuilder.create("s").build(m.group(1)));

    sequence = StringUtil.replace(
      LINK, sequence, m -> {
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
      }
    );

    sequence = StringUtil.replace(
      TIMESTAMP, sequence, m -> HtmlBuilder
        .create("time")
        .build(TimeUtil.formatTimestamp(m.group(1)))
    );

    sequence = StringUtil.replace(
      HEADER, sequence, m -> HtmlBuilder
        .create("h" + m.group(1).length())
        .build(m.group(2))
    );

    sequence = StringUtil.replace(
      SUBTEXT, sequence, m -> HtmlBuilder
        .create("s")
        .build(m.group(1))
    );

    sequence = StringUtil.replace(
      QUOTE, sequence, m -> HtmlBuilder
        .create("blockquote")
        .build(m.group(1).replace("&gt; ", ""))
    );

    sequence = StringUtil.replace(
      MENTION_EVERYONE, sequence, m -> HtmlBuilder
        .create("span")
        .classes("mention")
        .build("@" + m.group(1))
    );

    if (codeMasksMap != null && !codeMasksMap.isEmpty()) {
      sequence = StringUtil.replace(CODE_MASK, sequence, m -> codeMasksMap.get(m.group(0)));
    }

    return sequence.toString();
  }

  /**
   * Parses the provided Discord extra markdown {@code input} as HTML.
   *
   * @param guild
   *   the guild the {@code message} belongs to.
   * @param message
   *   the message that contains {@code input}.
   * @param input
   *   the markup input to parse.
   *
   * @return Discord extra markdown as HTML.
   *
   * @throws TranscriberException
   *   if the provided {@code input} is blank.
   * @see <a href="https://docs.discord.com/developers/reference#message-formatting">Message Formatting</a>
   */
  public static String parseMarkup(Guild guild, Message message, String input) {
    CharSequence sequence = parseMarkup(input);

    sequence = StringUtil.replace(
      MENTION_USER, sequence, m -> {
        String userId = m.group(1);
        User user = message.mentionsMap().get(userId);

        if (user == null) {
          return HtmlBuilder.create("span").classes("mention").build("<@" + userId + ">");
        }

        return HtmlBuilder
          .create("a")
          .attribute("href", "https://discord.com/users/" + userId)
          .classes("mention")
          .build("@" + user.globalName());
      }
    );

    sequence = StringUtil.replace(
      MENTION_ROLE, sequence, m -> {
        Role role = guild.rolesMap().get(m.group(1));

        if (role == null) {
          return HtmlBuilder.create("span").classes("mention").build("@unknown-role");
        }

        int primaryColor = role.colors().primaryColor();

        if (primaryColor == 0) {
          return HtmlBuilder.create("span").classes("mention").build("@" + role.name());
        }

        String hexColor = Integer.toHexString(primaryColor);

        return HtmlBuilder
          .create("span")
          .attribute("style", "color: #" + hexColor + "; background-color: #" + hexColor + "10;")
          .attribute("onmouseover", "this.style.backgroundColor='#" + hexColor + "30';")
          .attribute("onmouseout", "this.style.backgroundColor='#" + hexColor + "10';")
          .classes("mention")
          .build("@" + role.name());
      }
    );

    // parses to "unknown" since there's no reliable way to retrieve a guild's channels' names.
    sequence = StringUtil.replace(
      MENTION_CHANNEL, sequence, m -> HtmlBuilder
        .create("span")
        .classes("mention")
        .build(SVG_CHANNEL_ICON + "<i>unknown</i>")
    );

    sequence = StringUtil.replace(
      CUSTOM_EMOJI, sequence, m -> {
        String name = m.group(1);
        String src = Emoji.Custom.CUSTOM_EMOJI_URL.formatted(m.group(2));

        return HtmlBuilder
          .create("img")
          .attribute("title", name)
          .attribute("alt", name)
          .attribute("src", src)
          .build();
      }
    );

    return sequence.toString();
  }
}
