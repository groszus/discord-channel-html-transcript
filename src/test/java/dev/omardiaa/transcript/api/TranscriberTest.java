package dev.omardiaa.transcript.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class TranscriberTest {
  private final Path tempDir = Path.of(System.getProperty("java.io.tmpdir")).resolve("discord-html-transcript-api");

  private AutoCloseable mocks;

  @BeforeEach
  void setUp() throws IOException {
    mocks = MockitoAnnotations.openMocks(this);

    if (!Files.exists(tempDir)) {
      Files.createDirectories(tempDir);
    }
  }

  @AfterEach
  void tearDown() throws Exception {
    mocks.close();
  }
}
