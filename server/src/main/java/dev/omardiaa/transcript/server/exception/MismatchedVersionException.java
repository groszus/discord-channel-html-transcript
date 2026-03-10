package dev.omardiaa.transcript.server.exception;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Indicates a mismatch between the server and the client versions.
 */
@NullMarked
public class MismatchedVersionException extends RuntimeException {
  private final @Nullable String version;

  /**
   * Constructs a new {@link MismatchedVersionException}.
   *
   * @param message
   *   the detail message.
   */
  public MismatchedVersionException(String message) {
    this(message, null);
  }

  /**
   * Constructs a new {@link MismatchedVersionException}.
   *
   * @param message
   *   the detail message.
   * @param version
   *   the incompatible version.
   */
  public MismatchedVersionException(String message, @Nullable String version) {
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
