package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.message.component.Component;
import dev.omardiaa.transcript.core.model.payload.message.component.File;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://docs.discord.com/developers/resources/message#message-snapshot-object">Message Snapshot</a>
 */
@NullMarked
public record MessageSnapshot(
  MessageSnapshot.Message message
) {
  @JsonCreator
  public MessageSnapshot(
    @JsonProperty(value = "message", required = true) MessageSnapshot.Message message
  ) {
    this.message = message;
  }

  public record Message(
    String content,
    OffsetDateTime timestamp,
    @Nullable OffsetDateTime editedTimestamp,
    List<Attachment> attachments,
    List<Embed> embeds,
    @Nullable Integer flags,
    @Nullable List<Component> components,
    @JsonIgnore @Nullable Map<String, User> mentionsMap,
    @JsonIgnore List<Attachment> images,
    @JsonIgnore List<File> files
  ) {
    @JsonCreator
    public static Message create(
      @JsonProperty(value = "content", required = true) String content,
      @JsonProperty(value = "timestamp", required = true) OffsetDateTime timestamp,
      @JsonProperty(value = "edited_timestamp") @Nullable OffsetDateTime editedTimestamp,
      @JsonProperty(value = "mentions", required = true) List<User> mentions,
      @JsonProperty(value = "attachments", required = true) List<Attachment> attachments,
      @JsonProperty(value = "embeds", required = true) List<Embed> embeds,
      @JsonProperty(value = "flags") @Nullable Integer flags,
      @JsonProperty(value = "components") @Nullable List<Component> components
    ) {
      List<Attachment> images = new ArrayList<>();
      List<File> files = new ArrayList<>();

      for (Attachment attachment : attachments) {
        if (attachment.isImage()) {
          images.add(attachment);
        } else {
          files.add(attachment.toFile());
        }
      }

      return new Message(
        content,
        timestamp,
        editedTimestamp,
        attachments,
        embeds,
        flags,
        components,
        mentions.isEmpty()
          ? null
          : mentions.stream().collect(Collectors.toUnmodifiableMap(User::id, Function.identity())),
        images,
        files
      );
    }
  }
}
