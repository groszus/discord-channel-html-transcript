package dev.omardiaa.transcript.schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.schema.payload.Channel;
import dev.omardiaa.transcript.schema.payload.Guild;
import dev.omardiaa.transcript.schema.payload.Message;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public class Payload {
  private final Guild guild;
  private final Channel channel;
  private final List<Message> messages;

  @JsonCreator
  public Payload(
    @JsonProperty("guild") Guild guild,
    @JsonProperty("channel") Channel channel,
    @JsonProperty("messages") List<Message> messages) {
    this.guild = guild;
    this.channel = channel;
    this.messages = messages;
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

  @Override
  public String toString() {
    return "Payload{" +
           "guild=" + guild +
           ", channel=" + channel +
           ", messages=" + messages +
           '}';
  }
}
