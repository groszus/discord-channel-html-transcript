package dev.omardiaa.transcript.api;

import dev.omardiaa.transcript.api.config.TranscriberConfig;
import dev.omardiaa.transcript.api.schema.Payload;
import gg.jte.output.Utf8ByteOutput;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

/**
 * Transcribes a {@link Payload} into a {@link Transcript}.
 * <p>
 * Uses <a href="https://github.com/casid/jte/">Java Template Engine</a> to generate the HTML transcript.
 */
@NullMarked
public class Transcriber {
  /**
   * @param payload
   *   The {@link Payload} to transcribe.
   *
   * @return A {@link CompletableFuture} of the transcribed {@link Transcript}.
   * <p>
   * The future completes exceptionally with {@link IllegalArgumentException}
   * if the specified {@code channel} contains no messages.
   */
  public CompletableFuture<Transcript> transcribe(Payload payload) {
    if (payload.getMessages().isEmpty()) {
      return CompletableFuture.failedFuture(
        new IllegalArgumentException("'#%s' contains no messages.".formatted(payload.getChannel().getName())));
    }

    return CompletableFuture.supplyAsync(
      () -> {
        Utf8ByteOutput output = new Utf8ByteOutput();
        TranscriberConfig.getTemplateEngine().render("index.jte", payload, output);

        return new Transcript(output);
      });
  }
}
