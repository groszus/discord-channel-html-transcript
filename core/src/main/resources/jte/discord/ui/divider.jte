@import java.time.OffsetDateTime
@import dev.omardiaa.transcript.core.util.TimeUtil

@param OffsetDateTime timestamp

<div class="divider user-select-none">
  <time class="divider__content">${TimeUtil.formatDateLong(timestamp)}</time>
</div>
