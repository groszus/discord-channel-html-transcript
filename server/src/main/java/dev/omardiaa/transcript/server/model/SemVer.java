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
   * Constructs a Semantic Version from parsing the specified {@code version}.
   *
   * @param version
   *   the version to parse.
   *
   * @throws IncompatibleVersionException
   *   if any of the following are true:
   *   <ul>
   *   <li>The specified {@code version} returns {@code null}.</li>
   *   <li>The specified {@code version} can not be parsed.</li>
   *   </ul>
   */
  public SemVer(@Nullable String version) {
    if (version == null || version.isBlank()) {
      throw new IncompatibleVersionException("Version can not be null.");
    }

    Matcher matcher = SEMVER.matcher(version);

    if (!matcher.matches()) {
      throw new IncompatibleVersionException(
        "Version format invalid, expected format: [v](major).(minor).(patch)[-(qualifier)].",
        version);
    }

    this.major = Integer.parseInt(matcher.group(1));
    this.minor = Integer.parseInt(matcher.group(2));
    this.patch = Integer.parseInt(matcher.group(3));
    this.qualifier = matcher.group(4);
  }

  /**
   * @return the {@code x} in {@code x.y.z}.
   */
  public int getMajor() {
    return major;
  }

  /**
   * @return the {@code y} in {@code x.y.z}.
   */
  public int getMinor() {
    return minor;
  }

  /**
   * @return {@code true} if a pre-release qualifier is present, otherwise {@code false}.
   */
  public boolean isPreRelease() {
    return qualifier != null && !qualifier.isBlank();
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
    String version = major + "." + minor + "." + patch;
    return isPreRelease() ? version + "-" + qualifier : version;
  }
}
