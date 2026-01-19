package dev.omardiaa.transcript.api.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.api.model.payload.common.Emoji;
import dev.omardiaa.transcript.api.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Discord <a href="https://discord.com/developers/docs/components/reference#button">Button</a>.
 */
@NullMarked
public class Button implements ActionRowChildComponent, SectionAccessoryComponent {
  private final int type;
  private final ButtonStyle style;
  private final @Nullable String label;
  private final @Nullable Emoji emoji;
  private final @Nullable String url;
  private final boolean disabled;

  @JsonCreator
  public Button(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "style", required = true) int style,
    @JsonProperty(value = "label") @Nullable String label,
    @JsonProperty(value = "emoji") @Nullable Emoji emoji,
    @JsonProperty(value = "url") @Nullable String url,
    @JsonProperty(value = "disabled") @Nullable Boolean disabled) {
    if (style == ButtonStyle.LINK.getValue()) {
      if (url == null) {
        throw new IllegalArgumentException("Link Button cannot have null url.");
      }
    }

    if (label == null && emoji == null) {
      throw new IllegalArgumentException("Either emoji or label can be null, both must not be null.");
    }

    this.type = type;
    this.style = ButtonStyle.fromValue(style);
    this.label = label;
    this.emoji = emoji;
    this.url = url;
    this.disabled = Check.defaultIfNull(disabled, false);
  }

  @Override
  public int getType() {
    return type;
  }

  public ButtonStyle getStyle() {
    return style;
  }

  public @Nullable String getLabel() {
    return label;
  }

  public @Nullable Emoji getEmoji() {
    return emoji;
  }

  public @Nullable String getUrl() {
    return url;
  }

  public boolean isDisabled() {
    return disabled;
  }

  @Override
  public String toString() {
    return "Button{" +
           "type=" + type +
           ", style=" + style +
           ", label='" + label + '\'' +
           ", emoji=" + emoji +
           ", url='" + url + '\'' +
           ", disabled=" + disabled +
           '}';
  }
}
