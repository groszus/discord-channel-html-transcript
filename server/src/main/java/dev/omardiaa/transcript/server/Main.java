package dev.omardiaa.transcript.server;

public class Main {
  public static void main(String[] args) {
    Server server = Server.getInstance();

    server.start();

    Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
  }
}
