@import java.util.List
@import dev.omardiaa.transcript.core.model.payload.message.Reaction

@param List<Reaction> reactions

@if(reactions != null && !reactions.isEmpty())
  <div class="reactions user-select-none">
    @for(Reaction reaction : reactions)
      <div class="reaction">
        @template.util.emoji(emoji = reaction.emoji(), classes = "reaction__emoji")
        <span class="reaction__count">${reaction.count()}</span>
      </div>
    @endfor
  </div>
@endif
