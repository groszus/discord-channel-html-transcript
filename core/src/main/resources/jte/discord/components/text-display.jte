@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.component.TextDisplay

@param Guild guild
@param Message message
@param TextDisplay textDisplay

<div class="text-display">
  @template.discord.message.content(guild = guild, message = message, content = textDisplay.content())
</div>
