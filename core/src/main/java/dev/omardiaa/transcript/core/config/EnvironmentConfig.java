package dev.omardiaa.transcript.core.config;

import org.jspecify.annotations.NullMarked;

import java.util.Optional;

/**
 * Helper class for loading environment variables.
 */
@NullMarked
public final class EnvironmentConfig {
  private EnvironmentConfig() {}

  /**
   * @param key
   *   Variable name.
   * @param defaultValue
   *   Default value to return if {@link System#getenv(String)} returns null.
   *
   * @return {@link System#getenv(String)},
   * or {@code defaultValue} if {@link #getOptional(String)} is empty.
   */
  public static String get(String key, String defaultValue) {
    return getOptional(key).orElse(defaultValue);
  }

  /**
   * @param key
   *   Variable name.
   * @param defaultValue
   *   Default value to return if {@link System#getenv(String)} returns null.
   *
   * @return {@link System#getenv(String)} as {@code int},
   * or {@code defaultValue} if {@link #getOptional(String)} is empty.
   */
  public static int get(String key, int defaultValue) {
    return getOptional(key).map(Integer::parseInt).orElse(defaultValue);
  }

  /**
   * @param key
   *   Variable name.
   * @param defaultValue
   *   Default value to return if {@link System#getenv(String)} returns null.
   *
   * @return {@link System#getenv(String)} as {@code boolean},
   * or {@code defaultValue} if {@link #getOptional(String)} is empty.
   */
  public static boolean get(String key, boolean defaultValue) {
    return getOptional(key).map(Boolean::parseBoolean).orElse(defaultValue);
  }

  /**
   * @param key
   *   Variable name.
   *
   * @return {@link Optional} of {@link System#getenv(String)}.
   */
  private static Optional<String> getOptional(String key) {
    String value = System.getenv(key);
    return (value == null || value.isBlank()) ? Optional.empty() : Optional.of(value);
  }
}
