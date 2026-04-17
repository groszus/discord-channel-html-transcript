package dev.omardiaa.transcript.core.exception;

/**
 * Indicates an error occured during the generation of a transcript.
 */
public class TranscriberException extends RuntimeException {
  public TranscriberException(String message) {
    super(message);
  }
}
