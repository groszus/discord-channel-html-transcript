package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;

import java.util.List;

/**
 * Discord <a href="https://docs.discord.com/developers/components/reference#action-row">Action Row</a>.
 */
@NullMarked
public class ActionRow implements ContainerChildComponent {
  private final int type;
  private final List<ActionRowChildComponent> components;

  @JsonCreator
  public ActionRow(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "components", required = true) List<ActionRowChildComponent> components) {
    boolean containsSelectMenu = components.stream().anyMatch(c -> c instanceof SelectMenu);

    if ((components.size() > 1) && containsSelectMenu) {
      throw new IllegalArgumentException("Action Row with a Select Menu cannot contain other components.");
    }

    this.type = type;
    this.components = Check.sizeMin(components, "components", 1);
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
