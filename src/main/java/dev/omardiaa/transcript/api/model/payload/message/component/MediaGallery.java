package dev.omardiaa.transcript.api.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.util.Check;
import org.jspecify.annotations.NullMarked;

import java.util.List;

/**
 * Discord <a href="https://discord.com/developers/docs/components/reference#media-gallery">Media Gallery</a>.
 */
@NullMarked
public class MediaGallery implements ContainerChildComponent {
  private final int type;
  private final List<MediaGalleryItem> items;

  @JsonCreator
  public MediaGallery(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "items", required = true) List<MediaGalleryItem> items) {
    this.type = type;
    this.items = Check.lengthBetween(items, "items", 1, 10);
  }

  @Override
  public int getType() {
    return type;
  }

  public List<MediaGalleryItem> getItems() {
    return items;
  }

  @Override
  public String toString() {
    return "MediaGallery{" +
           "type=" + type +
           ", items=" + items +
           '}';
  }
}
