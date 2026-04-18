package dev.omardiaa.transcript.core.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.omardiaa.transcript.core.service.Transcriber;
import dev.omardiaa.transcript.core.util.EnvironmentUtil;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A class for configuring the {@link Transcriber}.
 */
@NullMarked
public final class TranscriberConfig {
  private static final Logger LOGGER = LoggerFactory.getLogger(TranscriberConfig.class);
  private static final boolean JTE_DEV = EnvironmentUtil.get("JTE_DEV", false);
  private static final ExecutorService EXECUTOR = Executors
    .newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
    .registerModule(new JavaTimeModule())
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true)
    .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

  private static final TemplateEngine TEMPLATE_ENGINE;

  private TranscriberConfig() {}

  static {
    if (JTE_DEV) {
      TEMPLATE_ENGINE = TemplateEngine.create(new ResourceCodeResolver("jte"), ContentType.Html);
      TEMPLATE_ENGINE.setBinaryStaticContent(true);
      LOGGER.info("Java Template Engine is running in development mode.");
    } else {
      TEMPLATE_ENGINE = TemplateEngine.createPrecompiled(ContentType.Html);
      LOGGER.info("Java Template Engine is running in production mode.");
    }
  }

  /**
   * @return the {@link ExecutorService} for transcription.
   */
  public static ExecutorService getExecutor() {
    return EXECUTOR;
  }

  /**
   * @return the default {@link ObjectMapper}.
   */
  public static ObjectMapper getObjectMapper() {
    return OBJECT_MAPPER;
  }

  /**
   * @return the default {@link TemplateEngine}.
   */
  public static TemplateEngine getTemplateEngine() {
    return TEMPLATE_ENGINE;
  }

  /**
   * Gracefully shuts down the {@link #EXECUTOR}.
   */
  public static void shutdownExecutor() {
    LOGGER.info("Shutting down executor...");

    EXECUTOR.shutdown();

    try {
      if (!EXECUTOR.awaitTermination(5, TimeUnit.SECONDS)) {
        EXECUTOR.shutdownNow();
      }
    } catch (InterruptedException e) {
      EXECUTOR.shutdownNow();
      Thread.currentThread().interrupt();
    }

    LOGGER.info("Executor has shutdown.");
  }
}
