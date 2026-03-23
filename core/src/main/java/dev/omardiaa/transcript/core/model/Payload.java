package dev.omardiaa.transcript.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.Channel;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.service.Transcriber;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;

/**
 * A model class for the required payload to transcribe.
 *
 * @see Transcriber#transcribe(Payload)
 */
@NullMarked
public record Payload(
  Guild guild,
  Channel channel,
  List<Message> messages,
  @Nullable String stylePath
) {
  /**
   * @param guild
   *   the Discord Guild.
   * @param channel
   *   the Discord Channel that belongs to the provided {@code guild}.
   * @param messages
   *   the Discord Messages that belong to the provided {@code channel}.
   * @param stylePath
   *   the custom {@code style.css} path.
   *
   * @see Transcriber#transcribe(Payload)
   */
  @JsonCreator
  public Payload(
    @JsonProperty("guild") Guild guild,
    @JsonProperty("channel") Channel channel,
    @JsonProperty("messages") List<Message> messages,
    @JsonProperty("stylePath") @Nullable String stylePath
  ) {
    this.guild = guild;
    this.channel = channel;
    this.messages = Check.sizeMin(messages, "messages", 1);
    this.stylePath = stylePath;
  }
}
