@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.component.TextDisplay
@import dev.omardiaa.transcript.core.util.MarkdownUtil

@param Guild guild
@param TextDisplay textDisplay
@param Message message

<div class="text-display">
  @template.discord.message.content(guild = guild, message = message, content = textDisplay.getContent())
</div>
