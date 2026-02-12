package dev.omardiaa.transcript.server.model;

import dev.omardiaa.transcript.server.exception.IncompatibleVersionException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NullMarked
public final class SemVer {
  private static final Pattern SEMVER = Pattern.compile(
    "^v?(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$");

  private final int major;
  private final int minor;
  private final int patch;
  private final @Nullable String qualifier;

  /**
   * Constructs a Semantic Version.
   *
   * @param version
   *   The version to parse.
   *
   * @throws IncompatibleVersionException
   *   <p><ul>
   *   <li>If the specified {@code version} returns {@code null}.</li>
   *   <li>If the specified {@code version} can not be parsed.</li>
   *   </ul></p>
   */
  public SemVer(@Nullable String version) {
    if (version == null || version.isBlank()) {
      throw new IncompatibleVersionException("Version can not be null.");
    }

    Matcher matcher = SEMVER.matcher(version);

    if (!matcher.matches()) {
      throw new IncompatibleVersionException(
        "Version format invalid, expected format: (major).(minor).(patch)?(qualifier).",
        version);
    }

    this.major = Integer.parseInt(matcher.group(1));
    this.minor = Integer.parseInt(matcher.group(2));
    this.patch = Integer.parseInt(matcher.group(3));
    this.qualifier = matcher.group(4);
  }

  public int getMajor() {
    return major;
  }

  public int getMinor() {
    return minor;
  }

  public boolean isPreRelease() {
    return this.qualifier != null && !this.qualifier.isBlank();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SemVer semVer = (SemVer) o;
    return major == semVer.major
           && minor == semVer.minor
           && patch == semVer.patch
           && Objects.equals(qualifier, semVer.qualifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(major, minor, patch, qualifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder()
      .append(major).append('.')
      .append(minor).append('.')
      .append(patch);

    if (qualifier != null && !qualifier.isBlank()) {
      sb.append('-').append(qualifier);
    }

    return sb.toString();
  }
}
