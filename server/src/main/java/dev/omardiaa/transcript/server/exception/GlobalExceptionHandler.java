package dev.omardiaa.transcript.server.exception;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
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
    LOGGER.warn(
      "Client version \"{}\" is incompatible with the Server version \"{}\".",
      e.getClientVersion(), e.getServerVersion());

    ctx.status(HttpStatus.CONFLICT).json(
      new ErrorResponse(
        HttpStatus.CONFLICT,
        "INCOMPATIBLE_CLIENT",
        e.getMessage(),
        Map.of(
          "server", e.getServerVersion().toString(),
          "client", e.getClientVersion() == null ? "null" : e.getClientVersion().toString())));
  }

  public static void handleMismatchedInput(MismatchedInputException e, Context ctx) {
    LOGGER.warn("Invalid JSON input.", e);

    ctx.status(HttpStatus.BAD_REQUEST).json(
      new ErrorResponse(
        HttpStatus.BAD_REQUEST,
        "INVALID_JSON",
        "The request body contains invalid data."));
  }

  public static void handleException(Exception e, Context ctx) {
    LOGGER.error("Encountered unhandled exception.", e);

    ctx.status(HttpStatus.INTERNAL_SERVER_ERROR).json(
      new ErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "INTERNAL_ERROR",
        "An unexpected error occurred."));
  }
}
