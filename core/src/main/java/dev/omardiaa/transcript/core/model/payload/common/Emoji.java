package dev.omardiaa.transcript.core.model.payload.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jspecify.annotations.NullMarked;

import java.util.stream.Collectors;

/**
 * <a href="https://docs.discord.com/developers/resources/emoji#emoji-object">Emoji</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = Emoji.Unicode.class)
@JsonSubTypes({
  @JsonSubTypes.Type(value = Emoji.Unicode.class),
  @JsonSubTypes.Type(value = Emoji.Custom.class)
})
@NullMarked
public sealed interface Emoji permits Emoji.Unicode, Emoji.Custom {
  String name();

  record Custom(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "name", required = true) String name
  ) implements Emoji {
    public final static String CUSTOM_EMOJI = "https://cdn.discordapp.com/emojis/%s.webp?animated=true";

    /**
     * @return <a href="https://docs.discord.com/developers/reference#image-formatting">Formatted Emoji URL</a>
     */

    public @JsonIgnore String imageUrl() {
      return CUSTOM_EMOJI.formatted(id);
    }
  }

  record Unicode(
    @JsonProperty(value = "name", required = true) String name
  ) implements Emoji {
    /**
     * @return HTML Unicode Emoji.
     */
    public @JsonIgnore String asUTF8() {
      return name
        .codePoints()
        .mapToObj(code -> "&#x" + Integer.toHexString(code) + ";")
        .collect(Collectors.joining());
    }
  }
}
