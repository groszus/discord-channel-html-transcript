package dev.omardiaa.transcript.server.exception;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class IncompatibleClientException extends RuntimeException {
  private final String serverVersion;
  private final @Nullable String clientVersion;

  public IncompatibleClientException(String serverVersion, @Nullable String clientVersion) {
    super("Client version is incompatible with the Server version.");
    this.serverVersion = serverVersion;
    this.clientVersion = clientVersion;
  }

  public String getServerVersion() {
    return serverVersion;
  }

  public @Nullable String getClientVersion() {
    return clientVersion;
  }
}
