package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// TODO: implement different Embed types other than "rich"
@NullMarked
public class Embed {
  private final @Nullable String title;
  private final Type type;
  private final @Nullable String description;
  private final @Nullable String url;
  private final @Nullable OffsetDateTime timestamp;
  private final @Nullable Integer color;
  private final Embed.@Nullable Footer footer;
  private final Embed.@Nullable Image image;
  private final Embed.@Nullable Thumbnail thumbnail;
  private final Embed.@Nullable Author author;
  private final @Nullable List<Field> fields;

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object">Embed</a>.
   */
  @JsonCreator
  public Embed(
    @JsonProperty(value = "title") @Nullable String title,
    @JsonProperty(value = "type") @Nullable String type,
    @JsonProperty(value = "description") @Nullable String description,
    @JsonProperty(value = "url") @Nullable String url,
    @JsonProperty(value = "timestamp") @Nullable OffsetDateTime timestamp,
    @JsonProperty(value = "color") @Nullable Integer color,
    @JsonProperty(value = "footer") Embed.@Nullable Footer footer,
    @JsonProperty(value = "image") Embed.@Nullable Image image,
    @JsonProperty(value = "thumbnail") Embed.@Nullable Thumbnail thumbnail,
    @JsonProperty(value = "author") Embed.@Nullable Author author,
    @JsonProperty(value = "fields") @Nullable List<Field> fields) {
    this.title = title;
    this.type = type == null ? Type.RICH : Type.fromType(type);
    this.description = description;
    this.url = url;
    this.timestamp = timestamp;
    this.color = color;
    this.footer = footer;
    this.image = image;
    this.thumbnail = thumbnail;
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

  public @Nullable Integer getColor() {
    return color;
  }

  public Embed.@Nullable Footer getFooter() {
    return footer;
  }

  public Embed.@Nullable Image getImage() {
    return image;
  }

  public Embed.@Nullable Thumbnail getThumbnail() {
    return thumbnail;
  }

  public Embed.@Nullable Author getAuthor() {
    return author;
  }

  public @Nullable List<Field> getFields() {
    return fields;
  }

  @Override
  public String toString() {
    return "Embed{" +
           "title='" + title + '\'' +
           ", type='" + type + '\'' +
           ", description='" + description + '\'' +
           ", url='" + url + '\'' +
           ", timestamp=" + timestamp +
           ", color=" + color +
           ", footer=" + footer +
           ", image=" + image +
           ", thumbnail=" + thumbnail +
           ", author=" + author +
           ", fields=" + fields +
           '}';
  }

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-types">Embed Types</a>.
   */
  @NullMarked
  public enum Type {
    UNKNOWN(), RICH(), GIFV(), ARTICLE();

    private static final Map<String, Type> TYPE_MAP = Arrays.stream(values()).collect(
      Collectors.toUnmodifiableMap(v -> v.name().toLowerCase(), Function.identity()));

    public static Type fromType(String type) {
      return TYPE_MAP.getOrDefault(type, UNKNOWN);
    }
  }

  @NullMarked
  public static class Footer {
    private final String text;
    private final @Nullable String iconUrl;

    /**
     * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-footer-structure">Embed Footer</a>.
     */
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

  @NullMarked
  public static class Image {
    private final String url;

    /**
     * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-image-structure">Embed Image</a>.
     */
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

  @NullMarked
  public static class Thumbnail {
    private final String url;

    /**
     * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-thumbnail-structure">Embed Thumbnail</a>.
     */
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

  @NullMarked
  public static class Author {
    private final String name;
    private final @Nullable String url;
    private final @Nullable String iconUrl;

    /**
     * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-author-structure">Embed Author</a>.
     */
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

  @NullMarked
  public static class Field {
    private final String name;
    private final String value;
    private final boolean inline;

    /**
     * Discord <a href="https://discord.com/developers/docs/resources/message#embed-object-embed-field-structure">Embed Field</a>.
     */
    @JsonCreator
    public Field(
      @JsonProperty(value = "name", required = true) String name,
      @JsonProperty(value = "value", required = true) String value,
      @JsonProperty(value = "inline") @Nullable Boolean inline) {
      this.name = Check.lengthMax(name, 256, "name");
      this.value = Check.lengthMax(value, 1024, "value");
      this.inline = Check.defaultIfNull(inline, false);
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
