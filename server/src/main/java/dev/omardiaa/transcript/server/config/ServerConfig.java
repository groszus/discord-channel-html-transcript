package dev.omardiaa.transcript.server.config;

import dev.omardiaa.transcript.core.util.EnvironmentUtil;
import dev.omardiaa.transcript.server.Server;
import dev.omardiaa.transcript.server.model.SemVer;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * A helper class for initializing {@link Server} configuration.
 */
@NullMarked
public final class ServerConfig {
  private static final @Nullable String API_KEY = EnvironmentUtil.get("TRANSCRIPT_SERVER_API_KEY").orElse(null);
  private static final String HOST = EnvironmentUtil.get("TRANSCRIPT_SERVER_HOST", "127.0.0.1");
  private static final int PORT = EnvironmentUtil.get("TRANSCRIPT_SERVER_PORT", 7000);
  private static final SemVer VERSION = new SemVer(ServerInfo.VERSION);

  private ServerConfig() {}

  /**
   * @return {@code TRANSCRIPT_SERVER_API_KEY} value, or {@code null} if variable is not specified.
   */
  public static @Nullable String getApiKey() {
    return API_KEY;
  }

  /**
   * @return {@code TRANSCRIPT_SERVER_HOST} value, or {@code "127.0.0.1"} if variable is not specified.
   */
  public static String getHost() {
    return HOST;
  }

  /**
   * @return {@code TRANSCRIPT_SERVER_PORT} value, or {@code 7000} if variable is not specified.
   */
  public static int getPort() {
    return PORT;
  }

  /**
   * @return {@code ${project.version}}.
   */
  public static SemVer getVersion() {
    return VERSION;
  }
}
