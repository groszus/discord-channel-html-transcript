package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

import java.util.List;

/**
 * <a href="https://docs.discord.com/developers/components/reference#section">Section</a>
 */
@NullMarked
public record Section(
  int type,
  List<SectionChildComponent> components,
  SectionAccessoryComponent accessory
) implements ContainerChildComponent {
  @JsonCreator
  public Section(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "components", required = true) List<SectionChildComponent> components,
    @JsonProperty(value = "accessory", required = true) SectionAccessoryComponent accessory
  ) {
    this.type = type;
    this.components = components;
    this.accessory = accessory;
  }
}
