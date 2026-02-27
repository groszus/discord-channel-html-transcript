package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

/**
 * Discord <a href="https://docs.discord.com/developers/components/reference#separator">Separator</a>.
 */
@NullMarked
public class Separator implements ContainerChildComponent {
  private final int type;
  private final boolean divider;
  private final SeparatorSpacing spacing;

  @JsonCreator
  public Separator(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "divider") @Nullable Boolean divider,
    @JsonProperty(value = "spacing") @Nullable SeparatorSpacing spacing) {
    this.type = type;
    this.divider = Objects.requireNonNullElse(divider, true);
    this.spacing = Objects.requireNonNullElse(spacing, SeparatorSpacing.SMALL);
  }

  @Override
  public int getType() {
    return type;
  }

  public boolean isDivider() {
    return divider;
  }

  public SeparatorSpacing getSpacing() {
    return spacing;
  }

  @Override
  public String toString() {
    return "Separator{" +
           "type=" + type +
           ", divider=" + divider +
           ", spacing=" + spacing +
           '}';
  }
}
