package dev.omardiaa.transcript.server.model;

import dev.omardiaa.transcript.core.util.Check;
import dev.omardiaa.transcript.server.exception.MismatchedVersionException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A record representing a <a href="https://semver.org/">Semantic Version</a>.
 */
@NullMarked
public record SemVer(int major, int minor, int patch, @Nullable String qualifier) {
  private static final Pattern PATTERN = Pattern.compile(
    "^v?(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$");

  /**
   * Parses the provided {@code version} into a new {@link SemVer} instance.
   *
   * @param version
   *   the version to parse.
   *
   * @return a new {@link SemVer} instance.
   *
   * @throws MismatchedVersionException
   *   if the provided {@code version} is {@code null}, blank, or invalid.
   */
  public static SemVer parse(@Nullable String version) {
    if (Check.isBlank(version)) {
      throw new MismatchedVersionException("Version cannot be null or blank.");
    }

    Matcher matcher = PATTERN.matcher(version);

    if (!matcher.matches()) {
      throw new MismatchedVersionException(
        "Invalid version format. Expected: [v](major).(minor).(patch)[-(qualifier)]",
        version
      );
    }

    return new SemVer(
      Integer.parseInt(matcher.group(1)),
      Integer.parseInt(matcher.group(2)),
      Integer.parseInt(matcher.group(3)),
      matcher.group(4)
    );
  }

  /**
   * @return {@code true} if a pre-release qualifier is present, otherwise {@code false}.
   */
  public boolean isPreRelease() {
    return !Check.isBlank(qualifier);
  }

  @Override
  public boolean equals(Object o) {
    if (getClass() != o.getClass()) {
      return false;
    }
    SemVer semVer = (SemVer) o;
    return major == semVer.major && minor == semVer.minor && patch == semVer.patch && Objects.equals(
      qualifier,
      semVer.qualifier
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder().append(major).append(".").append(minor).append(".").append(patch);

    if (isPreRelease()) {
      sb.append("-").append(qualifier);
    }

    return sb.toString();
  }
}
