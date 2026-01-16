package dev.omardiaa.transcript.api.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class Separator implements ContainerChildComponent {
  private final int type;
  private final boolean divider;
  private final int spacing;

  @JsonCreator
  public Separator(
    @JsonProperty("type") int type,
    @JsonProperty("divider") @Nullable Boolean divider,
    @JsonProperty("spacing") @Nullable Integer spacing) {
    this.type = type;
    this.divider = Check.notNullElse(divider, true);
    this.spacing = Check.notNullElse(spacing, 1);
  }

  @Override
  public int getType() {
    return type;
  }

  public boolean isDivider() {
    return divider;
  }

  public int getSpacing() {
    return spacing;
  }

  /**
   * Helper Method
   *
   * @return SeparatorSpacing
   */
  @JsonIgnore
  public SeparatorSpacing getSpacingType() {
    return SeparatorSpacing.fromValue(getSpacing());
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
