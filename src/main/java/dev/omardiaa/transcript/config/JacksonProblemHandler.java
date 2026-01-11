package dev.omardiaa.transcript.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JacksonProblemHandler extends DeserializationProblemHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(JacksonProblemHandler.class);

  @Override
  public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser p, JsonDeserializer<?> deserializer,
                                       Object beanOrClass, String propertyName) throws IOException {
    LOGGER.trace("Ignored Property: {}", p.skipChildren().getParsingContext().pathAsPointer().toString());
    return true;
  }
}
