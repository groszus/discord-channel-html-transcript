package dev.omardiaa.transcript.core.service;

import dev.omardiaa.transcript.core.config.TranscriberConfig;
import dev.omardiaa.transcript.core.model.Payload;
import gg.jte.output.Utf8ByteOutput;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

/**
 * A class for transcribing {@link Payload}s.
 * <br>
 * Uses <a href="https://github.com/casid/jte/">Java Template Engine</a> for HTML generation.
 */
@NullMarked
public class Transcriber {
  /**
   * @param payload
   *   the {@link Payload} to transcribe.
   *
   * @return {@link CompletableFuture} of the raw byte output representing the transcribed channel.
   */
  public CompletableFuture<Utf8ByteOutput> transcribe(Payload payload) {
    return CompletableFuture.supplyAsync(
      () -> {
        Utf8ByteOutput output = new Utf8ByteOutput();
        TranscriberConfig.getTemplateEngine().render("index.jte", payload, output);
        return output;
      },
      TranscriberConfig.getExecutor());
  }
}
