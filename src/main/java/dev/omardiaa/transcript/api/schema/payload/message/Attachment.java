package dev.omardiaa.transcript.api.schema.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.schema.payload.message.component.File;
import dev.omardiaa.transcript.api.schema.payload.util.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class Attachment {
  private final String filename;
  private final @Nullable String contentType;
  private final int size;
  private final String url;

  @JsonCreator
  public Attachment(
    @JsonProperty("filename") String filename,
    @JsonProperty("content_type") @Nullable String contentType,
    @JsonProperty("size") int size,
    @JsonProperty("url") String url) {
    this.filename = filename;
    this.contentType = contentType;
    this.size = size;
    this.url = url;
  }

  public String getFilename() {
    return filename;
  }

  public @Nullable String getContentType() {
    return contentType;
  }

  public int getSize() {
    return size;
  }

  public String getUrl() {
    return url;
  }

  /**
   * Helper Method
   *
   * @return {@code boolean} - true if the attachment's
   * <a href="https://en.wikipedia.org/wiki/Media_type">Media Type</a> is {@code image/*}
   */
  @JsonIgnore
  public boolean isImage() {
    return getContentType() != null && getContentType().startsWith("image");
  }

  /**
   * Helper Method
   *
   * @return {@link File} - {@code File} of {@link Attachment}
   */
  @JsonIgnore
  public File toFile() {
    return new File(13, new UnfurledMediaItem(getUrl()), getFilename(), getSize());
  }

  @Override
  public String toString() {
    return "Attachment{" +
           "filename='" + filename + '\'' +
           ", contentType='" + contentType + '\'' +
           ", size=" + size +
           ", url='" + url + '\'' +
           '}';
  }
}
