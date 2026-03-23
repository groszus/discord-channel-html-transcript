package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://docs.discord.com/developers/components/reference#file">File</a>
 */
@NullMarked
public record File(
  int type,
  UnfurledMediaItem file,
  String name,
  int size
) implements ContainerChildComponent {
  @JsonCreator
  public File(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "file", required = true) UnfurledMediaItem file,
    @JsonProperty(value = "name", required = true) String name,
    @JsonProperty(value = "size", required = true) int size
  ) {
    this.type = type;
    this.file = file;
    this.name = name;
    this.size = size;
  }
}
