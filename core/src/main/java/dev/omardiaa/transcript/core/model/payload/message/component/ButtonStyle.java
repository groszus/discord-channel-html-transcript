package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.jspecify.annotations.NullMarked;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://docs.discord.com/developers/components/reference#button-button-styles">Button Styles</a>
 */
@NullMarked
public enum ButtonStyle {
  UNKNOWN(-1), PRIMARY(1), SECONDARY(2), SUCCESS(3), DANGER(4), LINK(5);

  private static final Map<Integer, ButtonStyle> BUTTON_STYLE_MAP = Arrays
    .stream(values()).collect(Collectors.toUnmodifiableMap(ButtonStyle::getValue, Function.identity()));

  private final int value;

  ButtonStyle(int value) {
    this.value = value;
  }

  @JsonValue
  public int getValue() {
    return value;
  }

  @JsonCreator
  public static ButtonStyle fromValue(int value) {
    return BUTTON_STYLE_MAP.getOrDefault(value, UNKNOWN);
  }
}
