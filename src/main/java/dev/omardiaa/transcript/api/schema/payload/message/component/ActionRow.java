package dev.omardiaa.transcript.api.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

import java.util.ArrayList;
import java.util.List;

@NullMarked
public class ActionRow implements ContainerChildComponent {
  private final int type;
  private final List<ActionRowChildComponent> components;

  // TODO: refactor "List<? extends ActionRowChildComponent>"
  @JsonCreator
  public ActionRow(
    @JsonProperty("type") int type,
    @JsonProperty("components") List<? extends ActionRowChildComponent> components) {
    if ((components.size() > 5) || (components.isEmpty())) {
      throw new IllegalArgumentException("ActionRow must have 5 button components or 1 select component");
    }

    for (ActionRowChildComponent component : components) {
      if ((components.size() > 1) && !(component instanceof Button)) {
        throw new IllegalArgumentException("ActionRow components cannot have more than 1 SelectMenu");
      }
    }

    this.type = type;
    this.components = new ArrayList<>(components);
  }

  @Override
  public int getType() {
    return type;
  }

  public List<ActionRowChildComponent> getComponents() {
    return components;
  }

  @Override
  public String toString() {
    return "ActionRow{" +
           "type=" + type +
           ", components=" + components +
           '}';
  }
}
