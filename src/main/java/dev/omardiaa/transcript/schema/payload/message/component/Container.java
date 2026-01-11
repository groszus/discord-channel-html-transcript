package dev.omardiaa.transcript.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public class Container implements Component {
  private final int type;
  private final List<ContainerChildComponent> components;

  @JsonCreator
  public Container(
    @JsonProperty("type") int type,
    @JsonProperty("components") List<ContainerChildComponent> components) {
    this.type = type;
    this.components = components;
  }

  @Override
  public int getType() {
    return type;
  }

  public List<ContainerChildComponent> getComponents() {
    return components;
  }

  @Override
  public String toString() {
    return "Container{" +
           "type=" + type +
           ", components=" + components +
           '}';
  }
}
