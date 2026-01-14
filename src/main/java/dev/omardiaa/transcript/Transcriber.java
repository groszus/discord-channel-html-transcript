package dev.omardiaa.transcript;

import dev.omardiaa.transcript.schema.Payload;
import gg.jte.TemplateEngine;
import gg.jte.output.Utf8ByteOutput;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

/**
 * Transcribes a {@link GuildMessageChannel} into a {@link Transcript} as HTML.
 * <p>
 * Uses <a href="https://github.com/casid/jte/">Java Template Engine</a> for HTML generation.
 */
@NullMarked
public class Transcriber {
  private final TemplateEngine templateEngine;

  public Transcriber(TemplateEngine templateEngine) {
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
    if (payload.getMessages().isEmpty()) {
      return CompletableFuture.failedFuture(
        new IllegalArgumentException("'#%s' contains no messages.".formatted(payload.getChannel().getName())));
    }

    return CompletableFuture.supplyAsync(
      () -> {
        Utf8ByteOutput output = new Utf8ByteOutput();
        templateEngine.render("index.jte", payload, output);

        return new Transcript(output);
      });
  }
}
