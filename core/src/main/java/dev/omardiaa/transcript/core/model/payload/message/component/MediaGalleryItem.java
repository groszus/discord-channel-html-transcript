package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;

/**
 * Discord <a href="https://discord.com/developers/docs/components/reference#media-gallery-media-gallery-item-structure">Media Gallery Item</a>.
 */
@NullMarked
public class MediaGalleryItem {
  private final UnfurledMediaItem media;

  @JsonCreator
  public MediaGalleryItem(@JsonProperty(value = "media", required = true) UnfurledMediaItem media) {
    this.media = media;
  }

  public UnfurledMediaItem getMedia() {
    return media;
  }

  @Override
  public String toString() {
    return "MediaGalleryItem{" +
           "media=" + media +
           '}';
  }
}
