package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Discord Select Menus:
 *
 * <ul>
 *   <li><a href="https://discord.com/developers/docs/components/reference#string-select">String Select</a></li>
 *   <li><a href="https://discord.com/developers/docs/components/reference#user-select">User Select</a></li>
 *   <li><a href="https://discord.com/developers/docs/components/reference#role-select">Role Select</a></li>
 *   <li><a href="https://discord.com/developers/docs/components/reference#mentionable-select">Mentionable Select</a></li>
 *   <li><a href="https://discord.com/developers/docs/components/reference#channel-select">Channel Select</a></li>
 * </ul>
 */
@NullMarked
public class SelectMenu implements ActionRowChildComponent {
  private final int type;
  private final String placeholder;

  @JsonCreator
  public SelectMenu(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "placeholder") @Nullable String placeholder) {
    this.type = type;
    this.placeholder = Check.lengthMax(Check.defaultIfBlank(placeholder, "Make a selection"), 150, "placeholder");
  }

  @Override
  public int getType() {
    return type;
  }

  public String getPlaceholder() {
    return placeholder;
  }

  @Override
  public String toString() {
    return "SelectMenu{" +
           "type=" + type +
           ", placeholder='" + placeholder + '\'' +
           '}';
  }
}
