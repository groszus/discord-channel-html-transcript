package dev.omardiaa.transcript.controller;

import dev.omardiaa.transcript.Transcriber;
import dev.omardiaa.transcript.schema.Payload;
import io.javalin.http.*;
import org.jetbrains.annotations.NotNull;

public class TranscriptController implements Handler {
  private final Transcriber transcriber;

  public TranscriptController(Transcriber transcriber) {
    this.transcriber = transcriber;
  }

  @Override
  public void handle(@NotNull Context ctx) {
    Payload payload = ctx.bodyStreamAsClass(Payload.class);

    ctx.future(() -> transcriber
      .transcribe(payload)
      .thenAccept(transcript -> ctx.header(Header.CONTENT_TYPE, ContentType.HTML)
                                   .header(Header.CONTENT_DISPOSITION, "attachment; filename=\"transcript.html\"")
                                   .status(HttpStatus.OK)
                                   .result(transcript.getByteArray()))
      .exceptionally(throwable -> {
        ctx.status(HttpStatus.INTERNAL_SERVER_ERROR).result(throwable.getMessage());
        return null;
      }));
  }
}
