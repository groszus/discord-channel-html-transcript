package dev.omardiaa.transcript;

import gg.jte.output.Utf8ByteOutput;
import org.jspecify.annotations.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Represents a Discord channel as HTML.
 */
public final class Transcript {
  private final Utf8ByteOutput output;

  /**
   * Constructs a new {@link Transcript} instance.
   *
   * @param output
   *   The {@link Utf8ByteOutput} of the transcribed Discord channel.
   */
  Transcript(@NonNull Utf8ByteOutput output) {
    this.output = output;
  }

  /**
   * Writes {@link Utf8ByteOutput} to the specified {@code file}.
   *
   * @param file
   *   The {@link File} to write the output into.
   *
   * @throws IOException
   *   If an I/O error occurs while writing to the file.
   */
  public void toFile(@NonNull File file) throws IOException {
    try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
      fileOutputStream.write(getByteArray());
    }
  }

  /**
   * Retrieves the raw byte output of the transcribed Discord channel.
   *
   * @return A byte array containing the HTML.
   */
  public byte[] getByteArray() {
    return output.toByteArray();
  }
}
