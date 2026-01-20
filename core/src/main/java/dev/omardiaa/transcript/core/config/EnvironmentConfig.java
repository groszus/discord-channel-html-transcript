package dev.omardiaa.transcript.core.config;

import org.jspecify.annotations.NullMarked;

import java.util.Optional;

@NullMarked
public final class EnvironmentConfig {
  private EnvironmentConfig() {}

  public static String get(String key, String defaultValue) {
    return getOptional(key).orElse(defaultValue);
  }

  public static int get(String key, int defaultValue) {
    return getOptional(key).map(Integer::parseInt).orElse(defaultValue);
  }

  public static boolean get(String key, boolean defaultValue) {
    return getOptional(key).map(Boolean::parseBoolean).orElse(defaultValue);
  }

  private static Optional<String> getOptional(String key) {
    String value = System.getenv(key);
    return (value == null || value.isBlank()) ? Optional.empty() : Optional.of(value);
  }
}
