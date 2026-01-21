@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.Embed

@param Guild guild
@param Message message

<div id="${message.getId()}">
  @template.discord.message.content(guild = guild, message = message, content = message.getContent())

  <div class="message__accessories">
    @template.discord.message.attachments(attachments = message.getAttachments())

    @for(Embed embed : message.getEmbeds())
      @template.discord.message.embed(guild = guild, message = message, embed = embed)
    @endfor

    @template.discord.message.components(guild = guild, message = message)
  </div>

  @template.discord.message.reactions(message = message)

  @if(message.getEditedTimestamp() != null)
    <div class="message__edited user-select-none">
      <span>(edited)</span>

      @template.discord.ui.timestamp(timestamp = message.getEditedTimestamp())
    </div>
  @endif
</div>
