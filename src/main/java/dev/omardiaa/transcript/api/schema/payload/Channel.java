package dev.omardiaa.transcript.api.schema.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class Channel {
  private final String id;
  private final int type;
  private final String name;

  @JsonCreator
  public Channel(
    @JsonProperty("id") String id,
    @JsonProperty("type") int type,
    @JsonProperty("name") @Nullable String name) {
    if (type != 0) {
      throw new IllegalArgumentException("Channel must be of type GUILD_TEXT");
    }

    this.id = id;
    this.type = type;
    this.name = Check.notBlankElse(name, "unknown");
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
