package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.UnfurledMediaItem;
import dev.omardiaa.transcript.core.model.payload.message.component.File;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class Attachment {
  private final String filename;
  private final @Nullable String contentType;
  private final int size;
  private final String url;

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#attachment-object">Attachment</a>.
   */
  @JsonCreator
  public Attachment(
    @JsonProperty(value = "filename", required = true) String filename,
    @JsonProperty(value = "content_type") @Nullable String contentType,
    @JsonProperty(value = "size", required = true) int size,
    @JsonProperty(value = "url", required = true) String url) {
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
   * @return {@code true} if the attachment's
   * <a href="https://en.wikipedia.org/wiki/Media_type">Media Type</a> is {@code image/*}
   */
  @JsonIgnore
  public boolean isImage() {
    return (getContentType() != null) && getContentType().startsWith("image");
  }

  /**
   * @return Constructs {@link File} from {@link Attachment}.
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
