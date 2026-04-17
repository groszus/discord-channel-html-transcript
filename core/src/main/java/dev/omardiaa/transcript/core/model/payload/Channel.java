package dev.omardiaa.transcript.core.model.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * <a href="https://docs.discord.com/developers/resources/channel#channel-object">Channel</a>
 */
@NullMarked
public record Channel(
  String name,
  @Nullable String topic
) {
  @JsonCreator
  public Channel(
    @JsonProperty(value = "name") @Nullable String name,
    @JsonProperty(value = "topic") @Nullable String topic
  ) {
    this.name = Check.defaultIfBlank(name, "unknown");
    this.topic = topic;
  }
}
