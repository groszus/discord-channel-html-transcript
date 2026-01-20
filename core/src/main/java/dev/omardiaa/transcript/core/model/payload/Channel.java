package dev.omardiaa.transcript.core.model.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class Channel {
  private final String id;
  private final int type;
  private final String name;

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/channel#channels-resource">Channel</a>.
   */
  @JsonCreator
  public Channel(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "name") @Nullable String name) {
    if (type != 0) {
      throw new IllegalArgumentException("Channel must be of type GUILD_TEXT");
    }

    this.id = id;
    this.type = type;
    this.name = Check.defaultIfBlank(name, "unknown");
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

  @Override
  public String toString() {
    return "Channel{" +
           "id='" + id + '\'' +
           ", type=" + type +
           ", name='" + name + '\'' +
           '}';
  }
}
