package dev.omardiaa.transcript.server;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import dev.omardiaa.transcript.core.config.TranscriberConfig;
import dev.omardiaa.transcript.core.model.Payload;
import dev.omardiaa.transcript.core.service.Transcriber;
import dev.omardiaa.transcript.server.config.ServerConfig;
import dev.omardiaa.transcript.server.exception.GlobalExceptionHandler;
import dev.omardiaa.transcript.server.exception.IncompatibleVersionException;
import dev.omardiaa.transcript.server.exception.UnauthorizedException;
import dev.omardiaa.transcript.server.util.ServerUtil;
import io.javalin.Javalin;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.json.JavalinJackson;
import org.jspecify.annotations.NullMarked;

import java.util.Map;

/**
 * A singleton class for initializing, configuring, and running the Javalin server.
 */
@NullMarked
public final class Server {
  private static final Server INSTANCE = new Server();

  private final Javalin javalin;
  private final Transcriber transcriber;

  private Server() {
    this.transcriber = new Transcriber();
    this.javalin = Javalin
      .create(config -> {
        config.startup.showJavalinBanner = false;
        config.startup.showOldJavalinVersionWarning = false;

        config.jetty.host = ServerConfig.getHost();
        config.jetty.port = ServerConfig.getPort();

        config.jsonMapper(new JavalinJackson(TranscriberConfig.getObjectMapper(), false));

        config.routes
          .get("/health", this::healthHandler)
          .post("/transcript", this::transcriptHandler)
          .beforeMatched(ServerUtil::validateVersion)
          .exception(IncompatibleVersionException.class, GlobalExceptionHandler::handleIncompatibleVersion)
          .exception(UnauthorizedException.class, GlobalExceptionHandler::handleUnauthorized)
          .exception(MismatchedInputException.class, GlobalExceptionHandler::handleMismatchedInput)
          .exception(Exception.class, GlobalExceptionHandler::handleException);

        config.events.serverStopped(TranscriberConfig::shutdownExecutor);

        if (ServerConfig.getApiKey() != null) {
          config.routes.before(ServerUtil::validateApiKey);
        }
      });
  }

  /**
   * @return the singleton {@link Server} instance.
   */
  public static Server getInstance() {
    return INSTANCE;
  }

  /**
   * Starts the Javalin server.
   */
  public void start() {
    javalin.start();
  }

  /**
   * Stops the Javalin server.
   */
  public void stop() {
    javalin.stop();
  }

  /**
   * {@code GET /health} route handler.
   *
   * @param ctx
   *   the Javalin {@link Context}.
   */
  private void healthHandler(Context ctx) {
    ctx.status(HttpStatus.OK).json(Map.of("version", ServerConfig.getVersion().toString()));
  }

  /**
   * {@code POST /transcript} route handler.
   *
   * @param ctx
   *   the Javalin {@link Context}.
   */
  private void transcriptHandler(Context ctx) {
    Payload payload = ctx.bodyStreamAsClass(Payload.class);

    ctx.future(() -> transcriber
      .transcribe(payload)
      .thenAccept(output -> ctx
        .status(HttpStatus.OK)
        .contentType(ContentType.HTML)
        .result(output.toByteArray())));
  }
}
