package dev.omardiaa.transcript.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.Channel;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.PayloadOptions;
import dev.omardiaa.transcript.core.service.Transcriber;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;

/**
 * @param guild
 *   the Discord Guild.
 * @param channel
 *   the Discord Channel that belongs to the provided {@code guild}.
 * @param messages
 *   the Discord Messages that belong to the provided {@code channel}.
 * @param options
 *   the transcript options.
 *
 * @see Transcriber#transcribe(Payload)
 */
@NullMarked
public record Payload(
  Guild guild,
  Channel channel,
  List<Message> messages,
  PayloadOptions options
) {
  /**
   * @param guild
   *   the Discord Guild.
   * @param channel
   *   the Discord Channel that belongs to the provided {@code guild}.
   * @param messages
   *   the Discord Messages that belong to the provided {@code channel}.
   * @param options
   *   the transcript options.
   *
   * @see Transcriber#transcribe(Payload)
   */
  @JsonCreator
  public Payload(
    @JsonProperty(value = "guild", required = true) Guild guild,
    @JsonProperty(value = "channel", required = true) Channel channel,
    @JsonProperty(value = "messages", required = true) List<Message> messages,
    @JsonProperty(value = "options") @Nullable PayloadOptions options
  ) {
    this.guild = guild;
    this.channel = channel;
    this.messages = Check.sizeMin(messages, "messages", 1);
    this.options = options != null ? options : new PayloadOptions();
  }
}
