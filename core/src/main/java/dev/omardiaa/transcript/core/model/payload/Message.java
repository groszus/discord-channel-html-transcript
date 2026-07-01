package dev.omardiaa.transcript.core.model.payload;

import com.fasterxml.jackson.annotation.*;
import dev.omardiaa.transcript.core.model.payload.message.*;
import dev.omardiaa.transcript.core.model.payload.message.component.Component;
import dev.omardiaa.transcript.core.model.payload.message.component.File;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
  Type type,
  @Nullable Integer flags,
  @Nullable List<MessageSnapshot> messageSnapshots,
  @Nullable Message referencedMessage,
  @Nullable InteractionMetadata interactionMetadata,
  @Nullable List<Component> components,
  @Nullable List<StickerItem> stickerItems,
  @Nullable Poll poll,
  @JsonIgnore Map<String, User> mentionsMap
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
    @JsonProperty(value = "type", required = true) Type type,
    @JsonProperty(value = "flags") @Nullable Integer flags,
    @JsonProperty(value = "message_snapshots") @Nullable List<MessageSnapshot> messageSnapshots,
    @JsonProperty(value = "referenced_message") @Nullable Message referencedMessage,
    @JsonProperty(value = "interaction_metadata") @Nullable InteractionMetadata interactionMetadata,
    @JsonProperty(value = "components") @Nullable List<Component> components,
    @JsonProperty(value = "sticker_items") @Nullable List<StickerItem> stickerItems,
    @JsonProperty(value = "poll") @Nullable Poll poll
  ) {
    this(
      id,
      author,
      content,
      timestamp,
      editedTimestamp,
      attachments,
      embeds,
      reactions,
      type,
      flags,
      messageSnapshots,
      referencedMessage,
      interactionMetadata,
      components,
      stickerItems,
      poll,
      mentions.isEmpty()
        ? Map.of()
        : mentions.stream().collect(Collectors.toUnmodifiableMap(User::id, Function.identity()))
    );
  }

  @JsonIgnore
  public List<Attachment> getImages() {
    if (attachments.isEmpty()) {
      return List.of();
    }

    List<Attachment> images = new ArrayList<>();

    for (Attachment attachment : attachments) {
      if (attachment.isImage()) {
        images.add(attachment);
      }
    }

    return images;
  }

  @JsonIgnore
  public List<File> getFiles() {
    if (attachments.isEmpty()) {
      return List.of();
    }

    List<File> files = new ArrayList<>();

    for (Attachment attachment : attachments) {
      if (!attachment.isImage()) {
        files.add(attachment.toFile());
      }
    }

    return files;
  }

  /**
   * @return {@code true} if this message contains ComponentsV2.
   */
  @JsonIgnore
  public boolean isComponentsV2() {
    return (flags != null) && ((flags & 1 << 15) != 0);
  }

  /**
   * @param previousMessage
   *   the previous message.
   *
   * @return {@code true} if a divider should be rendered.
   */
  @JsonIgnore
  public boolean showDivider(@Nullable Message previousMessage) {
    return (previousMessage == null) || !previousMessage.timestamp().toLocalDate().isEqual(timestamp.toLocalDate());
  }

  /**
   * @param previousMessage
   *   the previous message.
   *
   * @return {@code true} if the author should be rendered.
   */
  @JsonIgnore
  public boolean showAuthor(@Nullable Message previousMessage) {
    if (
      showDivider(previousMessage)
      || !previousMessage.author().equals(author)
      || referencedMessage != null
      || interactionMetadata != null
    ) {
      return true;
    } else {
      return ChronoUnit.MINUTES.between(previousMessage.timestamp(), timestamp) > 7;
    }
  }

  /**
   * @return {@code true} if this message has any accessories (attachments, embeds, reactions, etc...).
   */
  @JsonIgnore
  public boolean hasAccessories() {
    return poll != null
           || !embeds.isEmpty()
           || !attachments.isEmpty()
           || (components != null && !components.isEmpty())
           || (stickerItems != null && !stickerItems.isEmpty())
           || (reactions != null && !reactions.isEmpty());
  }

  @Override
  public boolean equals(Object o) {
    if (getClass() != o.getClass()) {
      return false;
    }
    Message message = (Message) o;
    return Objects.equals(id, message.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  public enum Type {
    @JsonEnumDefaultValue UNKNOWN(-1),
    DEFAULT(0),
    THREAD_CREATED(18);

    @JsonValue
    public final int value;

    Type(int value) {
      this.value = value;
    }
  }
}
