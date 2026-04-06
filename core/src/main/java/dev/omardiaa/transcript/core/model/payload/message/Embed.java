package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://docs.discord.com/developers/resources/message#embed-object">Embed</a>
 */
@NullMarked
public record Embed(
  @Nullable String title,
  Type type,
  @Nullable String description,
  @Nullable String url,
  @Nullable OffsetDateTime timestamp,
  @Nullable String color,
  @Nullable Footer footer,
  @Nullable Image image,
  @Nullable Thumbnail thumbnail,
  @Nullable Video video,
  @Nullable Author author,
  @Nullable List<Field> fields
) {
  @JsonCreator
  public Embed(
    @JsonProperty(value = "title") @Nullable String title,
    @JsonProperty(value = "type") @Nullable Type type,
    @JsonProperty(value = "description") @Nullable String description,
    @JsonProperty(value = "url") @Nullable String url,
    @JsonProperty(value = "timestamp") @Nullable OffsetDateTime timestamp,
    @JsonProperty(value = "color") @Nullable Integer color,
    @JsonProperty(value = "footer") @Nullable Footer footer,
    @JsonProperty(value = "image") @Nullable Image image,
    @JsonProperty(value = "thumbnail") @Nullable Thumbnail thumbnail,
    @JsonProperty(value = "video") @Nullable Video video,
    @JsonProperty(value = "author") @Nullable Author author,
    @JsonProperty(value = "fields") @Nullable List<Field> fields
  ) {
    this(
      title,
      type != null ? type : Type.UNKNOWN,
      description,
      url,
      timestamp,
      color != null ? String.format("#%06X", (0xFFFFFF & color)) : null,
      footer,
      image,
      thumbnail,
      video,
      author,
      fields);
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/message#embed-object-embed-types">Embed Types</a>
   */
  public enum Type {
    UNKNOWN("unknown"), RICH("rich"), GIFV("gifv"), ARTICLE("article");

    private static final Map<String, Type> TYPE_MAP = Arrays
      .stream(values()).collect(Collectors.toUnmodifiableMap(Type::getValue, Function.identity()));

    private final String value;

    Type(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @JsonCreator
    public static Type fromType(@Nullable String type) {
      return TYPE_MAP.getOrDefault(type, UNKNOWN);
    }
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/message#embed-object-embed-footer-structure">Embed Footer</a>
   */
  public record Footer(
    String text,
    @Nullable String iconUrl
  ) {
    @JsonCreator
    public Footer(
      @JsonProperty(value = "text", required = true) String text,
      @JsonProperty(value = "icon_url") @Nullable String iconUrl
    ) {
      this.text = Check.lengthMax(text, "text", 2048);
      this.iconUrl = iconUrl;
    }
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/message#embed-object-embed-image-structure">Embed Image</a>
   */
  public record Image(
    String url
  ) {
    @JsonCreator
    public Image(
      @JsonProperty(value = "url", required = true) String url
    ) {
      this.url = url;
    }
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/message#embed-object-embed-thumbnail-structure">Embed Thumbnail</a>
   */
  public record Thumbnail(
    String url
  ) {
    @JsonCreator
    public Thumbnail(
      @JsonProperty(value = "url", required = true) String url
    ) {
      this.url = url;
    }
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/message#embed-object-embed-video-structure">Embed Video</a>
   */
  public record Video(
    String url
  ) {
    @JsonCreator
    public Video(
      @JsonProperty(value = "url", required = true) String url
    ) {
      this.url = url;
    }
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/message#embed-object-embed-author-structure">Embed Author</a>
   */
  public record Author(
    String name,
    @Nullable String url,
    @Nullable String iconUrl
  ) {
    @JsonCreator
    public Author(
      @JsonProperty(value = "name", required = true) String name,
      @JsonProperty(value = "url") @Nullable String url,
      @JsonProperty(value = "icon_url") @Nullable String iconUrl
    ) {
      this.name = Check.lengthMax(name, "name", 256);
      this.url = url;
      this.iconUrl = iconUrl;
    }
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/message#embed-object-embed-field-structure">Embed Field</a>
   */
  public record Field(
    String name,
    String value,
    boolean inline
  ) {
    @JsonCreator
    public Field(
      @JsonProperty(value = "name", required = true) String name,
      @JsonProperty(value = "value", required = true) String value,
      @JsonProperty(value = "inline") @Nullable Boolean inline
    ) {
      this(
        Check.lengthMax(name, "name", 256),
        Check.lengthMax(value, "value", 1024),
        inline != null ? inline : false);
    }
  }
}
