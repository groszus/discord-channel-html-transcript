@import dev.omardiaa.transcript.util.TranscriberUtil
@import dev.omardiaa.transcript.schema.payload.Guild
@import dev.omardiaa.transcript.schema.payload.Message
@import dev.omardiaa.transcript.schema.payload.message.component.TextDisplay

@param Guild guild
@param TextDisplay textDisplay
@param Message message

<div class="text-display">
  <div class="message markup">
    $unsafe{TranscriberUtil.parseMarkup(guild, message, textDisplay.getContent())}
  </div>
</div>
