@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.PayloadOptions
@import dev.omardiaa.transcript.core.model.payload.message.component.Section
@import dev.omardiaa.transcript.core.model.payload.message.component.SectionChildComponent
@import dev.omardiaa.transcript.core.model.payload.message.component.Button
@import dev.omardiaa.transcript.core.model.payload.message.component.Thumbnail
@import dev.omardiaa.transcript.core.model.payload.message.component.TextDisplay

@param Guild guild
@param Message message
@param Section section
@param PayloadOptions options

<div class="section">
  <div class="section__content">
    @for(SectionChildComponent component : section.components())
      @if(component instanceof TextDisplay textDisplay)
        @template.discord.message.content(guild = guild, message = message, content = textDisplay.content())
      @endif
    @endfor
  </div>

  <div class="section__accessory user-select-none">
    @if(section.accessory() instanceof Button button)
      @template.discord.components.button(button = button)
    @elseif(section.accessory() instanceof Thumbnail thumbnail)
      @template.util.image(src = thumbnail.media().url())
    @endif
  </div>
</div>
