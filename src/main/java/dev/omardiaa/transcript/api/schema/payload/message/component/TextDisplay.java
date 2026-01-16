package dev.omardiaa.transcript.api.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class TextDisplay implements ContainerChildComponent, SectionChildComponent {
  private final int type;
  private final String content;

  @JsonCreator
  public TextDisplay(
    @JsonProperty("type") int type,
    @JsonProperty("content") String content) {
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
