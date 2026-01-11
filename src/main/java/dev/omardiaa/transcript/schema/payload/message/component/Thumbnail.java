package dev.omardiaa.transcript.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.schema.payload.util.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class Thumbnail implements Component, SectionAccessoryComponent {
  private final int type;
  private final UnfurledMediaItem media;

  @JsonCreator
  public Thumbnail(
    @JsonProperty("type") int type,
    @JsonProperty("media") UnfurledMediaItem media) {
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
