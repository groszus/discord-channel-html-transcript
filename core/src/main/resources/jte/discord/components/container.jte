@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.PayloadOptions
@import dev.omardiaa.transcript.core.model.payload.message.component.*

@param Guild guild
@param Message message
@param Container container
@param PayloadOptions options

<div class="container">
  @for(ContainerChildComponent component : container.components())
    @if(component instanceof ActionRow actionRow)
      @template.discord.components.action-row(actionRow = actionRow)
    @elseif(component instanceof TextDisplay textDisplay)
      @template.discord.components.text-display(guild = guild, message = message, textDisplay = textDisplay)
    @elseif(component instanceof Section section)
      @template.discord.components.section(guild = guild, message = message, section = section, options = options)
    @elseif(component instanceof MediaGallery mediaGallery)
      @template.discord.components.media-gallery(mediaGallery = mediaGallery, options = options)
    @elseif(component instanceof Separator separator)
      @template.discord.components.separator(separator = separator)
    @elseif(component instanceof File file)
      @template.discord.components.file(file = file)
    @endif
  @endfor
</div>
