package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * <a href="https://docs.discord.com/developers/components/reference#separator">Separator</a>
 */
@NullMarked
public record Separator(
  int type,
  boolean divider,
  Spacing spacing
) implements ContainerChildComponent {
  @JsonCreator
  public Separator(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "divider") @Nullable Boolean divider,
    @JsonProperty(value = "spacing") Spacing spacing
  ) {
    this(
      type,
      divider != null ? divider : true,
      spacing
    );
  }

  public enum Spacing {
    @JsonEnumDefaultValue SMALL(1),
    LARGE(2);

    @JsonValue
    public final int value;

    Spacing(int value) {
      this.value = value;
    }
  }
}
