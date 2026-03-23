package dev.omardiaa.transcript.core.model.payload.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://docs.discord.com/developers/components/reference#unfurled-media-item">Unfurled Media Item</a>
 */
@NullMarked
public record UnfurledMediaItem(
  @JsonProperty(value = "url", required = true) String url
) {}
