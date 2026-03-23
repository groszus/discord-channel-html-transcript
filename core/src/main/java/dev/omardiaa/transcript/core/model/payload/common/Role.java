package dev.omardiaa.transcript.core.model.payload.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://docs.discord.com/developers/topics/permissions#role-object">Role</a>
 */
@NullMarked
public record Role(
  @JsonProperty(value = "id", required = true) String id,
  @JsonProperty(value = "name", required = true) String name,
  @JsonProperty(value = "colors", required = true) Colors colors
) {
  /**
   * <a href="https://docs.discord.com/developers/topics/permissions#role-object-role-colors-object">Role Colors</a>
   */
  @NullMarked
  public record Colors(
    @JsonProperty(value = "primary_color", required = true) int primaryColor
  ) {}
}
