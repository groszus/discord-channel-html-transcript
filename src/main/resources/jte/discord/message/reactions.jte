@import dev.omardiaa.transcript.api.schema.payload.Message
@import dev.omardiaa.transcript.api.schema.payload.util.Emoji

@param Message message

@if((message.getReactions() != null) && !message.getReactions().isEmpty())
  <div class="reactions user-select-none">
    @for(Message.Reaction reaction : message.getReactions())
      <div class="reaction">
        @if(reaction.getEmoji() instanceof Emoji.Custom customEmoji)
          <img
            src="${customEmoji.getImageUrl()}"
            alt="${customEmoji.getName()}"
            class="reaction__emoji"
          />
        @elseif(reaction.getEmoji() instanceof Emoji.Unicode unicodeEmoji)
          <span class="reaction__emoji">$unsafe{unicodeEmoji.getAsUTF8()}</span>
        @endif

        <span class="reaction__count">${reaction.getCount()}</span>
      </div>
    @endfor
  </div>
@endif
