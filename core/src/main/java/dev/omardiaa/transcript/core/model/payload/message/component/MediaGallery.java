package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.UnfurledMediaItem;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;

import java.util.List;

/**
 * <a href="https://docs.discord.com/developers/components/reference#media-gallery">Media Gallery</a>
 */
@NullMarked
public record MediaGallery(
  int type,
  List<Item> items
) implements ContainerChildComponent {
  @JsonCreator
  public MediaGallery(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "items", required = true) List<Item> items
  ) {
    this.type = type;
    this.items = Check.sizeBetween(items, "items", 1, 10);
  }

  /**
   * <a href="https://docs.discord.com/developers/components/reference#media-gallery-media-gallery-item-structure">Media Gallery Item</a>
   */
  public record Item(
    UnfurledMediaItem media
  ) {
    @JsonCreator
    public Item(
      @JsonProperty(value = "media", required = true) UnfurledMediaItem media
    ) {
      this.media = media;
    }
  }
}
