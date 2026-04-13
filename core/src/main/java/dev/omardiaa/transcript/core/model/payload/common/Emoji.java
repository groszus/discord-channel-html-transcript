package dev.omardiaa.transcript.core.model.payload.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.stream.Collectors;

/**
 * <a href="https://docs.discord.com/developers/resources/emoji#emoji-object">Emoji</a>
 */
@NullMarked
public sealed interface Emoji permits Emoji.Unicode, Emoji.Custom {
  String name();

  @JsonCreator
  static Emoji create(
    @JsonProperty(value = "id") @Nullable String id,
    @JsonProperty(value = "name", required = true) String name
  ) {
    return id != null ? new Custom(id, name) : new Unicode(name);
  }

  record Custom(String id, String name) implements Emoji {
    public final static String CUSTOM_EMOJI = "https://cdn.discordapp.com/emojis/%s.webp?animated=true";

    /**
     * @return <a href="https://docs.discord.com/developers/reference#image-formatting">Formatted Emoji URL</a>
     */
    @JsonIgnore
    public String imageUrl() {
      return CUSTOM_EMOJI.formatted(id);
    }
  }

  record Unicode(String name) implements Emoji {
    /**
     * @return HTML Unicode Entity.
     */
    @JsonIgnore
    public String asUTF8() {
      return name
        .codePoints()
        .mapToObj(code -> "&#x" + Integer.toHexString(code) + ";")
        .collect(Collectors.joining());
    }
  }
}
