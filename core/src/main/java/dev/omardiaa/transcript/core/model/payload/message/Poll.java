package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * <a href="https://docs.discord.com/developers/resources/poll#poll-object">Poll</a>
 */
@NullMarked
public record Poll(
  Media question,
  List<Answer> answers,
  OffsetDateTime expiry,
  boolean allowMultiselect,
  @Nullable Results results
) {
  @JsonCreator
  public Poll(
    @JsonProperty(value = "question", required = true) Media question,
    @JsonProperty(value = "answers", required = true) List<Answer> answers,
    @JsonProperty(value = "expiry", required = true) OffsetDateTime expiry,
    @JsonProperty(value = "allow_multiselect", required = true) boolean allowMultiselect,
    @JsonProperty(value = "results") @Nullable Results results
  ) {
    this.question = question;
    this.answers = answers;
    this.expiry = expiry;
    this.allowMultiselect = allowMultiselect;
    this.results = results;
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/poll#poll-media-object">Poll Media</a>
   */
  public record Media(
    String text,
    @Nullable Emoji emoji
  ) {
    @JsonCreator
    public Media(
      @JsonProperty(value = "text", required = true) String text,
      @JsonProperty(value = "emoji") @Nullable Emoji emoji
    ) {
      this.text = text;
      this.emoji = emoji;
    }
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/poll#poll-answer-object">Poll Answer</a>
   */
  public record Answer(
    Media pollMedia
  ) {
    @JsonCreator
    public Answer(
      @JsonProperty(value = "poll_media", required = true) Media pollMedia
    ) {
      this.pollMedia = pollMedia;
    }
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/poll#poll-results-object">Poll Results</a>
   */
  public record Results(
    List<AnswerCount> answerCounts
  ) {
    @JsonCreator
    public Results(
      @JsonProperty(value = "answer_counts", required = true) List<AnswerCount> answerCounts
    ) {
      this.answerCounts = answerCounts;
    }
  }

  /**
   * <a href="https://docs.discord.com/developers/resources/poll#poll-results-object-poll-answer-count-object-structure">Poll Answer Count</a>
   */
  public record AnswerCount(
    int id,
    int count
  ) {
    @JsonCreator
    public AnswerCount(
      @JsonProperty(value = "id", required = true) int id, @JsonProperty(value = "count", required = true) int count
    ) {
      this.id = id;
      this.count = count;
    }
  }
}
