package dev.omardiaa.transcript.core.util;

import org.jspecify.annotations.NullMarked;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility class for String manipulation.
 */
@NullMarked
public final class StringUtil {
  /**
   * @param input
   *   the input to escape.
   *
   * @return the escaped sequence.
   */
  public static CharSequence escape(CharSequence input) {
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
    CharSequence input, int start, int end, String escapeSequence, StringBuilder output) {
    output.append(input, start, end);
    output.append(escapeSequence);
    return end + 1;
  }

  /**
   * @param pattern
   *   the pattern to match.
   * @param input
   *   the input to match with the pattern.
   * @param replacer
   *   the function to replace the matched pattern.
   *
   * @return the updated sequence.
   */
  public static CharSequence replace(Pattern pattern, CharSequence input, Function<Matcher, String> replacer) {
    Matcher matcher = pattern.matcher(input);

    if (!matcher.find()) {
      return input;
    }

    int lastIndex = 0;
    int length = input.length();
    StringBuilder output = new StringBuilder(length);

    do {
      output.append(input, lastIndex, matcher.start());
      output.append(replacer.apply(matcher));
      lastIndex = matcher.end();
    } while (matcher.find());

    output.append(input, lastIndex, length);

    return output;
  }
}
