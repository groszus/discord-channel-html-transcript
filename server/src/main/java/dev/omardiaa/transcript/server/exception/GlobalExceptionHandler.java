package dev.omardiaa.transcript.server.exception;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import dev.omardiaa.transcript.server.config.ServerConfig;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@NullMarked
public final class GlobalExceptionHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  private GlobalExceptionHandler() {}

  public static void handleIncompatibleVersion(IncompatibleVersionException e, Context ctx) {
    ctx.status(HttpStatus.CONFLICT).json(
      new ErrorResponse(
        HttpStatus.CONFLICT,
        e.getMessage(),
        Map.of(
          "expected",
          ServerConfig.getVersion().toString(),
          "actual",
          e.getVersion() == null ? "null" : e.getVersion())));
  }

  public static void handleUnauthorized(UnauthorizedException e, Context ctx) {
    ctx.status(HttpStatus.UNAUTHORIZED).json(
      new ErrorResponse(
        HttpStatus.UNAUTHORIZED,
        e.getMessage()));
  }

  public static void handleMismatchedInput(MismatchedInputException e, Context ctx) {
    ctx.status(HttpStatus.BAD_REQUEST).json(
      new ErrorResponse(
        HttpStatus.BAD_REQUEST,
        "The request body contains mismatched input.",
        Map.of(
          "path",
          e.getPathReference(),
          "problem",
          e.getOriginalMessage())));
  }

  public static void handleException(Exception e, Context ctx) {
    LOGGER.error("Encountered unhandled exception.", e);

    ctx.status(HttpStatus.INTERNAL_SERVER_ERROR).json(
      new ErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Encountered unhandled exception."));
  }
}
