@import dev.omardiaa.transcript.core.model.payload.message.component.Separator

@param Separator separator

<hr
  aria-hidden="${!separator.divider()}"
  data-separator-spacing="${separator.spacing().name()}"
  class="separator"
/>
