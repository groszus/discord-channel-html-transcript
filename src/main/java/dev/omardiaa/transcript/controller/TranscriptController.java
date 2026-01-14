package dev.omardiaa.transcript.controller;

import dev.omardiaa.transcript.Transcriber;
import dev.omardiaa.transcript.schema.Payload;
import io.javalin.http.*;
import org.jspecify.annotations.NonNull;

public final class TranscriptController implements Handler {
  private final Transcriber transcriber;

  public TranscriptController(Transcriber transcriber) {
    this.transcriber = transcriber;
  }

  @Override
  public void handle(@NonNull Context ctx) {
    Payload payload = ctx.bodyStreamAsClass(Payload.class);

    ctx.future(() -> transcriber
      .transcribe(payload)
      .thenAccept(transcript -> {
        ctx.header(Header.CONTENT_TYPE, ContentType.HTML);
        ctx.status(HttpStatus.OK);
        ctx.result(transcript.getByteArray());
      }));
  }
}
