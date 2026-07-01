package dev.omardiaa.transcript.core.util;

import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@NullMarked
public final class Helper {
  private static final Logger LOGGER = LoggerFactory.getLogger(Helper.class);
  private static final int KB = 1024;
  private static final int MB = KB * KB;
  private static final int GB = MB * KB;

  private Helper() {}

  /**
   * @param bytes
   *   the number of bytes to format.
   *
   * @return {@code eg. 1024 bytes/KB/MB/GB}.
   */
  public static String formatBytes(int bytes) {
    if (bytes < KB) {
      return "%s bytes".formatted(bytes);
    } else if (bytes < MB) {
      return "%.2f KB".formatted((float) bytes / KB);
    } else if (bytes < GB) {
      return "%.2f MB".formatted((float) bytes / MB);
    } else {
      return "%.2f GB".formatted((float) bytes / GB);
    }
  }

  /**
   * Attempts to download and encode the attachment at the provided {@code url} into a Base64 Data URI.
   *
   * @param url
   *   the remote URL of the attachment to download.
   *
   * @return a Base64 encoded Data URI string, or the {@code url} if the download or encoding fails.
   */
  public static String downloadAndEncode(String url) {
    try {
      HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
      HttpResponse<byte[]> response = HttpUtil.getClient().send(request, HttpResponse.BodyHandlers.ofByteArray());

      if (response.statusCode() >= 400) {
        return url;
      }

      String contentType = response.headers().firstValue("Content-Type").orElse("application/octet-stream");

      return "data:" + contentType + ";base64," + Base64.getEncoder().encodeToString(response.body());
    } catch (IOException e) {
      return url;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return url;
    }
  }
}
