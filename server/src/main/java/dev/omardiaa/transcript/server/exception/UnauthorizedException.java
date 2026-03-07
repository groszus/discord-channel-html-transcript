package dev.omardiaa.transcript.server.exception;

/**
 * Indicates that the client's request lacks valid credentials.
 */
public class UnauthorizedException extends RuntimeException {
  public UnauthorizedException() {
    super("Failed to authroize client, invalid or missing 'Bearer' token.");
  }
}
