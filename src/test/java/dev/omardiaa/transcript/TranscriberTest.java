package dev.omardiaa.transcript;

import com.fasterxml.jackson.core.JsonProcessingException;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
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

import static org.junit.jupiter.api.Assertions.*;

class TranscriberTest {
  private final Path tempDir = Path.of(System.getProperty("java.io.tmpdir")).resolve("discord-channel-html-transcript");
  private final String testStyle = new File("src/test/resources/template/css/style.css").getAbsolutePath();

  private AutoCloseable mocks;
  private Transcriber transcriber;

  @BeforeEach
  void setUp() throws IOException {
    mocks = MockitoAnnotations.openMocks(this);

    TemplateEngine templateEngine = TemplateEngine.create(new ResourceCodeResolver("templates"), ContentType.Html);
    templateEngine.setBinaryStaticContent(true);

    transcriber = new Transcriber(templateEngine);

    if (!Files.exists(tempDir)) {
      Files.createDirectories(tempDir);
    }
  }

  @AfterEach
  void tearDown() throws Exception {
    mocks.close();
  }

  @Test
  void transcribe() throws JsonProcessingException {
    File file = tempDir.resolve("transcript.html").toFile();

    transcriber.transcribe(TranscriberTestUtil.createPayload(), testStyle).thenAccept(
      transcript -> assertDoesNotThrow(() -> transcript.toFile(file)));
  }

  @Test
  void transcribeThrowsIfEmpty() throws JsonProcessingException {
    CompletableFuture<Transcript> future = transcriber.transcribe(TranscriberTestUtil.createPayload(), testStyle);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertInstanceOf(IllegalArgumentException.class, ex.getCause());
  }
}
