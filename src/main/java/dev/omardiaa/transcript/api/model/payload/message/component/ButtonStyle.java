package dev.omardiaa.transcript.api.model.payload.message.component;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ButtonStyle {
  UNKNOWN(-1),
  PRIMARY(1),
  SECONDARY(2),
  SUCCESS(3),
  DANGER(4),
  LINK(5);

  private static final Map<Integer, ButtonStyle> BUTTON_STYLE_MAP = Arrays
    .stream(values()).collect(Collectors.toUnmodifiableMap(ButtonStyle::getValue, Function.identity()));

  private final int value;

  ButtonStyle(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static ButtonStyle fromValue(int value) {
    return BUTTON_STYLE_MAP.getOrDefault(value, UNKNOWN);
  }
}
