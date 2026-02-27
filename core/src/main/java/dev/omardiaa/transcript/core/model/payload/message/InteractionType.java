package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Discord <a href="https://docs.discord.com/developers/interactions/receiving-and-responding#interaction-object-interaction-type">Interaction Type</a>.
 */
public enum InteractionType {
  UNKNOWN(-1),
  APPLICATION_COMMAND(2);

  private static final Map<Integer, InteractionType> INTERACTION_TYPE_MAP = Arrays
    .stream(values()).collect(Collectors.toUnmodifiableMap(InteractionType::getValue, Function.identity()));

  private final int value;

  InteractionType(int value) {
    this.value = value;
  }

  @JsonValue
  public int getValue() {
    return value;
  }

  @JsonCreator
  public static InteractionType fromValue(int value) {
    return INTERACTION_TYPE_MAP.getOrDefault(value, UNKNOWN);
  }
}
