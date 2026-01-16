package dev.omardiaa.transcript.api.util;

import org.jspecify.annotations.NullMarked;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@NullMarked
public final class TimeUtil {
  private static final DateTimeFormatter DATE_FULL =
    DateTimeFormatter.ofPattern("eeee, MMMM M, u 'at' h:mm a '(UTC)'", Locale.US);

  private static final DateTimeFormatter DATE_LONG =
    DateTimeFormatter.ofPattern("MMMM d, u", Locale.US);

  private static final DateTimeFormatter DATE_SHORT =
    DateTimeFormatter.ofPattern("M/d/uu, h:mm a '(UTC)'", Locale.US);

  private static final DateTimeFormatter TIME_SHORT =
    DateTimeFormatter.ofPattern("h:mm a", Locale.US);

  private TimeUtil() {}

  public static OffsetDateTime toOffsetDateTime(String iso8601) {
    try {
      return OffsetDateTime.parse(iso8601).withOffsetSameInstant(ZoneOffset.UTC);
    } catch (RuntimeException ex) {
      throw new IllegalArgumentException("'" + iso8601 + "' is not a valid ISO8601 timestamp", ex);
    }
  }

  public static String formatDateFull(OffsetDateTime timestamp) {
    return timestamp.format(DATE_FULL);
  }

  public static String formatDateLong(OffsetDateTime timestamp) {
    return timestamp.format(DATE_LONG);
  }

  public static String formatDateShort(OffsetDateTime timestamp) {
    return timestamp.format(DATE_SHORT);
  }

  public static String formatTimeShort(OffsetDateTime timestamp) {
    return timestamp.format(TIME_SHORT);
  }
}
