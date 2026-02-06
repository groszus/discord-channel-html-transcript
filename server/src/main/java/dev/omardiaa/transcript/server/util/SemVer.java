package dev.omardiaa.transcript.server.util;

import dev.omardiaa.transcript.server.exception.IncompatibleVersionException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NullMarked
public final class SemVer {
  private static final Pattern SEMVER = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)(?:-(.+))?$");

  private final int major;
  private final int minor;
  private final int patch;
  private final @Nullable String qualifier;

  /**
   * Constructs a Semantic Version using {@link #SEMVER}.
   *
   * @param version
   *   The version to parse.
   *
   * @throws IllegalArgumentException
   *   If the specified {@code version} can not be parsed.
   */
  public SemVer(String version) {
    Matcher matcher = SEMVER.matcher(version);

    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid Version format: " + version + ".");
    }

    this.major = Integer.parseInt(matcher.group(1));
    this.minor = Integer.parseInt(matcher.group(2));
    this.patch = Integer.parseInt(matcher.group(3));
    this.qualifier = matcher.group(4);
  }

  public boolean isPreRelease() {
    return qualifier != null && !qualifier.isBlank();
  }

  public void checkVersion(@Nullable String clientVersion) {
    if (clientVersion == null) {
      throw new IncompatibleVersionException("Client version can not be null.", this, null);
    }

    if (clientVersion.equals("latest")) {
      return;
    }

    SemVer clientSemVer = new SemVer(clientVersion);

    if (this.isPreRelease() || clientSemVer.isPreRelease()) {
      if (!this.equals(clientSemVer)) {
        throw new IncompatibleVersionException("Versions must be exact for pre-releases.", this, clientSemVer);
      }
    }

    if (this.major != clientSemVer.major) {
      throw new IncompatibleVersionException("Major version is different.", this, clientSemVer);
    }

    if (this.minor < clientSemVer.minor) {
      throw new IncompatibleVersionException(
        "Server minor version lower than Client minor version.", this, clientSemVer);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SemVer semVer = (SemVer) o;
    return major == semVer.major && minor == semVer.minor && patch == semVer.patch &&
           Objects.equals(qualifier, semVer.qualifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(major, minor, patch, qualifier);
  }

  @Override
  public String toString() {
    return major + "." + minor + "." + patch + (qualifier == null ? "" : "-" + qualifier);
  }
}
