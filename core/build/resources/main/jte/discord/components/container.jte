@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.PayloadOptions
@import dev.omardiaa.transcript.core.model.payload.message.component.Container
@import dev.omardiaa.transcript.core.model.payload.message.component.ContainerChildComponent

@param Guild guild
@param Message message
@param Container container
@param PayloadOptions options

<div class="container">
  @for(ContainerChildComponent component : container.components())
    @template.discord.components.component(guild = guild, message = message, component = component, options = options)
  @endfor
</div>
