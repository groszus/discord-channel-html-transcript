package dev.omardiaa.transcript.core.model.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.Role;
import dev.omardiaa.transcript.core.util.ImageUtil;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://docs.discord.com/developers/resources/guild#guild-object">Guild</a>
 */
@NullMarked
public record Guild(
  String name,
  @JsonIgnore String iconUrl,
  @JsonIgnore @Nullable Map<String, Role> rolesMap
) {
  public static final String GUILD_ICON_URL = "https://cdn.discordapp.com/icons/%s/%s.webp?animated=true";

  @JsonCreator
  public Guild(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "name", required = true) String name,
    @JsonProperty(value = "icon") @Nullable String icon,
    @JsonProperty(value = "roles", required = true) List<Role> roles
  ) {
    this(
      name,
      icon == null
        ? ImageUtil.drawGuildIcon(name)
        : GUILD_ICON_URL.formatted(id, icon),
      roles.isEmpty()
        ? null
        : roles.stream().collect(Collectors.toUnmodifiableMap(Role::id, Function.identity())));
  }
}
