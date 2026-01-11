package dev.omardiaa.transcript;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.omardiaa.transcript.config.JacksonProblemHandler;
import dev.omardiaa.transcript.controller.TranscriptController;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

import java.util.Objects;

class Main {
  public static void main(String[] args) {
    int port = Integer.parseInt(Objects.requireNonNullElse(System.getenv("PORT"), "8080"));

    Javalin javalin = Javalin.createAndStart(config -> {
      config.jetty.defaultPort = port;
      config.jsonMapper(new JavalinJackson().updateMapper(mapper -> mapper
        .addHandler(new JacksonProblemHandler())
        .registerModules(new JavaTimeModule())
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)));
    });

    javalin.post("/transcript", new TranscriptController(new Transcriber()));
  }
}
