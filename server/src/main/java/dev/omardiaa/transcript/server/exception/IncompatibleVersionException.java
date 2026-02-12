package dev.omardiaa.transcript.server.exception;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class IncompatibleVersionException extends RuntimeException {
  private final @Nullable String version;

  public IncompatibleVersionException(String message) {
    this(message, null);
  }

  public IncompatibleVersionException(String message, @Nullable String version) {
    super(message);
    this.version = version;
  }

  /**
   * @return The incompatible version, or {@code null} if not specified.
   */
  public @Nullable String getVersion() {
    return version;
  }
}
