package dev.omardiaa.transcript.core.util;

import org.jspecify.annotations.NullMarked;

import java.util.Optional;

// TODO: implement better error handling for when the variables can not be parsed to their type.

/**
 * A helper class for loading environment variables.
 */
@NullMarked
public final class EnvironmentUtil {
  private EnvironmentUtil() {}

  /**
   * @param key
   *   the variable name.
   * @param defaultValue
   *   the default value to return if {@link System#getenv(String)} returns {@code null}.
   *
   * @return {@link System#getenv(String)}, or {@code defaultValue} if {@link #get(String)} is empty.
   */
  public static String get(String key, String defaultValue) {
    return get(key).orElse(defaultValue);
  }

  /**
   * @param key
   *   the variable name.
   * @param defaultValue
   *   the default value to return if {@link System#getenv(String)} returns {@code null}.
   *
   * @return {@link System#getenv(String)} as {@code int}, or {@code defaultValue} if {@link #get(String)} is empty.
   */
  public static int get(String key, int defaultValue) {
    return get(key).map(Integer::parseInt).orElse(defaultValue);
  }

  /**
   * @param key
   *   the variable name.
   * @param defaultValue
   *   the default value to return if {@link System#getenv(String)} returns {@code null}.
   *
   * @return {@link System#getenv(String)} as {@code boolean}, or {@code defaultValue} if {@link #get(String)} is empty.
   */
  public static boolean get(String key, boolean defaultValue) {
    return get(key).map(Boolean::parseBoolean).orElse(defaultValue);
  }

  /**
   * @param key
   *   the variable name.
   *
   * @return {@link Optional} of {@link System#getenv(String)}.
   */
  public static Optional<String> get(String key) {
    return Optional.ofNullable(System.getenv(key));
  }
}
