package dev.omardiaa.transcript.core.model.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.message.*;
import dev.omardiaa.transcript.core.model.payload.message.component.Component;
import dev.omardiaa.transcript.core.model.payload.message.component.File;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://docs.discord.com/developers/resources/message#message-object">Message</a>
 */
@NullMarked
public record Message(
  String id,
  User author,
  String content,
  OffsetDateTime timestamp,
  @Nullable OffsetDateTime editedTimestamp,
  List<Attachment> attachments,
  List<Embed> embeds,
  @Nullable List<Reaction> reactions,
  @Nullable Integer flags,
  @Nullable Message referencedMessage,
  @Nullable InteractionMetadata interactionMetadata,
  @Nullable List<Component> components,
  @Nullable Poll poll,

  @JsonIgnore Map<String, User> mentionsMap,
  @JsonIgnore List<Attachment> images,
  @JsonIgnore List<File> files
) {
  @JsonCreator
  public Message(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "author", required = true) User author,
    @JsonProperty(value = "content", required = true) String content,
    @JsonProperty(value = "timestamp", required = true) OffsetDateTime timestamp,
    @JsonProperty(value = "edited_timestamp") @Nullable OffsetDateTime editedTimestamp,
    @JsonProperty(value = "mentions", required = true) List<User> mentions,
    @JsonProperty(value = "attachments", required = true) List<Attachment> attachments,
    @JsonProperty(value = "embeds", required = true) List<Embed> embeds,
    @JsonProperty(value = "reactions") @Nullable List<Reaction> reactions,
    @JsonProperty(value = "flags") @Nullable Integer flags,
    @JsonProperty(value = "referenced_message") @Nullable Message referencedMessage,
    @JsonProperty(value = "interaction_metadata") @Nullable InteractionMetadata interactionMetadata,
    @JsonProperty(value = "components") @Nullable List<Component> components,
    @JsonProperty(value = "poll") @Nullable Poll poll) {
    this(
      id,
      author,
      content,
      timestamp,
      editedTimestamp,
      attachments,
      embeds,
      reactions,
      flags,
      referencedMessage,
      interactionMetadata,
      components,
      poll,
      mentions.isEmpty()
        ? Collections.emptyMap()
        : mentions.stream().collect(Collectors.toUnmodifiableMap(User::id, Function.identity())),
      attachments.stream().filter(Attachment::isImage).toList(),
      attachments.stream().filter(a -> !a.isImage()).map(Attachment::toFile).toList());
  }

  /**
   * @return {@code true} if this message contains ComponentsV2.
   */
  @JsonIgnore
  public boolean isComponentsV2() {
    return (this.flags != null) && ((this.flags & (1 << 15)) != 0);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Message message = (Message) o;
    return Objects.equals(id, message.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
