package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.UnfurledMediaItem;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;

import java.util.List;

/**
 * Discord <a href="https://docs.discord.com/developers/components/reference#media-gallery">Media Gallery</a>.
 */
@NullMarked
public class MediaGallery implements ContainerChildComponent {
  private final int type;
  private final List<Item> items;

  @JsonCreator
  public MediaGallery(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "items", required = true) List<Item> items) {
    this.type = type;
    this.items = Check.lengthBetween(items, "items", 1, 10);
  }

  @Override
  public int getType() {
    return type;
  }

  public List<Item> getItems() {
    return items;
  }

  @Override
  public String toString() {
    return "MediaGallery{" +
           "type=" + type +
           ", items=" + items +
           '}';
  }

  @NullMarked
  public static class Item {
    private final UnfurledMediaItem media;

    @JsonCreator
    public Item(@JsonProperty(value = "media", required = true) UnfurledMediaItem media) {
      this.media = media;
    }

    public UnfurledMediaItem getMedia() {
      return media;
    }

    @Override
    public String toString() {
      return "Item{" +
             "media=" + media +
             '}';
    }
  }
}
