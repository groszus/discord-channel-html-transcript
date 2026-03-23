package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://docs.discord.com/developers/components/reference#thumbnail">Thumbnail</a>
 */
@NullMarked
public record Thumbnail(
  int type,
  UnfurledMediaItem media
) implements Component, SectionAccessoryComponent {
  @JsonCreator
  public Thumbnail(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "media", required = true) UnfurledMediaItem media
  ) {
    this.type = type;
    this.media = media;
  }
}
