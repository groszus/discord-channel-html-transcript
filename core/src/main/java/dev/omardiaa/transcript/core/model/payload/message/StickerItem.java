package dev.omardiaa.transcript.core.model.payload.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * <a href="https://docs.discord.com/developers/resources/sticker#sticker-item-object">Sticker Item</a>
 */
@NullMarked
public record StickerItem(
  String id,
  String name,
  int formatType
) {
  public static final String STICKER_URL = "https://cdn.discordapp.com/stickers/%s.%s";

  @JsonCreator
  public StickerItem(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "name", required = true) String name,
    @JsonProperty(value = "format_type", required = true) int formatType
  ) {
    this.id = id;
    this.name = name;
    this.formatType = formatType;
  }

  /**
   * Resolves the sticker's URL.
   * <br>
   * Stickers of type {@code LOTTIE (3)} are ignored.
   *
   * @return <a href="https://docs.discord.com/developers/reference#image-formatting">Image Formatting</a>
   */
  @JsonIgnore
  public @Nullable String iconUrl() {
    return switch (formatType) {
      case 1, 2 -> STICKER_URL.formatted(id, "png");
      case 4 -> STICKER_URL.formatted(id, "gif");
      default -> null;
    };
  }
}
