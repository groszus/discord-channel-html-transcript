package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * <a href="https://docs.discord.com/developers/resources/poll#poll-object">Poll</a>
 */
@NullMarked
public record Poll(
  @JsonProperty(value = "question", required = true) Media question,
  @JsonProperty(value = "answers", required = true) List<Answer> answers,
  @JsonProperty(value = "expiry", required = true) OffsetDateTime expiry,
  @JsonProperty(value = "allow_multiselect", required = true) boolean allowMultiselect,
  @JsonProperty(value = "results") @Nullable Results results
) {
  public record Media(
    @JsonProperty(value = "text", required = true) String text,
    @JsonProperty(value = "emoji") @Nullable Emoji emoji
  ) {
    public Media {
      Check.lengthMax(text, "text", 300);
    }
  }

  public record Answer(
    @JsonProperty(value = "poll_media", required = true) Media pollMedia
  ) {}

  public record Results(
    @JsonProperty(value = "answer_counts", required = true) List<AnswerCount> answerCounts
  ) {}

  public record AnswerCount(
    @JsonProperty(value = "id", required = true) int id,
    @JsonProperty(value = "count", required = true) int count
  ) {}
}
