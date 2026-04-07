package dev.omardiaa.transcript.core.model.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * @param attachment
 *   the attachment options.
 * @param style
 *   the style options.
 */
@NullMarked
public record PayloadOptions(
  AttachmentOptions attachment,
  StyleOptions style
) {
  /**
   * @param attachment
   *   the attachment options.
   * @param style
   *   the style options.
   */
  @JsonCreator
  public PayloadOptions(
    @JsonProperty(value = "attachment") @Nullable AttachmentOptions attachment,
    @JsonProperty(value = "style") @Nullable StyleOptions style
  ) {
    this.attachment = attachment != null ? attachment : new AttachmentOptions(null);
    this.style = style != null ? style : new StyleOptions(null);
  }

  public PayloadOptions() {
    this(null, null);
  }

  /**
   * @param saveImages
   *   whether images should be downloaded and saved.
   */
  public record AttachmentOptions(
    boolean saveImages
  ) {
    /**
     * @param saveImages
     *   whether images should be downloaded and saved, defaults to {@code false} if {@code null}.
     */
    @JsonCreator
    public AttachmentOptions(
      @JsonProperty(value = "save_images") @Nullable Boolean saveImages
    ) {
      this(saveImages != null ? saveImages : false);
    }
  }

  /**
   * @param path
   *   the path to a custom {@code style.css}, defaults to inline styles if {@code null}.
   */
  public record StyleOptions(
    @Nullable String path
  ) {
    /**
     * @param path
     *   the path to a custom {@code style.css}, defaults to inline styles if {@code null}.
     */
    @JsonCreator
    public StyleOptions(
      @JsonProperty(value = "path") @Nullable String path
    ) {
      this.path = Check.isBlank(path) ? null : path;
    }
  }
}
