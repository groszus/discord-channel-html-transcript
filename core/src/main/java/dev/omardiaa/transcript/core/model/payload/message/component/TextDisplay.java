package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

/**
 * Discord <a href="https://docs.discord.com/developers/components/reference#text-display">Text Display</a>.
 */
@NullMarked
public class TextDisplay implements ContainerChildComponent, SectionChildComponent {
  private final int type;
  private final String content;

  @JsonCreator
  public TextDisplay(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "content", required = true) String content) {
    this.type = type;
    this.content = content;
  }

  @Override
  public int getType() {
    return type;
  }

  public String getContent() {
    return content;
  }

  @Override
  public String toString() {
    return "TextDisplay{" +
           "type=" + type +
           ", content='" + content + '\'' +
           '}';
  }
}
