package dev.omardiaa.transcript.core.model.payload.common;

import com.fasterxml.jackson.annotation.*;
import org.jspecify.annotations.NonNull;

import java.util.stream.Collectors;

/**
 * Discord <a href="https://discord.com/developers/docs/resources/emoji#emoji-resource">Emoji</a>.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = Emoji.Unicode.class)
@JsonSubTypes({
  @JsonSubTypes.Type(value = Emoji.Unicode.class),
  @JsonSubTypes.Type(value = Emoji.Custom.class)
})
public sealed interface Emoji permits Emoji.Unicode, Emoji.Custom {
  String getName();

  final class Custom implements Emoji {
    public final static String CUSTOM_EMOJI = "https://cdn.discordapp.com/emojis/%s.webp?animated=true";

    private final String id;
    private final String name;

    @JsonCreator
    public Custom(
      @JsonProperty(value = "id", required = true) String id,
      @JsonProperty(value = "name", required = true) String name) {
      this.id = id;
      this.name = name;
    }

    public String getId() {
      return id;
    }

    @Override
    public String getName() {
      return name;
    }

    /**
     * @return <a href="https://discord.com/developers/docs/reference#image-formatting-cdn-endpoints">Formatted Emoji URL</a>.
     */
    @JsonIgnore
    public @NonNull String getImageUrl() {
      return CUSTOM_EMOJI.formatted(getId());
    }

    @Override
    public String toString() {
      return "Custom{" +
             "id='" + id + '\'' +
             ", name='" + name + '\'' +
             '}';
    }
  }

  final class Unicode implements Emoji {
    private final String name;

    @JsonCreator
    public Unicode(@JsonProperty(value = "name", required = true) String name) {
      this.name = name;
    }

    @Override
    public String getName() {
      return name;
    }

    /**
     * @return HTML Emoji.
     */
    @JsonIgnore
    public String getAsUTF8() {
      return name.codePoints().mapToObj(code -> "&#x" + Integer.toHexString(code) + ";").collect(Collectors.joining());
    }

    @Override
    public String toString() {
      return "Unicode{" +
             "name='" + name + '\'' +
             '}';
    }
  }
}
