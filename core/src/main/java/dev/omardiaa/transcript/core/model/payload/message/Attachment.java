package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.UnfurledMediaItem;
import dev.omardiaa.transcript.core.model.payload.message.component.File;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * <a href="https://docs.discord.com/developers/resources/message#attachment-object">Attachment</a>
 */
@NullMarked
public record Attachment(
  String filename,
  int size,
  String url,
  @JsonIgnore boolean isImage
) {
  @JsonCreator
  public Attachment(
    @JsonProperty(value = "filename", required = true) String filename,
    @JsonProperty(value = "content_type") @Nullable String contentType,
    @JsonProperty(value = "size", required = true) int size,
    @JsonProperty(value = "url", required = true) String url
  ) {
    this(
      filename,
      size,
      url,
      (contentType != null) && contentType.startsWith("image")
    );
  }

  /**
   * Constructs a new {@link File} from this {@link Attachment}.
   *
   * @return a new {@link File}.
   */
  @JsonIgnore
  public File toFile() {
    return new File(13, new UnfurledMediaItem(url), filename, size);
  }
}
