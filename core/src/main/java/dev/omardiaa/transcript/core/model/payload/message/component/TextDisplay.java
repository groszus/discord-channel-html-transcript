package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://docs.discord.com/developers/components/reference#text-display">Text Display</a>
 */
@NullMarked
public record TextDisplay(
  int type,
  String content
) implements ContainerChildComponent, SectionChildComponent {
  @JsonCreator
  public TextDisplay(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "content", required = true) String content
  ) {
    this.type = type;
    this.content = content;
  }
}
