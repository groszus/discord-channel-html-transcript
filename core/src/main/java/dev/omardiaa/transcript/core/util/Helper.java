package dev.omardiaa.transcript.core.util;

import org.jspecify.annotations.NullMarked;

import java.util.Arrays;
import java.util.stream.Collectors;

@NullMarked
public final class Helper {
  private static final int KB = 1024;
  private static final int MB = KB * KB;
  private static final int GB = MB * KB;

  private Helper() {}

  /**
   * @param arg
   *   the sentence to retrieve the initials from.
   *
   * @return {@link String} of the first 3 initials in a sentence.
   */
  public static String getInitials(String arg) {
    return Arrays.stream(arg.trim().split("\\s+"))
                 .map(word -> word.substring(0, 1))
                 .limit(3)
                 .collect(Collectors.joining())
                 .toUpperCase();
  }

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
}
