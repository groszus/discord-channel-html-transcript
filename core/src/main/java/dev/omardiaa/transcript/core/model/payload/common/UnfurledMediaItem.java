package dev.omardiaa.transcript.core.model.payload.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

/**
 * Discord <a href="https://discord.com/developers/docs/components/reference#unfurled-media-item">Unfurled Media Item</a>.
 */
@NullMarked
public class UnfurledMediaItem {
  private final String url;

  @JsonCreator
  public UnfurledMediaItem(@JsonProperty(value = "url", required = true) String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  @Override
  public String toString() {
    return "UnfurledMediaItem{" +
           "url='" + url + '\'' +
           '}';
  }
}
