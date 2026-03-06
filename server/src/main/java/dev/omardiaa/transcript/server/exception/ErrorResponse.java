package dev.omardiaa.transcript.server.exception;

import io.javalin.http.HttpStatus;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Map;

@NullMarked
record ErrorResponse(int status, String message, @Nullable Map<String, String> details) {
  public ErrorResponse(HttpStatus status, String message) {
    this(status.getCode(), message, null);
  }

  public ErrorResponse(HttpStatus status, String message, Map<String, String> details) {
    this(status.getCode(), message, details);
  }
}
