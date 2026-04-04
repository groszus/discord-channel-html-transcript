@import dev.omardiaa.transcript.core.util.MarkdownUtil
@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message

@param Guild guild
@param Message message
@param String content

<div class="message__content markup">$unsafe{MarkdownUtil.parseMarkup(guild, message, content)}</div>
