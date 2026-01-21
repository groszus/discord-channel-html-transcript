package dev.omardiaa.transcript.server.config;

import dev.omardiaa.transcript.core.config.EnvironmentConfig;
import org.jspecify.annotations.NullMarked;

import java.io.InputStream;
import java.util.Properties;

/**
 * Helper class that holds server environment variables.
 */
@NullMarked
public final class ServerConfig {
  private static final String VERSION;
  private static final String HOST = EnvironmentConfig.get("SERVER_HOST", "0.0.0.0");
  private static final int PORT = EnvironmentConfig.get("SERVER_PORT", 7000);

  private ServerConfig() {}

  static {
    Properties properties = new Properties();

    try (InputStream is = ServerConfig.class.getResourceAsStream(
      "/META-INF/maven/dev.omardiaa/discord-html-transcript-server/pom.properties")) {
      if (is != null) {
        properties.load(is);
      }

      VERSION = properties.getProperty("version", "DEV");
    } catch (Exception e) {
      throw new RuntimeException("Failed to set server version from 'pom.properties'.", e);
    }
  }

  /**
   * @return Server version, or {@code "DEV"} if ran in development environment.
   */
  public static String getVersion() {
    return VERSION;
  }

  /**
   * @return {@code SERVER_HOST} value, or {@code "0.0.0.0"} if {@code SERVER_HOST} variable is not specified.
   */
  public static String getHost() {
    return HOST;
  }

  /**
   * @return {@code SERVER_PORT} value, or {@code 7000} if {@code SERVER_PORT} variable is not specified.
   */
  public static int getPort() {
    return PORT;
  }
}
