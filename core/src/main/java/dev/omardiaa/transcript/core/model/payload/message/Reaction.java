package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://docs.discord.com/developers/resources/message#reaction-object">Reaction</a>
 */
@NullMarked
public record Reaction(
  @JsonProperty(value = "count", required = true) int count,
  @JsonProperty(value = "emoji", required = true) Emoji emoji
) {}
