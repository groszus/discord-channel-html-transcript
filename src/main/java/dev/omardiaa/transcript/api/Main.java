package dev.omardiaa.transcript.api;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import dev.omardiaa.transcript.api.config.TranscriberConfig;
import dev.omardiaa.transcript.api.controller.TranscriptController;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.json.JavalinJackson;

public class Main {
  public static void main(String[] args) {
    TranscriptController transcriptController = new TranscriptController();

    Javalin.create(config -> config.jsonMapper(new JavalinJackson(TranscriberConfig.getObjectMapper(), true)))
           .exception(
             Exception.class, (e, ctx) -> {
               ctx.json(new ErrorRepsponse(400, e.getMessage()));
             })
           .exception(
             MismatchedInputException.class, (e, ctx) -> {
               ctx.json(new ErrorRepsponse(HttpStatus.BAD_REQUEST, e.getMessage()));
             })
           .exception(
             ValueInstantiationException.class, (e, ctx) -> {
               ctx.json(new ErrorRepsponse(400, e.getMessage()));
             })
           .post("/transcript", transcriptController::create)
           .start(TranscriberConfig.JAVALIN_HOST, TranscriberConfig.JAVALIN_PORT);
  }

  private record ErrorRepsponse(int status, String detail) {
    public ErrorRepsponse(HttpStatus status, String detail) {
      this(status.getCode(), detail);
    }
  }
}
