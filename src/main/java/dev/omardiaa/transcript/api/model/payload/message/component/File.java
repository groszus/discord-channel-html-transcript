package dev.omardiaa.transcript.api.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.model.payload.common.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;

/**
 * Discord <a href="https://discord.com/developers/docs/components/reference#file">File</a>.
 */
@NullMarked
public class File implements ContainerChildComponent {
  private final int type;
  private final UnfurledMediaItem file;
  private final String name;
  private final int size;

  @JsonCreator
  public File(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "file", required = true) UnfurledMediaItem file,
    @JsonProperty(value = "name", required = true) String name,
    @JsonProperty(value = "size", required = true) int size) {
    this.type = type;
    this.file = file;
    this.name = name;
    this.size = size;
  }

  @Override
  public int getType() {
    return type;
  }

  public UnfurledMediaItem getFile() {
    return file;
  }

  public String getName() {
    return name;
  }

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "File{" +
           "type=" + type +
           ", file=" + file +
           ", name='" + name + '\'' +
           ", size=" + size +
           '}';
  }
}
