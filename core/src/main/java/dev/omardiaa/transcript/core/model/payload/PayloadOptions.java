package dev.omardiaa.transcript.core.model.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public record PayloadOptions(
  AttachmentOptions attachment,
  StyleOptions style
) {
  /**
   * @param attachment
   *   Attachment options.
   * @param style
   *   Style options.
   */
  @JsonCreator
  public PayloadOptions(
    @JsonProperty(value = "attachment") @Nullable AttachmentOptions attachment,
    @JsonProperty(value = "style") @Nullable StyleOptions style
  ) {
    this.attachment = attachment == null ? new AttachmentOptions(null) : attachment;
    this.style = style == null ? new StyleOptions(null) : style;
  }

  public PayloadOptions() {
    this(null, null);
  }

  public record AttachmentOptions(
    boolean save
  ) {
    /**
     * Constructs a new {@link AttachmentOptions} instance.
     *
     * @param save
     *   whether or not the attachments should be downloaded and saved, fallbacks to {@code false} if not specified.
     */
    @JsonCreator
    public AttachmentOptions(
      @JsonProperty(value = "save") @Nullable Boolean save
    ) {
      this(save != null && save);
    }
  }

  public record StyleOptions(
    @Nullable String path
  ) {
    /**
     * Constructs a new {@link StyleOptions} instance.
     *
     * @param path
     *   path to custom {@code style.css}, fallbacks to default inline styles if not specified.
     */
    @JsonCreator
    public StyleOptions(
      @JsonProperty(value = "path") @Nullable String path
    ) {
      this.path = Check.isBlank(path) ? null : path;
    }
  }
}
