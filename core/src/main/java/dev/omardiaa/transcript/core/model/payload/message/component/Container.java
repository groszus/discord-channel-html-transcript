package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

import java.util.List;

/**
 * Discord <a href="https://docs.discord.com/developers/components/reference#container">Container</a>.
 */
@NullMarked
public class Container implements Component {
  private final int type;
  private final List<ContainerChildComponent> components;

  @JsonCreator
  public Container(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "components", required = true) List<ContainerChildComponent> components) {
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
