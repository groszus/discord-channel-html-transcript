@import dev.omardiaa.transcript.core.model.payload.common.Emoji

@param Emoji emoji
@param String classes

@if(emoji instanceof Emoji.Custom customEmoji)
  <img
    src="${customEmoji.iconUrl()}"
    alt="${customEmoji.name()}"
    class="${classes}"
  />
@elseif(emoji instanceof Emoji.Unicode unicodeEmoji)
  <span class="${classes}">$unsafe{unicodeEmoji.asUTF8()}</span>
@endif
