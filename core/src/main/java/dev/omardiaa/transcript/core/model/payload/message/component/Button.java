package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * <a href="https://docs.discord.com/developers/components/reference#button">Button</a>
 */
@NullMarked
public record Button(
  int type,
  Style style,
  @Nullable String label,
  @Nullable Emoji emoji,
  @Nullable String url,
  boolean disabled
) implements ActionRowChildComponent, SectionAccessoryComponent {
  public Button {
    Check.check(
      label != null || emoji != null,
      "Either emoji or label can be null, both must not be null."
    );
  }

  @JsonCreator
  public Button(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "style", required = true) Style style,
    @JsonProperty(value = "label") @Nullable String label,
    @JsonProperty(value = "emoji") @Nullable Emoji emoji,
    @JsonProperty(value = "url") @Nullable String url,
    @JsonProperty(value = "disabled") @Nullable Boolean disabled
  ) {
    this(
      type,
      style,
      label,
      emoji,
      url,
      disabled != null ? disabled : false
    );
  }

  /**
   * <a href="https://docs.discord.com/developers/components/reference#button-button-styles">Button Styles</a>
   */
  public enum Style {
    @JsonEnumDefaultValue UNKNOWN(-1),
    PRIMARY(1),
    SECONDARY(2),
    SUCCESS(3),
    DANGER(4),
    LINK(5);

    @JsonValue
    public final int value;

    Style(int value) {
      this.value = value;
    }
  }
}
