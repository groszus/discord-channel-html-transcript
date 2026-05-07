package dev.omardiaa.transcript.server;

import dev.omardiaa.transcript.server.config.ServerConfig;
import org.slf4j.simple.SimpleLogger;

public class Main {
  static {
    System.setProperty(SimpleLogger.SHOW_SHORT_LOG_NAME_KEY, "true");
    System.setProperty(SimpleLogger.LEVEL_IN_BRACKETS_KEY, "true");
    System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, ServerConfig.getLogLevel());
    System.setProperty(SimpleLogger.LOG_KEY_PREFIX + "io.javalin", "WARN");
    System.setProperty(SimpleLogger.LOG_KEY_PREFIX + "org.eclipse.jetty", "WARN");
  }

  public static void main(String[] args) {
    Server server = Server.getInstance();

    server.start();

    Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
  }
}
