package dev.omardiaa.transcript.api.controller;

import dev.omardiaa.transcript.api.Transcriber;
import dev.omardiaa.transcript.api.schema.Payload;
import io.javalin.http.*;
import org.jspecify.annotations.NonNull;

public final class TranscriptController implements Handler {
  private final Transcriber transcriber;

  public TranscriptController() {
    this.transcriber = new Transcriber();
  }

  @Override
  public void handle(@NonNull Context ctx) {
    Payload payload = ctx.bodyStreamAsClass(Payload.class);

    ctx.future(() -> transcriber
      .transcribe(payload)
      .thenAccept(transcript -> {
        ctx.status(HttpStatus.OK);
        ctx.header(Header.CONTENT_TYPE, ContentType.HTML);
        ctx.result(transcript.getByteArray());
      }));
  }
}
