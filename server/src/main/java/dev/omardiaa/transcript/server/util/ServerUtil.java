package dev.omardiaa.transcript.server.util;

import dev.omardiaa.transcript.server.exception.IncompatibleVersionException;
import dev.omardiaa.transcript.server.model.SemVer;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class ServerUtil {
  private ServerUtil() {}

  /**
   * Validates the specified {@code actual} version against the current specified {@code expected} version.
   * <p>
   * Compatibility Rules:
   * <ul>
   * <li>Pre-release versions must match exactly.</li>
   * <li>Major versions must match exactly.</li>
   * <li>{@code expected} minor version must be greater than or equal to the {@code actual} minor version.</li>
   * </ul>
   *
   * @param expected
   *   The current server version.
   * @param actual
   *   The version the client expects from the server.
   *
   * @throws IncompatibleVersionException
   *   If any of the compatibility rules are violated.
   */
  public static void validateVersions(SemVer expected, SemVer actual) {
    if ((expected.isPreRelease() || actual.isPreRelease()) && !expected.equals(actual)) {
      throw new IncompatibleVersionException("Pre-release versions must match exactly.", actual.toString());
    }

    if (expected.getMajor() != actual.getMajor()) {
      throw new IncompatibleVersionException("Major versions must match exactly.", actual.toString());
    }

    if (expected.getMinor() < actual.getMinor()) {
      throw new IncompatibleVersionException(
        "Expected minor version must be greater than or equal to the actual minor version.",
        actual.toString());
    }
  }
}
