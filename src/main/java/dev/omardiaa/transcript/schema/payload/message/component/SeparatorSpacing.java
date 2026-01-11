package dev.omardiaa.transcript.schema.payload.message.component;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum SeparatorSpacing {
  UNKNOWN(-1),
  SMALL(1),
  LARGE(2);

  private static final Map<Integer, SeparatorSpacing> SPACINGS = Arrays
    .stream(values()).collect(Collectors.toUnmodifiableMap(SeparatorSpacing::getValue, Function.identity()));
  private final int value;

  SeparatorSpacing(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static SeparatorSpacing fromValue(int value) {
    return SPACINGS.getOrDefault(value, UNKNOWN);
  }
}
