@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.PayloadOptions
@import dev.omardiaa.transcript.core.model.payload.message.component.ActionRow
@import dev.omardiaa.transcript.core.model.payload.message.component.Component

@param Guild guild
@param Message message
@param PayloadOptions options

@if(message.components() != null && !message.components().isEmpty())
  @if (message.isComponentsV2())
    <div class="components">
      @for(Component component : message.components())
        @template.discord.components.component(guild = guild, message = message, component = component, options = options)
      @endfor
    </div>
  @else
    @for(ActionRow actionRow : message.components().stream().filter(c -> c instanceof ActionRow).map(c -> (ActionRow) c).toList())
      @template.discord.components.action-row(actionRow = actionRow)
    @endfor
  @endif
@endif
