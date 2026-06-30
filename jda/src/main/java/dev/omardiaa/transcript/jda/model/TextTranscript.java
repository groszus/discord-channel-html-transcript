package dev.omardiaa.transcript.jda.model;

import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

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
}
