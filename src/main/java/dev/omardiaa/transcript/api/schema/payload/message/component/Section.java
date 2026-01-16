package dev.omardiaa.transcript.api.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public class Section implements ContainerChildComponent {
  private final int type;
  private final List<SectionChildComponent> components;
  private final SectionAccessoryComponent accessory;

  @JsonCreator
  public Section(
    @JsonProperty("type") int type,
    @JsonProperty("components") List<SectionChildComponent> components,
    @JsonProperty("accessory") SectionAccessoryComponent accessory) {
    this.type = type;
    this.components = components;
    this.accessory = accessory;
  }

  @Override
  public int getType() {
    return type;
  }

  public List<SectionChildComponent> getComponents() {
    return components;
  }

  public SectionAccessoryComponent getAccessory() {
    return accessory;
  }

  @Override
  public String toString() {
    return "Section{" +
           "type=" + type +
           ", components=" + components +
           ", accessory=" + accessory +
           '}';
  }
}
