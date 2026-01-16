package dev.omardiaa.transcript.schema.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.schema.payload.util.Emoji;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

@NullMarked
public class Button implements ActionRowChildComponent, SectionAccessoryComponent {
  private final int type;
  private final int style;
  private final @Nullable String label;
  private final @Nullable Emoji emoji;
  private final @Nullable String url;
  private final boolean disabled;

  public Button(int type, int style, @Nullable String label, @Nullable Emoji emoji, @Nullable String url) {
    this(type, style, label, emoji, url, false);
  }

  @JsonCreator
  public Button(
    @JsonProperty("type") int type,
    @JsonProperty("style") int style,
    @JsonProperty("label") @Nullable String label,
    @JsonProperty("emoji") @Nullable Emoji emoji,
    @JsonProperty("url") @Nullable String url,
    @JsonProperty("disabled") boolean disabled) {
    if (style == ButtonStyle.LINK.getValue()) {
      if (url == null) {
        throw new IllegalArgumentException("Link Button cannot have null url.");
      }
    }

    if (Objects.isNull(label) && Objects.isNull(emoji)) {
      throw new IllegalArgumentException("label and emoji are null, either one must be present.");
    }

    this.type = type;
    this.style = style;
    this.label = label;
    this.emoji = emoji;
    this.url = url;
    this.disabled = disabled;
  }

  @Override
  public int getType() {
    return type;
  }

  public int getStyle() {
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

  /**
   * Helper Method
   *
   * @return {@link ButtonStyle} - Button Style
   */
  @JsonIgnore
  public ButtonStyle getButtonStyle() {
    return ButtonStyle.fromValue(getStyle());
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
