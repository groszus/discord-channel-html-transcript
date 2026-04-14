@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.PayloadOptions

@param Guild guild
@param Message message
@param PayloadOptions options

@template.discord.message.content(guild = guild, message = message, content = message.content())

@template.discord.message.message-snapshots(guild = guild, message = message)

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

    @template.discord.message.embeds(guild = guild, message = message)

    @template.discord.message.components(guild = guild, message = message, options = options)

    @template.discord.message.reactions(reactions = message.reactions())
  @endif
</div>
