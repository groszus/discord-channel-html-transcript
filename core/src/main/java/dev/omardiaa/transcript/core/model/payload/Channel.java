package dev.omardiaa.transcript.core.model.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Discord <a href="https://docs.discord.com/developers/resources/channel#channel-object">Channel</a>.
 */
@NullMarked
public class Channel {
  private final String id;
  private final int type;
  private final String name;
  private final @Nullable String topic;

  @JsonCreator
  public Channel(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "name") @Nullable String name,
    @JsonProperty(value = "topic") @Nullable String topic) {
    if (type != 0) {
      throw new IllegalArgumentException("Channel must be of type GUILD_TEXT(0)");
    }

    this.id = id;
    this.type = type;
    this.name = Check.defaultIfBlank(name, "unknown");
    this.topic = topic;
  }

  public String getId() {
    return id;
  }

  public int getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public @Nullable String getTopic() {
    return topic;
  }

  @Override
  public String toString() {
    return "Channel{" +
           "id='" + id + '\'' +
           ", type=" + type +
           ", name='" + name + '\'' +
           ", topic='" + topic + '\'' +
           '}';
  }
}
