@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.util.MarkdownUtil

@param Guild guild
@param Message message
@param String content

<div class="message__content markup user-select-text">
  $unsafe{MarkdownUtil.parseMarkup(guild, message, content)}
</div>
