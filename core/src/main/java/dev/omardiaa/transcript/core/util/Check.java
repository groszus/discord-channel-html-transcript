package dev.omardiaa.transcript.core.util;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Collection;

/**
 * A utility class providing validation methods.
 */
@NullMarked
public final class Check {
  private Check() {}

  /**
   * @param expression
   *   the boolean to evaluate.
   * @param message
   *   the exception message format.
   * @param messageArgs
   *   the exception message format arguments.
   *
   * @throws IllegalArgumentException
   *   if the {@code expression} evaluates to {@code false}.
   */
  private static void check(boolean expression, String message, Object... messageArgs) {
    if (!expression) {
      throw new IllegalArgumentException(String.format(message, messageArgs));
    }
  }

  /**
   * @param arg
   *   the object to validate.
   * @param argName
   *   the name of the argument, used in the exception message.
   *
   * @throws IllegalArgumentException
   *   if the provided {@code arg} is {@code null}.
   */
  private static void notNull(@Nullable Object arg, String argName) {
    if (arg == null) {
      throw new IllegalArgumentException(argName + " must not be null");
    }
  }

  /**
   * @param arg
   *   the string to validate.
   *
   * @return {@code true} if the string is {@code null} or blank, otherwise returns {@code false}.
   */
  public static boolean isBlank(@Nullable String arg) {
    return arg == null || arg.isBlank();
  }

  /**
   * @param arg
   *   the string to validate.
   * @param fallback
   *   the default string to return if {@code arg} is blank.
   *
   * @return {@code arg} if the string is not blank, otherwise returns the provided {@code fallback}.
   */
  public static String defaultIfBlank(@Nullable String arg, String fallback) {
    if (isBlank(arg)) {
      return fallback;
    }
    return arg;
  }

  /**
   * @param arg
   *   the string to validate.
   * @param min
   *   the minimum allowed length (inclusive).
   * @param max
   *   the maximum allowed length (inclusive).
   * @param argName
   *   the name of the argument, used in the exception message.
   *
   * @return the validated string.
   *
   * @throws IllegalArgumentException
   *   if the string is {@code null}, or if its length is outside the provided range.
   */
  public static String lengthRange(String arg, int min, int max, String argName) {
    notNull(arg, argName);
    long length = arg.codePoints().count();
    check(
      min <= length && length <= max,
      "\"%s\" must be between %d and %d characters! Found %s characters.",
      argName,
      min,
      max,
      length);
    return arg;
  }

  /**
   * @param arg
   *   the string to validate.
   * @param argName
   *   the name of the argument, used in the exception message.
   * @param max
   *   the maximum allowed length (inclusive).
   *
   * @return the validated string.
   *
   * @throws IllegalArgumentException
   *   if the string is {@code null}, or if its length exceeds the provided {@code max}.
   */
  public static String lengthMax(String arg, String argName, int max) {
    notNull(arg, argName);
    long length = arg.codePoints().count();
    check(
      length <= max,
      "\"%s\" must not be longer than %d characters! Found %s characters.",
      argName,
      max,
      length);
    return arg;
  }

  /**
   * @param arg
   *   the {@link Collection} to validate.
   * @param min
   *   the minimum allowed size (inclusive).
   * @param max
   *   the maximum allowed size (inclusive).
   * @param argName
   *   the name of the argument, used in the exception message.
   * @param <T>
   *   the type of elements in the collection.
   * @param <C>
   *   the type of the {@link Collection}.
   *
   * @return the validated collection.
   *
   * @throws IllegalArgumentException
   *   if the collection is {@code null}, or if its size is outside the provided range.
   */
  public static <T, C extends Collection<T>> C sizeBetween(C arg, String argName, int min, int max) {
    notNull(arg, argName);
    int size = arg.size();
    check(
      size >= min && size <= max,
      "\"%s\" must have between %d and %d elements! Found %d elements.",
      argName,
      min,
      max,
      size);
    return arg;
  }

  /**
   * @param arg
   *   the {@link Collection} to validate.
   * @param min
   *   the minimum allowed size (inclusive).
   * @param argName
   *   the name of the argument, used in the exception message.
   * @param <T>
   *   the type of elements in the collection.
   * @param <C>
   *   the type of the {@link Collection}.
   *
   * @return the validated collection.
   *
   * @throws IllegalArgumentException
   *   if the collection is {@code null}, or if its size is smaller than the provided {@code min}.
   */
  public static <T, C extends Collection<T>> C sizeMin(C arg, String argName, int min) {
    notNull(arg, argName);
    int size = arg.size();
    check(
      size >= min,
      "\"%s\" may not have less than %d element(s)! Found %d elements.",
      argName,
      min,
      size);
    return arg;
  }
}
