package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@NullMarked
public enum SeparatorSpacing {
  UNKNOWN(-1),
  SMALL(1),
  LARGE(2);

  private static final Map<Integer, SeparatorSpacing> SEPARATOR_SPACING_MAP = Arrays
    .stream(values()).collect(Collectors.toUnmodifiableMap(SeparatorSpacing::getValue, Function.identity()));

  private final int value;

  SeparatorSpacing(int value) {
    this.value = value;
  }

  @JsonValue
  public int getValue() {
    return value;
  }

  @JsonCreator
  public static SeparatorSpacing fromValue(@Nullable Integer value) {
    return SEPARATOR_SPACING_MAP.getOrDefault(value, UNKNOWN);
  }
}
