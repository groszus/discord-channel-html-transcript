package dev.omardiaa.transcript.server.util;

import dev.omardiaa.transcript.core.util.Check;
import dev.omardiaa.transcript.server.config.ServerConfig;
import dev.omardiaa.transcript.server.exception.IncompatibleVersionException;
import dev.omardiaa.transcript.server.model.SemVer;
import io.javalin.http.Context;
import io.javalin.http.UnauthorizedResponse;
import org.jspecify.annotations.NullMarked;

import java.util.Objects;

/**
 * A utility class for validating Javalin requests.
 */
@NullMarked
public final class ServerUtil {
  private ServerUtil() {}

  /**
   * Parses the {@code Server-Version} header from the provided Javalin {@link Context} and compares it with
   * {@link ServerConfig#getVersion()}.
   * <p>
   * Compatibility:
   * <ul>
   * <li>Pre-release versions must match exactly.</li>
   * <li>Major versions must match exactly.</li>
   * <li>{@code expected} minor version must be greater than or equal to the {@code actualVersion} minor version.</li>
   * </ul>
   *
   * @param ctx
   *   the Javalin {@link Context}.
   *
   * @throws IncompatibleVersionException
   *   if any of the compatibility rules are violated.
   */
  public static void validateVersion(Context ctx) {
    SemVer actualVersion = new SemVer(ctx.header("Server-Version"));
    SemVer expectedVersion = ServerConfig.getVersion();

    if (expectedVersion.isPreRelease() || actualVersion.isPreRelease()) {
      if (!expectedVersion.equals(actualVersion)) {
        throw new IncompatibleVersionException("Pre-release versions must match exactly.", actualVersion.toString());
      }

      return;
    }

    if (expectedVersion.getMajor() != actualVersion.getMajor()) {
      throw new IncompatibleVersionException("Major versions must match exactly.", actualVersion.toString());
    }

    if (expectedVersion.getMinor() < actualVersion.getMinor()) {
      throw new IncompatibleVersionException(
        "Expected minor version must be greater than or equal to the actual minor version.",
        actualVersion.toString());
    }
  }

  /**
   * Parses the {@code Authorization} header from the provided Javalin {@link Context} and compares it with
   * {@link ServerConfig#getApiKey()}.
   *
   * @param ctx
   *   the Javalin {@link Context}.
   *
   * @throws UnauthorizedResponse
   *   if the provided key in the {@code Authorization} header does not match {@link ServerConfig#getApiKey()}.
   */
  public static void validateApiKey(Context ctx) {
    String authHeader = ctx.header("Authorization");
    String authType = "Bearer ";

    if (Check.isBlank(authHeader)) {
      throw new UnauthorizedResponse("Authorization header is missing.");
    }

    if (!authHeader.startsWith(authType)) {
      throw new UnauthorizedResponse("Authorization header must start with \"Bearer \".");
    }

    String key = authHeader.substring(authType.length());

    if (!Objects.equals(key, ServerConfig.getApiKey())) {
      throw new UnauthorizedResponse("API Key is invalid.");
    }
  }
}
