package dev.omardiaa.transcript.server;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import dev.omardiaa.transcript.core.config.TranscriberConfig;
import dev.omardiaa.transcript.server.config.ServerConfig;
import dev.omardiaa.transcript.server.controller.TranscriptController;
import dev.omardiaa.transcript.server.exception.GlobalExceptionHandler;
import dev.omardiaa.transcript.server.exception.IncompatibleVersionException;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

public class Main {
  public static void main(String[] args) {
    JavalinJackson jsonMapper = new JavalinJackson(TranscriberConfig.getObjectMapper(), true);
    TranscriptController transcriptController = new TranscriptController();

    Javalin.create(config -> config.jsonMapper(jsonMapper))
           .before(ctx -> ServerConfig.getVersion().checkVersion(ctx.header("Client-Version")))
           .post("/transcript", transcriptController::create)
           .exception(MismatchedInputException.class, GlobalExceptionHandler::handleMismatchedInput)
           .exception(IncompatibleVersionException.class, GlobalExceptionHandler::handleIncompatibleVersion)
           .exception(Exception.class, GlobalExceptionHandler::handleException)
           .start(ServerConfig.getHost(), ServerConfig.getPort());
  }
}
