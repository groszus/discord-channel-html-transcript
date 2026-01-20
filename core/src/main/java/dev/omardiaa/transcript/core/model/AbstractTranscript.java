package dev.omardiaa.transcript.core.model;

import gg.jte.output.Utf8ByteOutput;
import org.jspecify.annotations.NullMarked;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Represents a channel as HTML in raw byte output.
 */
@NullMarked
public abstract class AbstractTranscript {
  private final Utf8ByteOutput output;

  /**
   * @param output
   *   The {@link Utf8ByteOutput} of the transcribed channel.
   */
  public AbstractTranscript(Utf8ByteOutput output) {
    this.output = output;
  }

  /**
   * @return Raw byte output of the transcribed channel.
   */
  public Utf8ByteOutput getOutput() {
    return output;
  }

  /**
   * Writes {@link Utf8ByteOutput#toByteArray()} into the specified {@code file}.
   *
   * @param file
   *   The {@link File} to write into.
   *
   * @throws IOException
   *   If an I/O error occurs while writing into the file.
   */
  public void toFile(File file) throws IOException {
    try (FileOutputStream fos = new FileOutputStream(file)) {
      fos.write(getOutput().toByteArray());
    }
  }
}
