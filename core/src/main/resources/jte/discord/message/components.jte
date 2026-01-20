@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.component.*

@param Guild guild
@param Message message

@if(message.getComponents() != null)
  @if (message.isComponentsV2())
    <div class="components">
      @for(Component component : message.getComponents())
        @if(component instanceof ActionRow actionRow)
          @template.discord.components.action-row(actionRow = actionRow)
        @elseif(component instanceof Section section)
          @template.discord.components.section(guild = guild, message = message, section = section)
        @elseif(component instanceof TextDisplay textDisplay)
          @template.discord.components.text-display(guild = guild, message = message, textDisplay = textDisplay)
        @elseif(component instanceof MediaGallery mediaGallery)
          @template.discord.components.media-gallery(mediaGallery = mediaGallery)
        @elseif(component instanceof File file)
          @template.discord.components.file(file = file)
        @elseif(component instanceof Separator separator)
          @template.discord.components.separator(separator = separator)
        @elseif(component instanceof Container container)
          @template.discord.components.container(guild = guild, message = message, container = container)
        @endif
      @endfor
    </div>
  @else
    @for(ActionRow actionRow : message.getComponents().stream().filter(c -> c instanceof ActionRow).map(c -> (ActionRow) c).toList())
      @template.discord.components.action-row(actionRow = actionRow)
    @endfor
  @endif
@endif
