package dev.omardiaa.transcript;

import dev.omardiaa.transcript.schema.Payload;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.Utf8ByteOutput;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Transcribes a {@link GuildMessageChannel} into a {@link Transcript} as HTML.
 * <p>
 * Uses <a href="https://github.com/casid/jte/">Java Template Engine</a> for HTML generation.
 */
@NullMarked
public class Transcriber {
  private final ExecutorService executor = Executors.newCachedThreadPool();
  private final TemplateEngine templateEngine;

  /**
   * Constructs {@link Transcriber} with a <a href="https://jte.gg/pre-compiling/">precompiled</a>
   * {@link TemplateEngine}.
   */
  public Transcriber() {
    this.templateEngine = TemplateEngine.createPrecompiled(ContentType.Html);
  }

  /**
   * Constructs {@link Transcriber} with the specified {@code templateEngine}.
   * <p>
   * This constructor is only used during testing.
   *
   * @param templateEngine
   *   The {@link TemplateEngine} used for transcription.
   */
  Transcriber(TemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
  }

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
    return transcribe(payload, null);
  }

  /**
   * @param payload
   *   The {@link Payload} to transcribe.
   * @param testStyle
   *   The path to the test {@code style.css}, only specified during testing.
   *
   * @return A {@link CompletableFuture} of the transcribed {@link Transcript}.
   * <p>
   * The future completes exceptionally with {@link IllegalArgumentException}
   * if the specified {@code channel} contains no messages.
   */
  CompletableFuture<Transcript> transcribe(Payload payload, @Nullable String testStyle) {
    if (payload.getMessages().isEmpty()) {
      return CompletableFuture.failedFuture(
        new IllegalArgumentException("'#%s' contains no messages.".formatted(payload.getChannel().getName())));
    }

    return CompletableFuture.supplyAsync(
      () -> {
        Map<String, Object> params = new HashMap<>();
        params.put("payload", payload);
        params.put("testStyle", testStyle);

        Utf8ByteOutput output = new Utf8ByteOutput();
        templateEngine.render("transcript.jte", params, output);

        return new Transcript(output);
      });
  }
}
