@import dev.omardiaa.transcript.core.model.payload.common.Emoji

@param Emoji emoji
@param String classes

@if(emoji instanceof Emoji.Custom customEmoji)
  <img
    src="${customEmoji.getImageUrl()}"
    alt="${customEmoji.getName()}"
    class="${classes}"
  />
@elseif(emoji instanceof Emoji.Unicode unicodeEmoji)
  <span class="${classes}">$unsafe{unicodeEmoji.getAsUTF8()}</span>
@endif
