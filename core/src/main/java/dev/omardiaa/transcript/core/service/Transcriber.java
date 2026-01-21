package dev.omardiaa.transcript.core.service;

import dev.omardiaa.transcript.core.config.TranscriberConfig;
import dev.omardiaa.transcript.core.model.Payload;
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
   * Constructs {@link Transcriber} with the configured {@link TemplateEngine}.
   *
   * @see TranscriberConfig#getTemplateEngine()
   */
  public Transcriber() {
    this.templateEngine = TranscriberConfig.getTemplateEngine();
  }

  /**
   * Constructs {@link Transcriber} with a custom {@link TemplateEngine}.
   *
   * @param templateEngine
   *   The custom {@link TemplateEngine}.
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
