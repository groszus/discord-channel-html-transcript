@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.StickerItem

@param Message message

@if(message.stickerItems() != null)
  @for(StickerItem stickerItem : message.stickerItems())
    @if(stickerItem.iconUrl() != null)
      <img
        src="${stickerItem.iconUrl()}"
        alt="Sticker"
        class="sticker"
      >
    @endif
  @endfor
@endif
