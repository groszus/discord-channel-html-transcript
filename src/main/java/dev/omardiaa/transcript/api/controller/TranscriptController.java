package dev.omardiaa.transcript.api.controller;

import dev.omardiaa.transcript.api.model.Payload;
import dev.omardiaa.transcript.api.service.Transcriber;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.Header;
import io.javalin.http.HttpStatus;
import org.jspecify.annotations.NonNull;

public class TranscriptController {
  private final Transcriber transcriber;

  public TranscriptController() {
    this.transcriber = new Transcriber();
  }

  public void create(@NonNull Context ctx) {
    Payload payload = ctx.bodyStreamAsClass(Payload.class);

    ctx.future(() -> transcriber
      .transcribe(payload)
      .thenAccept(output -> {
        ctx.status(HttpStatus.OK);
        ctx.header(Header.CONTENT_TYPE, ContentType.HTML);
        ctx.result(output.toByteArray());
      }));
  }
}
