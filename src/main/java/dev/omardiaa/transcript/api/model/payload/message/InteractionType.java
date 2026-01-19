package dev.omardiaa.transcript.api.model.payload.message;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum InteractionType {
  UNKNOWN(-1),
  APPLICATION_COMMAND(2);

  private static final Map<Integer, InteractionType> INTERACTION_TYPE_MAP = Arrays
    .stream(values()).collect(Collectors.toUnmodifiableMap(InteractionType::getValue, Function.identity()));

  private final int value;

  InteractionType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static InteractionType fromValue(int value) {
    return INTERACTION_TYPE_MAP.getOrDefault(value, UNKNOWN);
  }
}
