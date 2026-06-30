@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.Reaction

@param Message message

@if(message.reactions() != null && !message.reactions().isEmpty())
  <div class="reactions user-select-none">
    @for(Reaction reaction : message.reactions())
      <div class="reaction">
        @template.util.emoji(emoji = reaction.emoji(), classes = "reaction__emoji")
        <span class="reaction__count">${reaction.count()}</span>
      </div>
    @endfor
  </div>
@endif
