package dev.omardiaa.transcript.server.config;

import dev.omardiaa.transcript.core.config.EnvironmentConfig;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class JavalinConfig {
  private static final String JAVALIN_HOST = EnvironmentConfig.get("JAVALIN_HOST", "0.0.0.0");
  private static final int JAVALIN_PORT = EnvironmentConfig.get("JAVALIN_PORT", 7000);

  private JavalinConfig() {}

  public static String getJavalinHost() {
    return JAVALIN_HOST;
  }

  public static int getJavalinPort() {
    return JAVALIN_PORT;
  }
}
