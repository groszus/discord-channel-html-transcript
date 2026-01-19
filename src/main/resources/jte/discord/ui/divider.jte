@import dev.omardiaa.transcript.api.model.payload.Message
@import dev.omardiaa.transcript.api.util.TimeUtil

@param Message message

<div class="divider user-select-none">
  <time class="divider__content">
    ${TimeUtil.formatDateLong(message.getTimestamp())}
  </time>
</div>
