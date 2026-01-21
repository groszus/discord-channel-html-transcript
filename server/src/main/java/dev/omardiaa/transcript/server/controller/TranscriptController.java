package dev.omardiaa.transcript.server.controller;

import dev.omardiaa.transcript.core.model.Payload;
import dev.omardiaa.transcript.core.service.Transcriber;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.Header;
import io.javalin.http.HttpStatus;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class TranscriptController {
  private final Transcriber transcriber;

  public TranscriptController() {
    this.transcriber = new Transcriber();
  }

  public void create(Context ctx) {
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
