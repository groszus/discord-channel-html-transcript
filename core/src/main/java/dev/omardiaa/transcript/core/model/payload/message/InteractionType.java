package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;
import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://docs.discord.com/developers/interactions/receiving-and-responding#interaction-object-interaction-type">Interaction Type</a>
 */
@NullMarked
public enum InteractionType {
  @JsonEnumDefaultValue UNKNOWN(-1),
  APPLICATION_COMMAND(2);

  @JsonValue
  public final int value;

  InteractionType(int value) {
    this.value = value;
  }
}
