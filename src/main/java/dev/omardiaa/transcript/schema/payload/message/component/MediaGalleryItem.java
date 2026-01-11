package dev.omardiaa.transcript.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.schema.payload.util.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class MediaGalleryItem {
  private final UnfurledMediaItem media;

  @JsonCreator
  public MediaGalleryItem(@JsonProperty("media") UnfurledMediaItem media) {
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
