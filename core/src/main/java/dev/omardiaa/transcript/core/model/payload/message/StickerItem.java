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
  @Nullable String iconUrl
) {
  public static final String STICKER_URL = "https://cdn.discordapp.com/stickers/%s.%s";

  @JsonCreator
  public StickerItem(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "format_type", required = true) int formatType
  ) {
    this(
      id,
      resolveIconUrl(id, formatType)
    );
  }

  /**
   * Resolves the URL of the sticker.
   * <br>
   * Stickers of type {@code LOTTIE (3)} are unsupported.
   *
   * @param id
   *   the ID of the sticker.
   * @param formatType
   *   the format type of the sticker.
   *
   * @return the formatted sticker URL, or {@code null} if {@code formatType} is unsupported.
   *
   * @see <a href="https://docs.discord.com/developers/reference#image-formatting">Image Formatting</a>
   */
  @JsonIgnore
  public static @Nullable String resolveIconUrl(String id, int formatType) {
    return switch (formatType) {
      case 1, 2 -> STICKER_URL.formatted(id, "png");
      case 4 -> STICKER_URL.formatted(id, "gif");
      default -> null;
    };
  }
}
