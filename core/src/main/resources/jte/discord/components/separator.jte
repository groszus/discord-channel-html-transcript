@import dev.omardiaa.transcript.core.model.payload.message.component.Separator

@param Separator separator

<hr
  aria-hidden="${!separator.isDivider()}"
  data-separator-spacing="${separator.getSpacing().name()}"
  class="separator"
/>
