@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.util.TimeUtil

@param Message message

<div class="divider user-select-none">
  <time class="divider__content">
    ${TimeUtil.formatDateLong(message.getTimestamp())}
  </time>
</div>
