package dev.omardiaa.transcript.util;

import org.intellij.lang.annotations.PrintFormat;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public final class Check {
  private Check() {}

  @Contract("false, _, _ -> fail")
  public static void check(boolean expression, @PrintFormat String message, Object... args) {
    if (!expression) {
      throw new IllegalArgumentException(String.format(message, args));
    }
  }

  @Contract("null, _ -> fail")
  private static void notNull(Object arg, String name) {
    if (arg == null) {
      throw new IllegalArgumentException(name + " may not be null");
    }
  }

  @Contract(value = "null, _ -> param2; !null, _ -> param1")
  public static <T> T notNullElse(@Nullable T arg, @NonNull T fallback) {
    if (arg == null) {
      return fallback;
    }

    return arg;
  }

  public static String notBlankElse(@Nullable String arg, @NonNull String fallback) {
    if (Objects.isNull(arg) || Helper.isBlank(arg)) {
      return fallback;
    }

    return arg;
  }

  public static String inRange(String input, int min, int max, String name) {
    notNull(input, name);
    int length = Helper.codePointLength(input);
    check(
      min <= length && length <= max,
      "%s must be between %d and %d characters long! Provided: \"%s\"",
      name,
      min,
      max,
      input);

    return input;
  }

  public static String notLonger(String input, int length, String name) {
    notNull(input, name);
    check(
      Helper.codePointLength(input) <= length,
      "%s may not be longer than %d characters! Provided: \"%s\"",
      name,
      length,
      input);

    return input;
  }

  public static <T> List<T> size(@NonNull List<T> arg, String name, int min, int max) {
    if (arg.size() < min || arg.size() > max) {
      throw new IllegalArgumentException(
        "%s may not be less than %d or more than %d! Provided: %d".formatted(name, min, max, arg.size()));
    }

    return arg;
  }
}
