package dev.omardiaa.transcript.util;

public final class Helper {
  private Helper() {}

  public static boolean isEmpty(CharSequence seq) {
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
}
