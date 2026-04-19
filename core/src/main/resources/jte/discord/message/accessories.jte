@import dev.omardiaa.transcript.core.model.Payload
@import dev.omardiaa.transcript.core.model.payload.Message

@param Payload payload
@param Message message

@if(message.hasAccessories())
  <div class="message__accessories">
    @if(message.poll() != null)
      @template.discord.message.accessory.poll(poll = message.poll())
    @else
      @template.discord.message.accessory.attachments(message = message, options = payload.options())
      @template.discord.message.accessory.embeds(guild = payload.guild(), message = message)
      @template.discord.message.accessory.components(guild = payload.guild(), message = message, options = payload.options())
      @template.discord.message.accessory.stickers(message = message)
      @template.discord.message.accessory.reactions(message = message)
    @endif
  </div>
@endif
