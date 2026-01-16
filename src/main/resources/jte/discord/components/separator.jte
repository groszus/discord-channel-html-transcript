@import dev.omardiaa.transcript.api.schema.payload.message.component.Separator

@param Separator separator

<div
  aria-hidden="${!separator.isDivider()}"
  data-separator-spacing="${separator.getSpacingType().name()}"
  class="separator user-select-none"
></div>
