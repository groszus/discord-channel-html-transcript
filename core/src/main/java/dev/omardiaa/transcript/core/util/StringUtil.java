package dev.omardiaa.transcript.core.util;

import org.jspecify.annotations.NullMarked;

/**
 * A utility class for String manipulation.
 */
@NullMarked
public final class StringUtil {
  /**
   * @param input
   *   the String to escape.
   *
   * @return the escaped String.
   */
  public static String escape(String input) {
    int lastIndex = 0;
    int length = input.length();

    StringBuilder output = new StringBuilder(length);

    for (int currentIndex = 0; currentIndex < length; currentIndex++) {
      switch (input.charAt(currentIndex)) {
        case '&' -> lastIndex = flushAndEscape(input, lastIndex, currentIndex, "&amp;", output);
        case '<' -> lastIndex = flushAndEscape(input, lastIndex, currentIndex, "&lt;", output);
        case '>' -> lastIndex = flushAndEscape(input, lastIndex, currentIndex, "&gt;", output);
      }
    }

    if (lastIndex == 0) {
      return input;
    }

    if (lastIndex < length) {
      output.append(input, lastIndex, length);
    }

    return output.toString();
  }

  /**
   * @param input
   *   the String to flush.
   * @param start
   *   the start index of the subsequence to be appended.
   * @param end
   *   the end index of the subsequence to be appended.
   * @param escapeSequence
   *   the safe sequence equivalent for the special HTML character.
   * @param output
   *   the output to be appended.
   *
   * @return the next index.
   */
  private static int flushAndEscape(
    String input, int start, int end, String escapeSequence, StringBuilder output) {
    output.append(input, start, end);
    output.append(escapeSequence);
    return end + 1;
  }
}
