package dev.omardiaa.transcript.api.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NullMarked
public final class TranscriberConfig {
  private static final Logger LOGGER = LoggerFactory.getLogger(TranscriberConfig.class);

  public static final String JAVALIN_HOST = getEnv("JAVALIN_HOST", "0.0.0.0");
  public static final int JAVALIN_PORT = getEnv("JAVALIN_PORT", 7000);
  public static final boolean JTE_DEV = getEnv("JTE_DEV", false);

  private static final TemplateEngine TEMPLATE_ENGINE;
  private static final ObjectMapper OBJECT_MAPPER;

  static {
    OBJECT_MAPPER = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

    if (JTE_DEV) {
      TEMPLATE_ENGINE = TemplateEngine.create(new ResourceCodeResolver("jte"), ContentType.Html);
      TEMPLATE_ENGINE.setBinaryStaticContent(true);
      LOGGER.info("JTE is running in development mode.");
    } else {
      TEMPLATE_ENGINE = TemplateEngine.createPrecompiled(ContentType.Html);
      LOGGER.info("JTE is running in production mode.");
    }
  }

  private TranscriberConfig() {}

  public static TemplateEngine getTemplateEngine() {
    return TEMPLATE_ENGINE;
  }

  public static ObjectMapper getObjectMapper() {
    return OBJECT_MAPPER;
  }

  private static String getEnv(String key, String defaultValue) {
    String value = System.getenv(key);
    return value != null ? value : defaultValue;
  }

  private static int getEnv(String key, int defaultValue) {
    String value = System.getenv(key);
    if (value != null) {
      try {
        return Integer.parseInt(value);
      } catch (NumberFormatException ex) {
        LOGGER.warn("'{}' Invalid number. Using default '{}'", key, defaultValue);
      }
    }
    return defaultValue;
  }

  private static boolean getEnv(String key, boolean defaultValue) {
    String value = System.getenv(key);
    return value != null ? Boolean.parseBoolean(value) : defaultValue;
  }
}
