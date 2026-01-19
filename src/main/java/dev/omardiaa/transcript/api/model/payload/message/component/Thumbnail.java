package dev.omardiaa.transcript.api.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.model.payload.common.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;

/**
 * Discord <a href="https://discord.com/developers/docs/components/reference#thumbnail">Thumbnail</a>.
 */
@NullMarked
public class Thumbnail implements Component, SectionAccessoryComponent {
  private final int type;
  private final UnfurledMediaItem media;

  @JsonCreator
  public Thumbnail(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "media", required = true) UnfurledMediaItem media) {
    this.type = type;
    this.media = media;
  }

  @Override
  public int getType() {
    return type;
  }

  public UnfurledMediaItem getMedia() {
    return media;
  }

  @Override
  public String toString() {
    return "Thumbnail{" +
           "type=" + type +
           ", media=" + media +
           '}';
  }
}
