package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

/**
 * <a href="https://docs.discord.com/developers/resources/user#user-object">User</a>
 */
@NullMarked
public record User(
  String id,
  String username,
  @Nullable String discriminator,
  String globalName,
  @JsonIgnore String avatarUrl,
  @JsonIgnore @Nullable String tag
) {
  public static final String DEFAULT_USER_AVATAR_URL = "https://cdn.discordapp.com/embed/avatars/%s.png";
  public static final String USER_AVATAR_URL = "https://cdn.discordapp.com/avatars/%s/%s.webp?animated=true";

  @JsonCreator
  public User(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "username", required = true) String username,
    @JsonProperty(value = "discriminator", required = true) String discriminator,
    @JsonProperty(value = "global_name") @Nullable String globalName,
    @JsonProperty(value = "avatar") @Nullable String avatar,
    @JsonProperty(value = "bot") @Nullable Boolean bot,
    @JsonProperty(value = "system") @Nullable Boolean system
  ) {
    this(
      id,
      username,
      discriminator.equals("0") ? null : discriminator,
      Check.defaultIfBlank(globalName, username),
      resolveAvatarUrl(id, discriminator, avatar),
      resolveTag(bot, system)
    );
  }

  private static String resolveAvatarUrl(String id, String discriminator, @Nullable String avatar) {
    if (avatar != null) {
      return USER_AVATAR_URL.formatted(id, avatar);
    } else if (discriminator.equals("0")) {
      return DEFAULT_USER_AVATAR_URL.formatted((Long.parseLong(id) >> 22) % 6);
    } else {
      return DEFAULT_USER_AVATAR_URL.formatted(Short.parseShort(discriminator) % 5);
    }
  }

  private static @Nullable String resolveTag(@Nullable Boolean bot, @Nullable Boolean system) {
    if (bot != null && bot) {
      return "APP";
    }

    if (system != null && system) {
      return "SYSTEM";
    }

    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
