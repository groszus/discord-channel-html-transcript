package dev.omardiaa.transcript.server.exception;

import io.javalin.http.HttpStatus;
import org.jspecify.annotations.NullMarked;

import java.util.Collections;
import java.util.Map;

@NullMarked
record ErrorResponse(int status, String error, String message, Map<String, String> details) {
  public ErrorResponse(HttpStatus status, String error, String message) {
    this(status.getCode(), error, message, Collections.emptyMap());
  }

  public ErrorResponse(HttpStatus status, String error, String message, Map<String, String> details) {
    this(status.getCode(), error, message, details);
  }
}
