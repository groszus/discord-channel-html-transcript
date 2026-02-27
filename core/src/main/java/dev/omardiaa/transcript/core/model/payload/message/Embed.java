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
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object">Embed</a>.
 */
@NullMarked
public class Embed {
  private final @Nullable String title;
  private final Type type;
  private final @Nullable String description;
  private final @Nullable String url;
  private final @Nullable OffsetDateTime timestamp;
  private final @Nullable String color;
  private final @Nullable Footer footer;
  private final @Nullable Image image;
  private final @Nullable Thumbnail thumbnail;
  private final @Nullable Video video;
  private final @Nullable Author author;
  private final @Nullable List<Field> fields;

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
    @JsonProperty(value = "fields") @Nullable List<Field> fields) {
    this.title = title;
    this.type = Objects.requireNonNullElse(type, Type.UNKNOWN);
    this.description = description;
    this.url = url;
    this.timestamp = timestamp;
    this.color = (color == null) ? null : String.format("#%06X", (0xFFFFFF & color));
    this.footer = footer;
    this.image = image;
    this.thumbnail = thumbnail;
    this.video = video;
    this.author = author;
    this.fields = fields;
  }

  public @Nullable String getTitle() {
    return title;
  }

  public Type getType() {
    return type;
  }

  public @Nullable String getDescription() {
    return description;
  }

  public @Nullable String getUrl() {
    return url;
  }

  public @Nullable OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public @Nullable String getColor() {
    return color;
  }

  public @Nullable Footer getFooter() {
    return footer;
  }

  public @Nullable Image getImage() {
    return image;
  }

  public @Nullable Thumbnail getThumbnail() {
    return thumbnail;
  }

  public @Nullable Video getVideo() {
    return video;
  }

  public @Nullable Author getAuthor() {
    return author;
  }

  public @Nullable List<Field> getFields() {
    return fields;
  }

  @Override
  public String toString() {
    return "Embed{" +
           "title='" + title + '\'' +
           ", type=" + type +
           ", description='" + description + '\'' +
           ", url='" + url + '\'' +
           ", timestamp=" + timestamp +
           ", color='" + color + '\'' +
           ", footer=" + footer +
           ", image=" + image +
           ", thumbnail=" + thumbnail +
           ", video=" + video +
           ", author=" + author +
           ", fields=" + fields +
           '}';
  }

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-types">Embed Types</a>.
   */
  @NullMarked
  public enum Type {
    UNKNOWN("unknown"),
    RICH("rich"),
    GIFV("gifv"),
    ARTICLE("article");

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
   * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-footer-structure">Embed Footer</a>.
   */
  @NullMarked
  public static class Footer {
    private final String text;
    private final @Nullable String iconUrl;

    @JsonCreator
    public Footer(
      @JsonProperty(value = "text", required = true) String text,
      @JsonProperty(value = "icon_url") @Nullable String iconUrl) {
      this.text = Check.lengthMax(text, 2048, "text");
      this.iconUrl = iconUrl;
    }

    public String getText() {
      return text;
    }

    public @Nullable String getIconUrl() {
      return iconUrl;
    }

    @Override
    public String toString() {
      return "Footer{" +
             "text='" + text + '\'' +
             ", iconUrl='" + iconUrl + '\'' +
             '}';
    }
  }

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-image-structure">Embed Image</a>.
   */
  @NullMarked
  public static class Image {
    private final String url;

    @JsonCreator
    public Image(@JsonProperty(value = "url", required = true) String url) {
      this.url = url;
    }

    public String getUrl() {
      return url;
    }

    @Override
    public String toString() {
      return "Image{" +
             "url='" + url + '\'' +
             '}';
    }
  }

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-thumbnail-structure">Embed Thumbnail</a>.
   */
  @NullMarked
  public static class Thumbnail {
    private final String url;

    @JsonCreator
    public Thumbnail(@JsonProperty(value = "url", required = true) String url) {
      this.url = url;
    }

    public String getUrl() {
      return url;
    }

    @Override
    public String toString() {
      return "Thumbnail{" +
             "url='" + url + '\'' +
             '}';
    }
  }

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-video-structure">Embed Video</a>.
   */
  @NullMarked
  public static class Video {
    private final @Nullable String url;

    @JsonCreator
    public Video(@JsonProperty(value = "url") @Nullable String url) {
      this.url = url;
    }

    public @Nullable String getUrl() {
      return url;
    }

    @Override
    public String toString() {
      return "Video{" +
             "url='" + url + '\'' +
             '}';
    }
  }

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-author-structure">Embed Author</a>.
   */
  @NullMarked
  public static class Author {
    private final String name;
    private final @Nullable String url;
    private final @Nullable String iconUrl;

    @JsonCreator
    public Author(
      @JsonProperty(value = "name", required = true) String name,
      @JsonProperty(value = "url") @Nullable String url,
      @JsonProperty(value = "icon_url") @Nullable String iconUrl) {
      this.name = Check.lengthMax(name, 256, "name");
      this.url = url;
      this.iconUrl = iconUrl;
    }

    public String getName() {
      return name;
    }

    public @Nullable String getUrl() {
      return url;
    }

    public @Nullable String getIconUrl() {
      return iconUrl;
    }

    @Override
    public String toString() {
      return "Author{" +
             "name='" + name + '\'' +
             ", url='" + url + '\'' +
             ", iconUrl='" + iconUrl + '\'' +
             '}';
    }
  }

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-field-structure">Embed Field</a>.
   */
  @NullMarked
  public static class Field {
    private final String name;
    private final String value;
    private final boolean inline;

    @JsonCreator
    public Field(
      @JsonProperty(value = "name", required = true) String name,
      @JsonProperty(value = "value", required = true) String value,
      @JsonProperty(value = "inline") @Nullable Boolean inline) {
      this.name = Check.lengthMax(name, 256, "name");
      this.value = Check.lengthMax(value, 1024, "value");
      this.inline = Objects.requireNonNullElse(inline, false);
    }

    public String getName() {
      return name;
    }

    public String getValue() {
      return value;
    }

    public boolean isInline() {
      return inline;
    }

    @Override
    public String toString() {
      return "Field{" +
             "name='" + name + '\'' +
             ", value='" + value + '\'' +
             ", inline=" + inline +
             '}';
    }
  }
}
