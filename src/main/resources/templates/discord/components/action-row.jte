@import dev.omardiaa.transcript.schema.payload.message.component.ActionRow
@import dev.omardiaa.transcript.schema.payload.message.component.ActionRowChildComponent
@import dev.omardiaa.transcript.schema.payload.message.component.Button
@import dev.omardiaa.transcript.schema.payload.message.component.SelectMenu

@param ActionRow actionRow

<div class="action-row">
  @for(ActionRowChildComponent component : actionRow.getComponents())
    @if(component instanceof Button button)
      @template.discord.components.button(button = button)
    @elseif(component instanceof SelectMenu selectMenu)
      @template.discord.components.select-menu(selectMenu = selectMenu)
    @endif
  @endfor
</div>
