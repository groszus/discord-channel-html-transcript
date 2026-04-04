@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.PayloadOptions
@import dev.omardiaa.transcript.core.model.payload.message.Embed

@param Guild guild
@param Message message
@param PayloadOptions options

<div id="${message.id()}">
  @template.discord.message.content(guild = guild, message = message, content = message.content())

  @if(message.editedTimestamp() != null)
    <div class="message__edited user-select-none">
      <span>(edited)</span>

      @template.discord.ui.timestamp(timestamp = message.editedTimestamp())
    </div>
  @endif

  <div class="message__accessories">
    @if(message.poll() != null)
      @template.discord.message.poll(poll = message.poll())
    @else
      @template.discord.message.attachments(message = message, options = options)

      @for(Embed embed : message.embeds())
        @template.discord.message.embed(guild = guild, message = message, embed = embed)
      @endfor

      @template.discord.message.components(guild = guild, message = message, options = options)

      @if(message.reactions() != null)
        @template.discord.message.reactions(reactions = message.reactions())
      @endif
    @endif
  </div>
</div>
