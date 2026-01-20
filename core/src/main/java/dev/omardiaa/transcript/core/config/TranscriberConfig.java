package dev.omardiaa.transcript.core.config;

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

  private static final boolean JTE_DEV = EnvironmentConfig.get("JTE_DEV", false);
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
      LOGGER.info("Java Template Engine is running in development mode.");
    } else {
      TEMPLATE_ENGINE = TemplateEngine.createPrecompiled(ContentType.Html);
      LOGGER.info("Java Template Engine is running in production mode.");
    }
  }

  private TranscriberConfig() {}

  public static TemplateEngine getTemplateEngine() {
    return TEMPLATE_ENGINE;
  }

  public static ObjectMapper getObjectMapper() {
    return OBJECT_MAPPER;
  }
}
