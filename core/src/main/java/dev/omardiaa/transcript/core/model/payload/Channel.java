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
  String id,
  int type,
  String name,
  @Nullable String topic
) {
  @JsonCreator
  public Channel(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "name") @Nullable String name,
    @JsonProperty(value = "topic") @Nullable String topic) {
    if (type != 0) {
      throw new IllegalArgumentException("Channel must be of type GUILD_TEXT (0)");
    }

    this.id = id;
    this.type = type;
    this.name = Check.defaultIfBlank(name, "unknown");
    this.topic = topic;
  }
}
