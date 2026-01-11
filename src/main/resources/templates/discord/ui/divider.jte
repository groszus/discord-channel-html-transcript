@import dev.omardiaa.transcript.util.TimeUtil
@import dev.omardiaa.transcript.schema.payload.Message

@param Message message

<div class="divider user-select-none">
  <time class="divider__content">
    ${TimeUtil.formatDateLong(message.getTimestamp())}
  </time>
</div>
