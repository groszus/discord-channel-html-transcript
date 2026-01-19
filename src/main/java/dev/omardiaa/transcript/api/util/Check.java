package dev.omardiaa.transcript.api.util;

import org.intellij.lang.annotations.PrintFormat;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

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
      throw new IllegalArgumentException(name + " must not be null");
    }
  }

  @Contract(value = "null, _ -> param2; !null, _ -> param1")
  public static <T> T defaultIfNull(@Nullable T arg, @NonNull T fallback) {
    if (arg == null) {
      return fallback;
    }
    return arg;
  }

  public static String defaultIfBlank(@Nullable String arg, @NonNull String fallback) {
    if (arg == null || arg.isBlank()) {
      return fallback;
    }
    return arg;
  }

  public static String lengthRange(String arg, int min, int max, String name) {
    notNull(arg, name);
    long length = arg.codePoints().count();
    check(
      min <= length && length <= max,
      "\"%s\" must be between %d and %d characters! Provided: \"%s\"",
      name,
      min,
      max,
      arg);
    return arg;
  }

  public static String lengthMax(String arg, int length, String name) {
    notNull(arg, name);
    check(
      arg.codePoints().count() <= length,
      "\"%s\" must not be longer than %d characters! Provided: \"%s\"",
      name,
      length,
      arg);
    return arg;
  }

  @Contract("_, _, _, _ -> param1")
  public static <T> @NonNull List<T> lengthBetween(@NonNull List<T> arg, String name, int min, int max) {
    notNull(arg, name);
    if (arg.size() < min || arg.size() > max) {
      throw new IllegalArgumentException(
        "\"%s\" must have between %d and %d elements! Provided: %d".formatted(name, min, max, arg.size()));
    }
    return arg;
  }

  @Contract("_, _, _ -> param1")
  public static <T> @NonNull List<T> minSize(@NonNull List<T> arg, String name, int min) {
    notNull(arg, name);
    if (arg.size() < min) {
      throw new IllegalArgumentException(
        "\"%s\" may not have less than %d element(s)! Provided: %d".formatted(name, min, arg.size()));
    }
    return arg;
  }
}
