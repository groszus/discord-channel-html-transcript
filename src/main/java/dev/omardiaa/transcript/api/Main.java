package dev.omardiaa.transcript.api;

import dev.omardiaa.transcript.api.config.TranscriberConfig;
import dev.omardiaa.transcript.api.controller.TranscriptController;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

public class Main {
  public static void main(String[] args) {
    Javalin javalin = Javalin.create(config -> {
      config.jetty.defaultHost = TranscriberConfig.JAVALIN_HOST;
      config.jetty.defaultPort = TranscriberConfig.JAVALIN_PORT;
      config.jsonMapper(new JavalinJackson(TranscriberConfig.getObjectMapper(), true));
    });

    javalin.post("/transcript", new TranscriptController());

    javalin.start();
  }
}
