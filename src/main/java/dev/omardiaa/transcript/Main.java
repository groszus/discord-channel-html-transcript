package dev.omardiaa.transcript;

import dev.omardiaa.transcript.config.Config;
import dev.omardiaa.transcript.controller.TranscriptController;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

public class Main {
  public static void main(String[] args) {
    Javalin javalin = Javalin.create(config -> {
      config.jetty.defaultHost = Config.JAVALIN_HOST;
      config.jetty.defaultPort = Config.JAVALIN_PORT;
      config.jsonMapper(new JavalinJackson(Config.getObjectMapper(), true));
    });

    javalin.post("/transcript", ctx -> new TranscriptController(new Transcriber(Config.getEngine())).handle(ctx));

    javalin.start();
  }
}
