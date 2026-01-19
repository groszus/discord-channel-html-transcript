package dev.omardiaa.transcript.api.model.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.model.payload.common.Role;
import dev.omardiaa.transcript.api.util.IconUtil;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@NullMarked
public class Guild {
  public static final String GUILD_ICON = "https://cdn.discordapp.com/icons/%s/%s.webp?animated=true";

  private final String id;
  private final String name;
  private final @Nullable String icon;

  @JsonIgnore
  private final Map<String, Role> rolesMap;

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/guild#guild-resource">Guild</a>.
   */
  @JsonCreator
  public Guild(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "name", required = true) String name,
    @JsonProperty(value = "icon") @Nullable String icon,
    @JsonProperty(value = "roles", required = true) List<Role> roles) {
    this.id = id;
    this.name = name;
    this.icon = icon;

    this.rolesMap = roles.isEmpty()
      ? Collections.emptyMap()
      : roles.stream().collect(Collectors.toUnmodifiableMap(Role::getId, Function.identity()));
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public @Nullable String getIcon() {
    return icon;
  }

  @JsonIgnore
  public Map<String, Role> getRolesMap() {
    return rolesMap;
  }

  /**
   * @return <a href="https://discord.com/developers/docs/reference#image-formatting-cdn-endpoints">Formatted Icon URL</a>,
   * or base64 image of {@link Guild#getName()} initials if {@link Guild#getIcon()} returns {@code null}.
   */
  @JsonIgnore
  public String getIconUrl() {
    return getIcon() == null
      ? IconUtil.drawGuildIcon(getName())
      : GUILD_ICON.formatted(getId(), getIcon());
  }

  @Override
  public String toString() {
    return "Guild{" +
           "id='" + id + '\'' +
           ", name='" + name + '\'' +
           ", icon='" + icon + '\'' +
           ", rolesMap=" + rolesMap +
           '}';
  }
}
