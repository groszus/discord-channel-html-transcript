package dev.omardiaa.transcript;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TranscriberTest {
  private final Path tempDir = Path.of(System.getProperty("java.io.tmpdir")).resolve("discord-html-transcript-api");
  private final String testStyle = new File("src/test/resources/template/css/style.css").getAbsolutePath();

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

  @Test
  void transcribeThrowsIfEmpty() throws JsonProcessingException {
    CompletableFuture<Transcript> future = Transcriber.transcribe(TranscriberTestUtil.createPayload(), testStyle);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertInstanceOf(IllegalArgumentException.class, ex.getCause());
  }
}
