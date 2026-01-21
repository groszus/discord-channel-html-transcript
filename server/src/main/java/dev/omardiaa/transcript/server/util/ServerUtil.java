package dev.omardiaa.transcript.server.util;

import dev.omardiaa.transcript.server.config.ServerConfig;
import dev.omardiaa.transcript.server.exception.IncompatibleClientException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NullMarked
public final class ServerUtil {
  private static final Pattern SEMVER = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)$");

  private ServerUtil() {}

  /**
   * Checks the client version against the server version.
   * <p>
   * The check is skipped if:
   * <ul>
   *   <li>{@code clientVersion} returns {@code null}, this allows custom implementations to use the server.</li>
   *   <li>{@link ServerConfig#getVersion()} returns {@code "DEV"}.</li>
   * </ul>
   *
   * @param clientVersion
   *   The {@code Client-Version} header value.
   *
   * @throws IncompatibleClientException
   *   If the {@code Client-Version}'s Major or Minor versions do not match.
   */
  public static void checkClientVersion(@Nullable String clientVersion) throws IncompatibleClientException {
    if (clientVersion == null || ServerConfig.getVersion().equals("DEV")) {
      return;
    }

    Version serverSemVer = parseSemVer(ServerConfig.getVersion());
    Version clientSemVer = parseSemVer(clientVersion);

    if (serverSemVer == null || clientSemVer == null) {
      return;
    }

    if (!serverSemVer.isCompatibleWith(clientSemVer)) {
      throw new IncompatibleClientException(ServerConfig.getVersion(), clientVersion);
    }
  }

  private static @Nullable Version parseSemVer(String semver) {
    Matcher matcher = SEMVER.matcher(semver);

    if (matcher.matches()) {
      int major = Integer.parseInt(matcher.group(1));
      int minor = Integer.parseInt(matcher.group(2));
      return new Version(major, minor);
    }

    return null;
  }

  /**
   * Internal representation of the library's Semantic Version.
   * <br>
   * Only {@code Major} and {@code Minor} are stored, {@code Patch} is ignored in compatibility checks.
   */
  private record Version(int major, int minor) {
    boolean isCompatibleWith(Version other) {
      return this.major == other.major && this.minor == other.minor;
    }
  }
}
