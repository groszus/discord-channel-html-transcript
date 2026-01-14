package dev.omardiaa.transcript.schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.schema.payload.Channel;
import dev.omardiaa.transcript.schema.payload.Guild;
import dev.omardiaa.transcript.schema.payload.Message;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;

@NullMarked
public class Payload {
  private final Guild guild;
  private final Channel channel;
  private final List<Message> messages;
  private final @Nullable String testStylePath;

  @JsonCreator
  public Payload(
    @JsonProperty("guild") Guild guild,
    @JsonProperty("channel") Channel channel,
    @JsonProperty("messages") List<Message> messages,
    @JsonProperty("testStylePath") @Nullable String testStylePath) {
    this.guild = guild;
    this.channel = channel;
    this.messages = messages;
    this.testStylePath = testStylePath;
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

  public @Nullable String getTestStylePath() {
    return testStylePath;
  }

  @Override
  public String toString() {
    return "Payload{" +
           "guild=" + guild +
           ", channel=" + channel +
           ", messages=" + messages +
           ", testStylePath='" + testStylePath + '\'' +
           '}';
  }
}
