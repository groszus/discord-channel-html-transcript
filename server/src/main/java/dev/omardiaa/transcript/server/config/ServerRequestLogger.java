package dev.omardiaa.transcript.server.config;

import io.javalin.http.Context;
import io.javalin.http.RequestLogger;
import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NullMarked
public class ServerRequestLogger implements RequestLogger {
  private static final Logger LOGGER = LoggerFactory.getLogger(ServerRequestLogger.class);

  @Override
  public void handle(Context ctx, Float executionTimeMs) {
    LOGGER.info(
      "{} {} [{}] {}ms",
      ctx.method(),
      ctx.path(),
      ctx.status(),
      executionTimeMs
    );
  }
}
