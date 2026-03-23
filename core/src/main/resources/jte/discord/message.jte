@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.Embed

@param Guild guild
@param Message message

<div id="${message.getId()}">
  @template.discord.message.content(guild = guild, message = message, content = message.getContent())

  @if(message.getEditedTimestamp() != null)
    <div class="message__edited user-select-none">
      <span>(edited)</span>

      @template.discord.ui.timestamp(timestamp = message.getEditedTimestamp())
    </div>
  @endif

  <div class="message__accessories">
    @if(message.getPoll() != null)
      @template.discord.message.poll(poll = message.getPoll())
    @else
      @template.discord.message.attachments(message = message)

      @for(Embed embed : message.getEmbeds())
        @template.discord.message.embed(guild = guild, message = message, embed = embed)
      @endfor

      @template.discord.message.components(guild = guild, message = message)

      @template.discord.message.reactions(message = message)
    @endif
  </div>
</div>
