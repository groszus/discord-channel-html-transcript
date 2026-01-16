package dev.omardiaa.transcript.api.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class SelectMenu implements ActionRowChildComponent {
  private final int type;
  private final String placeholder;

  public SelectMenu(
    @JsonProperty("type") int type,
    @JsonProperty("placeholder") @Nullable String placeholder) {
    this.type = type;
    this.placeholder = Check.notLonger(Check.notBlankElse(placeholder, "Make a selection"), 150, "placeholder");
  }

  @Override
  public int getType() {
    return type;
  }

  public String getPlaceholder() {
    return placeholder;
  }

  @Override
  public String toString() {
    return "SelectMenu{" +
           "type=" + type +
           ", placeholder='" + placeholder + '\'' +
           '}';
  }
}
