package dev.omardiaa.transcript.jda.model;

import net.dv8tion.jda.api.utils.FileUpload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.zip.GZIPOutputStream;

public final class TextTranscript {
  private final String content;

  public TextTranscript(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void toFile(File file) throws IOException {
    Files.writeString(file.toPath(), content, StandardCharsets.UTF_8);
  }

  public FileUpload toFileUpload() {
    return toFileUpload("transcript.txt");
  }

  public FileUpload toFileUpload(String filename) {
    return FileUpload.fromData(
      content.getBytes(StandardCharsets.UTF_8),
      filename.endsWith(".txt") ? filename : filename + ".txt");
  }

  public FileUpload toFileUploadGzipped() {
    return toFileUploadGzipped("transcript.txt.gz");
  }

  public FileUpload toFileUploadGzipped(String filename) {
    byte[] compressed = gzip(content.getBytes(StandardCharsets.UTF_8));
    return FileUpload.fromData(
      compressed,
      filename.endsWith(".txt.gz") || filename.endsWith(".gz") ? filename : filename + ".txt.gz");
  }

  private static byte[] gzip(byte[] data) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(data.length / 2);
    try (GZIPOutputStream gzipOut = new GZIPOutputStream(baos)) {
      gzipOut.write(data);
    } catch (IOException e) {
      throw new UncheckedIOException("Failed to gzip transcript", e);
    }
    return baos.toByteArray();
  }
}
