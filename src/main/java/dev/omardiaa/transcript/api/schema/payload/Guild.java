package dev.omardiaa.transcript.api.schema.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.schema.payload.util.Role;
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

  @JsonCreator
  public Guild(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("icon") @Nullable String icon,
    @JsonProperty("roles") List<Role> roles) {
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
   * Helper Method
   *
   * @return {@link String} - Formatted Guild Icon URL, or base64 image of {@link Guild#getName()} initials if
   * {@link Guild#getIcon()} returns null.
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
