package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://docs.discord.com/developers/resources/message#message-interaction-metadata-object">Interaction Metadata</a>
 */
@NullMarked
public record InteractionMetadata(
  InteractionType type,
  User user
) {
  @JsonCreator
  public InteractionMetadata(
    @JsonProperty(value = "type", required = true) InteractionType type,
    @JsonProperty(value = "user", required = true) User user
  ) {
    this.type = type;
    this.user = user;
  }
}
