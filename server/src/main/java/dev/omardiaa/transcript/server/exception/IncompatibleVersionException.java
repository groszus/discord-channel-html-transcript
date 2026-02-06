package dev.omardiaa.transcript.server.exception;

import dev.omardiaa.transcript.server.util.SemVer;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class IncompatibleVersionException extends RuntimeException {
  private final SemVer serverVersion;
  private final @Nullable SemVer clientVersion;

  public IncompatibleVersionException(String message, SemVer serverVersion, @Nullable SemVer clientVersion) {
    super(message);
    this.serverVersion = serverVersion;
    this.clientVersion = clientVersion;
  }

  public SemVer getServerVersion() {
    return serverVersion;
  }

  public @Nullable SemVer getClientVersion() {
    return clientVersion;
  }
}
