package dev.omardiaa.transcript.server.exception;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Indicates that the client version is incompatible with the server version, or vice-versa.
 */
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
   * @return the incompatible version, or {@code null} if not specified.
   */
  public @Nullable String getVersion() {
    return version;
  }
}
