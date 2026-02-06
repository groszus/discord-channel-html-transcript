package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

/**
 * Discord <a href="https://discord.com/developers/docs/resources/user#users-resource">User</a>.
 */
@NullMarked
public class User {
  public static final String DEFAULT_USER_AVATAR = "https://cdn.discordapp.com/embed/avatars/%s.png";
  public static final String USER_AVATAR = "https://cdn.discordapp.com/avatars/%s/%s.webp?animated=true";

  private final String id;
  private final String username;
  private final String discriminator;
  private final String globalName;
  private final @Nullable String avatar;
  private final boolean bot;
  private final boolean system;

  @JsonCreator
  public User(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "username", required = true) String username,
    @JsonProperty(value = "discriminator", required = true) String discriminator,
    @JsonProperty(value = "global_name") @Nullable String globalName,
    @JsonProperty(value = "avatar") @Nullable String avatar,
    @JsonProperty(value = "bot") @Nullable Boolean bot,
    @JsonProperty(value = "system") @Nullable Boolean system) {
    this.id = id;
    this.username = Check.lengthRange(username, 2, 32, "username");
    this.discriminator = discriminator;
    this.globalName = Check.defaultIfBlank(globalName, username);
    this.avatar = avatar;
    this.bot = Check.defaultIfNull(bot, false);
    this.system = Check.defaultIfNull(system, false);
  }

  public String getId() {
    return id;
  }

  public String getUsername() {
    return username + (!getDiscriminator().equals("0") ? "#" + getDiscriminator() : "");
  }

  public String getDiscriminator() {
    return discriminator;
  }

  public String getGlobalName() {
    return globalName;
  }

  public @Nullable String getAvatar() {
    return avatar;
  }

  public boolean isBot() {
    return bot;
  }

  public boolean isSystem() {
    return system;
  }

  /**
   * @return {@code "APP"} or {@code "SYSTEM"}.
   */
  @JsonIgnore
  public @Nullable String getTag() {
    if (isBot()) {
      return "APP";
    } else if (isSystem()) {
      return "SYSTEM";
    } else {
      return null;
    }
  }

  /**
   * @return <a href="https://discord.com/developers/docs/reference#image-formatting-cdn-endpoints">Formatted Avatar URL</a>.
   */
  @JsonIgnore
  public String getAvatarUrl() {
    return getAvatar() == null
      ? DEFAULT_USER_AVATAR.formatted(getDefaultAvatar())
      : USER_AVATAR.formatted(getId(), getAvatar());
  }

  /**
   * @return Default Avatar Index
   */
  @JsonIgnore
  private String getDefaultAvatar() {
    return !getDiscriminator().equals("0000")
      ? String.valueOf((Long.parseLong(getId()) >> 22) % 6)
      : String.valueOf(Short.parseShort(getDiscriminator()) % 5);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    return "User{" +
           "id='" + id + '\'' +
           ", username='" + username + '\'' +
           ", discriminator='" + discriminator + '\'' +
           ", globalName='" + globalName + '\'' +
           ", avatar='" + avatar + '\'' +
           ", bot=" + bot +
           ", system=" + system +
           '}';
  }
}
