@import dev.omardiaa.transcript.core.model.payload.Message

@param Message message

@if((message.getReactions() != null) && !message.getReactions().isEmpty())
  <div class="reactions user-select-none">
    @for(Message.Reaction reaction : message.getReactions())
      <div class="reaction">
        @template.util.emoji(emoji = reaction.getEmoji(), classes = "reaction__emoji")
        <span class="reaction__count">${reaction.getCount()}</span>
      </div>
    @endfor
  </div>
@endif
