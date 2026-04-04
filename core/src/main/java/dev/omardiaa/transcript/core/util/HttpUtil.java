package dev.omardiaa.transcript.core.util;

import org.jspecify.annotations.NullMarked;

import java.net.http.HttpClient;
import java.time.Duration;

/**
 * A helper class for a simple HTTP interface.
 */
@NullMarked
public class HttpUtil {
  private HttpUtil() {}

  private static class ClientHolder {
    private static final HttpClient INSTANCE = HttpClient
      .newBuilder()
      .connectTimeout(Duration.ofSeconds(15))
      .followRedirects(HttpClient.Redirect.NORMAL)
      .build();
  }

  public static HttpClient getClient() {
    return ClientHolder.INSTANCE;
  }
}
