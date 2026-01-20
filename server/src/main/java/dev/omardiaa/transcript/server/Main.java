package dev.omardiaa.transcript.server;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import dev.omardiaa.transcript.core.config.TranscriberConfig;
import dev.omardiaa.transcript.server.config.JavalinConfig;
import dev.omardiaa.transcript.server.controller.TranscriptController;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.json.JavalinJackson;

public class Main {
  public static void main(String[] args) {
    TranscriptController transcriptController = new TranscriptController();

    Javalin.create(config -> config.jsonMapper(new JavalinJackson(TranscriberConfig.getObjectMapper(), true)))
           .exception(
             MismatchedInputException.class, (e, ctx) -> {
               ctx.json(new ErrorRepsponse(HttpStatus.BAD_REQUEST, e.getMessage()));
             })
           .post("/transcript", transcriptController::create)
           .start(JavalinConfig.getJavalinHost(), JavalinConfig.getJavalinPort());
  }

  private record ErrorRepsponse(int status, String detail) {
    public ErrorRepsponse(HttpStatus status, String detail) {
      this(status.getCode(), detail);
    }
  }
}
