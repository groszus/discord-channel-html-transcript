package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://docs.discord.com/developers/resources/message#message-snapshot-object">Message Snapshot</a>
 */
@NullMarked
public record MessageSnapshot(
  MessageSnapshot.Message message
) {
  @JsonCreator
  public MessageSnapshot(
    @JsonProperty(value = "message", required = true) MessageSnapshot.Message message
  ) {
    this.message = message;
  }

  public record Message(
    String content
  ) {
    @JsonCreator
    public Message(
      @JsonProperty(value = "content", required = true) String content
    ) {
      this.content = content;
    }
  }
}
