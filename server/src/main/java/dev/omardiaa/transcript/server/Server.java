package dev.omardiaa.transcript.server;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import dev.omardiaa.transcript.core.config.TranscriberConfig;
import dev.omardiaa.transcript.core.model.Payload;
import dev.omardiaa.transcript.core.service.Transcriber;
import dev.omardiaa.transcript.server.config.ServerConfig;
import dev.omardiaa.transcript.server.exception.GlobalExceptionHandler;
import dev.omardiaa.transcript.server.exception.IncompatibleVersionException;
import dev.omardiaa.transcript.server.model.SemVer;
import dev.omardiaa.transcript.server.util.ServerUtil;
import io.javalin.Javalin;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.json.JavalinJackson;
import org.jspecify.annotations.NullMarked;

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
      .create(config -> config.jsonMapper(new JavalinJackson(TranscriberConfig.getObjectMapper(), true)))
      .events(config -> config.serverStopped(TranscriberConfig::shutdownExecutor))
      .before(ctx -> ServerUtil.validateVersions(ServerConfig.getVersion(), new SemVer(ctx.header("Server-Version"))))
      .post("/transcript", this::transcriptHandler)
      .exception(MismatchedInputException.class, GlobalExceptionHandler::handleMismatchedInput)
      .exception(IncompatibleVersionException.class, GlobalExceptionHandler::handleIncompatibleVersion)
      .exception(Exception.class, GlobalExceptionHandler::handleException);
  }

  /**
   * @return the singleton {@link Server} instance.
   */
  public static Server getInstance() {
    return INSTANCE;
  }

  /**
   * Starts the Javalin server with the properties defined in {@link ServerConfig}.
   */
  public void start() {
    this.javalin.start(ServerConfig.getHost(), ServerConfig.getPort());
  }

  /**
   * Stops the Javalin server.
   */
  public void stop() {
    this.javalin.stop();
  }

  /**
   * {@code POST /transcript} route handler.
   *
   * @param ctx
   *   the Javalin {@link Context}.
   */
  private void transcriptHandler(Context ctx) {
    Payload payload = ctx.bodyStreamAsClass(Payload.class);

    ctx.future(() -> this.transcriber
      .transcribe(payload)
      .thenAccept(output -> ctx
        .status(HttpStatus.OK)
        .contentType(ContentType.HTML)
        .result(output.toByteArray())));
  }
}
