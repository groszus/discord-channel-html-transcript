package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

/**
 * Message <a href="https://docs.discord.com/developers/resources/message#message-interaction-metadata-object">
 * Interaction Metadata
 * </a>.
 */
@NullMarked
public record InteractionMetadata(
  @JsonProperty(value = "type", required = true) InteractionType type,
  @JsonProperty(value = "user", required = true) User user
) {}
