package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Discord Select Menus:
 * <ul>
 *   <li><a href="https://docs.discord.com/developers/components/reference#string-select">String Select</a></li>
 *   <li><a href="https://docs.discord.com/developers/components/reference#user-select">User Select</a></li>
 *   <li><a href="https://docs.discord.com/developers/components/reference#role-select">Role Select</a></li>
 *   <li><a href="https://docs.discord.com/developers/components/reference#mentionable-select">Mentionable Select</a></li>
 *   <li><a href="https://docs.discord.com/developers/components/reference#channel-select">Channel Select</a></li>
 * </ul>
 */
@NullMarked
public record SelectMenu(
  int type,
  String placeholder
) implements ActionRowChildComponent {
  @JsonCreator
  public SelectMenu(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "placeholder") @Nullable String placeholder
  ) {
    this.type = type;
    this.placeholder = Check.defaultIfBlank(placeholder, "Make a selection");
  }
}
