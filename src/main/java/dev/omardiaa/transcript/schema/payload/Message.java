package dev.omardiaa.transcript.schema.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.schema.payload.message.Attachment;
import dev.omardiaa.transcript.schema.payload.message.Embed;
import dev.omardiaa.transcript.schema.payload.message.InteractionType;
import dev.omardiaa.transcript.schema.payload.message.component.Component;
import dev.omardiaa.transcript.schema.payload.util.Emoji;
import dev.omardiaa.transcript.util.TimeUtil;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@NullMarked
public class Message {
  private final String id;
  private final User author;
  private final String content;
  private final OffsetDateTime timestamp;
  private final @Nullable OffsetDateTime editedTimestamp;
  private final List<Attachment> attachments;
  private final List<Embed> embeds;
  private final @Nullable List<Reaction> reactions;
  private final @Nullable Integer flags;
  private final @Nullable Message referencedMessage;
  private final @Nullable InteractionMetadata interactionMetadata;
  private final @Nullable List<Component> components;

  @JsonIgnore
  private final Map<String, User> mentionsMap;

  @JsonCreator
  public Message(
    @JsonProperty("id") String id,
    @JsonProperty("author") User author,
    @JsonProperty("content") String content,
    @JsonProperty("timestamp") String timestamp,
    @JsonProperty("edited_timestamp") @Nullable String editedTimestamp,
    @JsonProperty("mentions") List<User> mentions,
    @JsonProperty("attachments") List<Attachment> attachments,
    @JsonProperty("embeds") List<Embed> embeds,
    @JsonProperty("reactions") @Nullable List<Reaction> reactions,
    @JsonProperty("flags") @Nullable Integer flags,
    @JsonProperty("referenced_message") @Nullable Message referencedMessage,
    @JsonProperty("interaction_metadata") @Nullable InteractionMetadata interactionMetadata,
    @JsonProperty("components") @Nullable List<Component> components) {
    this.id = id;
    this.author = author;
    this.content = content;
    this.timestamp = TimeUtil.toOffsetDateTime(timestamp);
    this.editedTimestamp = editedTimestamp == null
      ? null
      : TimeUtil.toOffsetDateTime(editedTimestamp);
    this.mentionsMap = mentions.isEmpty()
      ? Collections.emptyMap()
      : mentions.stream().collect(Collectors.toUnmodifiableMap(User::getId, Function.identity()));
    this.attachments = attachments;
    this.embeds = embeds;
    this.reactions = reactions;
    this.flags = flags;
    this.referencedMessage = referencedMessage;
    this.interactionMetadata = interactionMetadata;
    this.components = components;
  }

  public String getId() {
    return id;
  }

  public User getAuthor() {
    return author;
  }

  public String getContent() {
    return content;
  }

  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public @Nullable OffsetDateTime getEditedTimestamp() {
    return editedTimestamp;
  }

  public List<Attachment> getAttachments() {
    return attachments;
  }

  public List<Embed> getEmbeds() {
    return embeds;
  }

  public @Nullable List<Reaction> getReactions() {
    return reactions;
  }

  public @Nullable Integer getFlags() {
    return flags;
  }

  public @Nullable Message getReferencedMessage() {
    return referencedMessage;
  }

  public @Nullable InteractionMetadata getInteractionMetadata() {
    return interactionMetadata;
  }

  public @Nullable List<Component> getComponents() {
    return components;
  }

  /**
   * Helper Method
   *
   * @return {@code boolean} - true if this message contains ComponentsV2
   */
  @JsonIgnore
  public boolean isComponentsV2() {
    return (getFlags() != null) && (getFlags() == 1 << 15);
  }

  @JsonIgnore
  public Map<String, User> getMentionsMap() {
    return mentionsMap;
  }

  @Override
  public String toString() {
    return "Message{" +
           "id='" + id + '\'' +
           ", author=" + author +
           ", content='" + content + '\'' +
           ", timestamp=" + timestamp +
           ", editedTimestamp=" + editedTimestamp +
           ", attachments=" + attachments +
           ", embeds=" + embeds +
           ", reactions=" + reactions +
           ", flags=" + flags +
           ", referencedMessage=" + referencedMessage +
           ", interactionMetadata=" + interactionMetadata +
           ", components=" + components +
           ", mentionsMap=" + mentionsMap +
           '}';
  }

  @NullMarked
  public static class Reaction {
    private final int count;
    private final Emoji emoji;

    public Reaction(
      @JsonProperty("count") int count,
      @JsonProperty("emoji") Emoji emoji) {
      this.count = count;
      this.emoji = emoji;
    }

    public int getCount() {
      return count;
    }

    public Emoji getEmoji() {
      return emoji;
    }

    @Override
    public String toString() {
      return "Reaction{" +
             "count=" + count +
             ", emoji=" + emoji +
             '}';
    }
  }

  @NullMarked
  public static class InteractionMetadata {
    private final int type;
    private final User user;

    @JsonCreator
    public InteractionMetadata(
      @JsonProperty("type") int type,
      @JsonProperty("user") User user) {
      this.type = type;
      this.user = user;
    }

    public int getType() {
      return type;
    }

    public User getUser() {
      return user;
    }

    /**
     * Helper Method
     *
     * @return {@link InteractionType} - Interaction Metadata Type
     */
    @JsonIgnore
    public InteractionType getInteractionType() {
      return InteractionType.fromValue(type);
    }

    @Override
    public String toString() {
      return "InteractionMetadata{" +
             "type=" + type +
             ", user=" + user +
             '}';
    }
  }
}
