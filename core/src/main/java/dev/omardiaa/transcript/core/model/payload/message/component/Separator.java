package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

/**
 * <a href="https://docs.discord.com/developers/components/reference#separator">Separator</a>
 */
@NullMarked
public record Separator(
  int type,
  boolean divider,
  SeparatorSpacing spacing
) implements ContainerChildComponent {
  @JsonCreator
  public Separator(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "divider") @Nullable Boolean divider,
    @JsonProperty(value = "spacing") @Nullable SeparatorSpacing spacing
  ) {
    this(
      type,
      Objects.requireNonNullElse(divider, true).booleanValue(),
      Objects.requireNonNullElse(spacing, SeparatorSpacing.SMALL));
  }
}
