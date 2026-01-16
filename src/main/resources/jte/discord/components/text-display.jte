@import dev.omardiaa.transcript.api.schema.payload.*
@import dev.omardiaa.transcript.api.schema.payload.message.component.TextDisplay
@import dev.omardiaa.transcript.api.util.MarkdownUtil

@param Guild guild
@param TextDisplay textDisplay
@param Message message

<div class="text-display">
  <div class="message markup">
    $unsafe{MarkdownUtil.parseMarkup(guild, message, textDisplay.getContent())}
  </div>
</div>
