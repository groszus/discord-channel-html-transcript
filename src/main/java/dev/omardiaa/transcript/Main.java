package dev.omardiaa.transcript;

import dev.omardiaa.transcript.config.TranscriberConfig;
import dev.omardiaa.transcript.controller.TranscriptController;
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
