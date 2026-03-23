package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * <a href="https://docs.discord.com/developers/components/reference#anatomy-of-a-component">Component</a>
 */
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type",
  visible = true,
  defaultImpl = Void.class
)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ActionRow.class, name = "1"),
  @JsonSubTypes.Type(value = Button.class, name = "2"),
  @JsonSubTypes.Type(value = SelectMenu.class, names = {"3", "5", "6", "7", "8"}),
  @JsonSubTypes.Type(value = Section.class, name = "9"),
  @JsonSubTypes.Type(value = TextDisplay.class, name = "10"),
  @JsonSubTypes.Type(value = Thumbnail.class, name = "11"),
  @JsonSubTypes.Type(value = MediaGallery.class, name = "12"),
  @JsonSubTypes.Type(value = File.class, name = "13"),
  @JsonSubTypes.Type(value = Separator.class, name = "14"),
  @JsonSubTypes.Type(value = Container.class, name = "17")
})
public interface Component {
  int type();
}
