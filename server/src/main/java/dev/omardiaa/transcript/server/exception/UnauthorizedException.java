package dev.omardiaa.transcript.server.exception;

/**
 * Indicates that the client does not have authorization to connect to the server.
 */
public class UnauthorizedException extends RuntimeException {
  public UnauthorizedException() {
    super("An unauthorized client attempted to connect to the server.");
  }
}
