package dev.omardiaa.transcript.schema.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.util.Check;
import dev.omardiaa.transcript.util.TimeUtil;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.List;

@NullMarked
public class Embed {
  private final @Nullable String title;
  private final @Nullable String type;
  private final @Nullable String description;
  private final @Nullable String url;
  private final @Nullable OffsetDateTime timestamp;
  private final @Nullable Integer color;
  private final Embed.@Nullable Footer footer;
  private final Embed.@Nullable Image image;
  private final Embed.@Nullable Thumbnail thumbnail;
  private final Embed.@Nullable Author author;
  private final @Nullable List<Field> fields;

  @JsonCreator
  public Embed(
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("type") @Nullable String type,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("url") @Nullable String url,
    @JsonProperty("timestamp") @Nullable String timestamp,
    @JsonProperty("color") @Nullable Integer color,
    @JsonProperty("footer") Embed.@Nullable Footer footer,
    @JsonProperty("image") Embed.@Nullable Image image,
    @JsonProperty("thumbnail") Embed.@Nullable Thumbnail thumbnail,
    @JsonProperty("author") Embed.@Nullable Author author,
    @JsonProperty("fields") @Nullable List<Field> fields) {
    this.title = title;
    this.type = type;
    this.description = description;
    this.url = url;
    this.timestamp = timestamp == null ? null : TimeUtil.toOffsetDateTime(timestamp);
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

  public @Nullable String getType() {
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

  @NullMarked
  public static class Footer {
    private final String text;
    private final @Nullable String iconUrl;

    @JsonCreator
    public Footer(
      @JsonProperty("text") String text,
      @JsonProperty("icon_url") @Nullable String iconUrl) {
      this.text = Check.notLonger(text, 2048, "text");
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

    @JsonCreator
    public Image(@JsonProperty("url") String url) {
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

    @JsonCreator
    public Thumbnail(@JsonProperty("url") String url) {
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

    @JsonCreator
    public Author(
      @JsonProperty("name") String name,
      @JsonProperty("url") @Nullable String url,
      @JsonProperty("icon_url") @Nullable String iconUrl) {
      this.name = Check.notLonger(name, 256, "name");
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

    @JsonCreator
    public Field(
      @JsonProperty("name") String name,
      @JsonProperty("value") String value,
      @JsonProperty("inline") @Nullable Boolean inline) {
      this.name = Check.notLonger(name, 256, "name");
      this.value = Check.notLonger(value, 1024, "value");
      this.inline = Check.notNullElse(inline, false);
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
