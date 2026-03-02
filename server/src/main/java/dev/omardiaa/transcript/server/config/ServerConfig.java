package dev.omardiaa.transcript.server.config;

import dev.omardiaa.transcript.core.util.EnvironmentUtil;
import dev.omardiaa.transcript.server.Server;
import dev.omardiaa.transcript.server.model.SemVer;
import org.jspecify.annotations.NullMarked;

import java.io.InputStream;
import java.util.Properties;

/**
 * A helper class for initializing {@link Server} configuration.
 */
@NullMarked
public final class ServerConfig {
  private static final String HOST = EnvironmentUtil.get("JAVALIN_SERVER_HOST", "127.0.0.1");
  private static final int PORT = EnvironmentUtil.get("JAVALIN_SERVER_PORT", 7000);

  private static final SemVer VERSION;

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
