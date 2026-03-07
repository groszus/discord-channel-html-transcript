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

@NullMarked
public class Payload {
  private final Guild guild;
  private final Channel channel;
  private final List<Message> messages;
  private final @Nullable String stylePath;

  /**
   * Constructs a payload that's used to generate the HTML.
   *
   * @param guild
   *   Discord Guild.
   * @param channel
   *   Discord Channel from {@code guild}.
   * @param messages
   *   Discord Messages from {@code channel}.
   * @param stylePath
   *   Only specify if you want to use an alternative {@code style.css}.
   *
   * @see Transcriber#transcribe(Payload)
   */
  @JsonCreator
  public Payload(
    @JsonProperty("guild") Guild guild,
    @JsonProperty("channel") Channel channel,
    @JsonProperty("messages") List<Message> messages,
    @JsonProperty("stylePath") @Nullable String stylePath) {
    this.guild = guild;
    this.channel = channel;
    this.messages = Check.sizeMin(messages, "messages", 1);
    this.stylePath = stylePath;
  }

  public Guild getGuild() {
    return guild;
  }

  public Channel getChannel() {
    return channel;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public @Nullable String getStylePath() {
    return stylePath;
  }

  @Override
  public String toString() {
    return "Payload{" +
           "guild=" + guild +
           ", channel=" + channel +
           ", messages=" + messages +
           ", testStylePath='" + stylePath + '\'' +
           '}';
  }
}
