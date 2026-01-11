package dev.omardiaa.transcript.schema.payload.util;

import com.fasterxml.jackson.annotation.*;
import org.jspecify.annotations.NonNull;

import java.util.stream.Collectors;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = Emoji.Unicode.class)
@JsonSubTypes({
  @JsonSubTypes.Type(value = Emoji.Unicode.class),
  @JsonSubTypes.Type(value = Emoji.Custom.class)})
public sealed interface Emoji permits Emoji.Unicode, Emoji.Custom {
  String getName();

  final class Custom implements Emoji {
    public final static String CUSTOM_EMOJI = "https://cdn.discordapp.com/emojis/%s.webp?animated=true";

    private final String id;
    private final String name;

    @JsonCreator
    public Custom(
      @JsonProperty("id") String id,
      @JsonProperty("name") String name) {
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
     * Helper Method
     *
     * @return {@link String} - Emoji Image URL
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
    public Unicode(@JsonProperty("name") String name) {
      this.name = name;
    }

    @Override
    public String getName() {
      return name;
    }

    /**
     * Helper Method
     *
     * @return {@link String} - Emoji as HTML Emoji
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
