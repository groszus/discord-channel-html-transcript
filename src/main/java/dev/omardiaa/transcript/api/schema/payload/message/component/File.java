package dev.omardiaa.transcript.api.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.schema.payload.util.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class File implements ContainerChildComponent {
  private final int type;
  private final UnfurledMediaItem file;
  private final String name;
  private final int size;

  public File(
    @JsonProperty("type") int type,
    @JsonProperty("file") UnfurledMediaItem file,
    @JsonProperty("name") String name,
    @JsonProperty("size") int size) {
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
