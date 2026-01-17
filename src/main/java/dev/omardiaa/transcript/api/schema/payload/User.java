package dev.omardiaa.transcript.api.schema.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

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
    @JsonProperty("id") String id,
    @JsonProperty("username") String username,
    @JsonProperty("discriminator") String discriminator,
    @JsonProperty("global_name") @Nullable String globalName,
    @JsonProperty("avatar") @Nullable String avatar,
    @JsonProperty("bot") @Nullable Boolean bot,
    @JsonProperty("system") @Nullable Boolean system) {
    this.id = id;
    this.username = Check.inRange(username, 2, 32, "username");
    this.discriminator = discriminator;
    this.globalName = Check.notBlankElse(globalName, username);
    this.avatar = avatar;
    this.bot = Check.notNullElse(bot, false);
    this.system = Check.notNullElse(system, false);
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
    }

    if (isSystem()) {
      return "SYSTEM";
    }

    return null;
  }

  /**
   * Helper Method
   * <p>
   * <a href="https://discord.com/developers/docs/reference#image-formatting-cdn-endpoints">CDN Endpoints</a>
   *
   * @return Formatted Avatar URL
   */
  @JsonIgnore
  public String getAvatarUrl() {
    return getAvatar() == null
      ? DEFAULT_USER_AVATAR.formatted(getDefaultAvatar())
      : USER_AVATAR.formatted(getId(), getAvatar());
  }

  /**
   * Helper Method
   * <p>
   * <a href="https://discord.com/developers/docs/reference#image-formatting-cdn-endpoints">CDN Endpoints</a>
   *
   * @return Default Avatar Index
   */
  @JsonIgnore
  private String getDefaultAvatar() {
    return !getDiscriminator().equals("0000")
      ? String.valueOf((Long.parseLong(getId()) >> 22) % 6)
      : String.valueOf(Short.parseShort(getDiscriminator()) % 5);
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
