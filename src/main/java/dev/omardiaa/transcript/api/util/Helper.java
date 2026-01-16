package dev.omardiaa.transcript.api.util;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.stream.Collectors;

@NullMarked
public final class Helper {
  private final static long KB = 1024;
  private final static long MB = KB * KB;
  private final static long GB = MB * KB;

  private Helper() {}

  public static boolean isEmpty(@Nullable CharSequence seq) {
    return seq == null || seq.isEmpty();
  }

  public static boolean isBlank(CharSequence seq) {
    if (isEmpty(seq)) {
      return true;
    }
    for (int i = 0; i < seq.length(); i++) {
      if (!Character.isWhitespace(seq.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public static int codePointLength(CharSequence string) {
    return (int) string.codePoints().count();
  }

  public static String getInitials(String str) {
    return Arrays.stream(str.trim().split("\\s+"))
                 .map(word -> word.substring(0, 1))
                 .limit(3)
                 .collect(Collectors.joining())
                 .toUpperCase();
  }

  /**
   * @param bytes
   *   Number of bytes to parse.
   *
   * @return {@code 1024 byte/KB/MB/GB}.
   */
  public static String formatBytes(int bytes) {
    if (bytes < KB) {
      return "%s bytes".formatted(bytes);
    } else if (bytes < MB) {
      return "%.2f KB".formatted((double) bytes / KB);
    } else if (bytes < GB) {
      return "%.2f MB".formatted((double) bytes / MB);
    } else {
      return "%.2f GB".formatted((double) bytes / GB);
    }
  }
}
