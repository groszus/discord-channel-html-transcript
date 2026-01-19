package dev.omardiaa.transcript.api.service;

import dev.omardiaa.transcript.api.config.TranscriberConfig;
import dev.omardiaa.transcript.api.model.Payload;
import gg.jte.TemplateEngine;
import gg.jte.output.Utf8ByteOutput;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

/**
 * Transcribes a {@link Payload}.
 * <br>
 * Uses <a href="https://github.com/casid/jte/">Java Template Engine</a> to generate the HTML.
 */
@NullMarked
public class Transcriber {
  private final TemplateEngine templateEngine;

  /**
   * Constructs {@link Transcriber} with the default {@link TemplateEngine}.
   *
   * @see TranscriberConfig#getTemplateEngine()
   */
  public Transcriber() {
    this.templateEngine = TranscriberConfig.getTemplateEngine();
  }

  /**
   * Constructs {@link Transcriber} with a custom {@link TemplateEngine}.
   * <br>
   * This is for testing purposes.
   *
   * @param templateEngine
   *   A custom {@link TemplateEngine}, use with caution.
   */
  Transcriber(TemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
  }

  /**
   * @param payload
   *   The {@link Payload} to transcribe.
   *
   * @return {@link CompletableFuture} of the raw byte output representing the transcribed channel.
   */
  public CompletableFuture<Utf8ByteOutput> transcribe(Payload payload) {
    return CompletableFuture.supplyAsync(() -> {
      Utf8ByteOutput output = new Utf8ByteOutput();
      templateEngine.render("index.jte", payload, output);
      return output;
    });
  }
}
