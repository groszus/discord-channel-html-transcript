package dev.omardiaa.transcript.core.model.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
import dev.omardiaa.transcript.core.model.payload.message.Attachment;
import dev.omardiaa.transcript.core.model.payload.message.Embed;
import dev.omardiaa.transcript.core.model.payload.message.InteractionType;
import dev.omardiaa.transcript.core.model.payload.message.User;
import dev.omardiaa.transcript.core.model.payload.message.component.Component;
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

  /**
   * Discord <a href="https://discord.com/developers/docs/resources/message#messages-resource">Message</a>.
   */
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
    @JsonProperty(value = "components") @Nullable List<Component> components) {
    this.id = id;
    this.author = author;
    this.content = content;
    this.timestamp = timestamp;
    this.editedTimestamp = editedTimestamp;
    this.attachments = attachments;
    this.embeds = embeds;
    this.reactions = reactions;
    this.flags = flags;
    this.referencedMessage = referencedMessage;
    this.interactionMetadata = interactionMetadata;
    this.components = components;

    this.mentionsMap = mentions.isEmpty()
      ? Collections.emptyMap()
      : mentions.stream().collect(Collectors.toUnmodifiableMap(User::getId, Function.identity()));
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
   * @return {@code true} if this message contains ComponentsV2.
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

    /**
     * Discord <a href="https://discord.com/developers/docs/resources/message#reaction-object">Reaction</a>.
     */
    public Reaction(
      @JsonProperty(value = "count", required = true) int count,
      @JsonProperty(value = "emoji", required = true) Emoji emoji) {
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
    private final InteractionType type;
    private final User user;

    /**
     * Discord <a href="https://discord.com/developers/docs/resources/message#message-interaction-metadata-object">Message Interaction Metadata</a>.
     */
    @JsonCreator
    public InteractionMetadata(
      @JsonProperty(value = "type", required = true) int type,
      @JsonProperty(value = "user", required = true) User user) {
      this.type = InteractionType.fromValue(type);
      this.user = user;
    }

    public InteractionType getType() {
      return type;
    }

    public User getUser() {
      return user;
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
