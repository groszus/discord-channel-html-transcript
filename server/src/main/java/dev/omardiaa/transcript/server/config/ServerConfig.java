package dev.omardiaa.transcript.server.config;

import dev.omardiaa.transcript.core.config.EnvironmentConfig;
import dev.omardiaa.transcript.server.model.SemVer;
import org.jspecify.annotations.NullMarked;

import java.io.InputStream;
import java.util.Properties;

/**
 * Helper class that holds server environment variables.
 */
@NullMarked
public final class ServerConfig {
  private static final SemVer VERSION;
  private static final String HOST = EnvironmentConfig.get("SERVER_HOST", "0.0.0.0");
  private static final int PORT = EnvironmentConfig.get("SERVER_PORT", 7000);

  private ServerConfig() {}

  static {
    try (InputStream is = ServerConfig.class.getResourceAsStream("/build.properties")) {
      Properties properties = new Properties();
      properties.load(is);
      VERSION = new SemVer(properties.getProperty("version"));
    } catch (Exception e) {
      throw new RuntimeException("Failed to load server version.", e);
    }
  }

  /**
   * @return {@code ${project.version}}.
   */
  public static SemVer getVersion() {
    return VERSION;
  }

  /**
   * @return {@code SERVER_HOST} value, or {@code "0.0.0.0"} if {@code SERVER_HOST} variable returns {@code null}.
   */
  public static String getHost() {
    return HOST;
  }

  /**
   * @return {@code SERVER_PORT} value, or {@code 7000} if {@code SERVER_PORT} variable returns {@code null}.
   */
  public static int getPort() {
    return PORT;
  }
}
