package dev.omardiaa.transcript.schema.payload.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class UnfurledMediaItem {
  private final String url;

  @JsonCreator
  public UnfurledMediaItem(@JsonProperty("url") String url) {
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
