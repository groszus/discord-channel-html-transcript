@import dev.omardiaa.transcript.util.MarkdownUtil
@import dev.omardiaa.transcript.schema.payload.Guild
@import dev.omardiaa.transcript.schema.payload.Message
@import dev.omardiaa.transcript.schema.payload.message.Embed

@param Guild guild
@param Message message

<div
  id="${message.getId()}"
  class="message markup"
>
  $unsafe{MarkdownUtil.parseMarkup(guild, message, message.getContent())}

  @template.discord.message.attachments(attachments = message.getAttachments())

  @for(Embed embed : message.getEmbeds())
    @template.discord.message.embed(guild = guild, message = message, embed = embed)
  @endfor

  @template.discord.message.components(guild = guild, message = message)

  @template.discord.message.reactions(message = message)

  @if(message.getEditedTimestamp() != null)
    <div class="message__edited user-select-none">
      <span>(edited)</span>

      @template.discord.ui.timestamp(timestamp = message.getEditedTimestamp())
    </div>
  @endif
</div>
