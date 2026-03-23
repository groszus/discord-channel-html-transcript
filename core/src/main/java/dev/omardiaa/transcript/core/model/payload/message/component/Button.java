package dev.omardiaa.transcript.core.model.payload.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
import dev.omardiaa.transcript.core.util.Check;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// TODO: cleanup

/**
 * <a href="https://docs.discord.com/developers/components/reference#button">Button</a>
 */
@NullMarked
public record Button(
  int type,
  ButtonStyle style,
  @Nullable String label,
  @Nullable Emoji emoji,
  @Nullable String url,
  boolean disabled
) implements ActionRowChildComponent, SectionAccessoryComponent {
  @JsonCreator
  public Button(
    @JsonProperty(value = "type", required = true) int type,
    @JsonProperty(value = "style", required = true) ButtonStyle style,
    @JsonProperty(value = "label") @Nullable String label,
    @JsonProperty(value = "emoji") @Nullable Emoji emoji,
    @JsonProperty(value = "url") @Nullable String url,
    @JsonProperty(value = "disabled", defaultValue = "false") @Nullable Boolean disabled
  ) {
    this(
      type,
      style,
      label,
      emoji,
      url,
      disabled != null && disabled);

    Check.check(
      !((style == ButtonStyle.LINK) && (url == null)),
      "Link Button cannot have null url.");

    Check.check(
      !((label == null) && (emoji == null)),
      "Either emoji or label can be null, both must not be null.");
  }
}
