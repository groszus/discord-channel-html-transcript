@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.component.*

@param Guild guild
@param Section section
@param Message message

<div class="section">
  <div class="section__content">
    @for(SectionChildComponent component : section.getComponents())
      @if(component instanceof TextDisplay textDisplay)
        @template.discord.message.content(guild = guild, message = message, content = textDisplay.getContent())
      @endif
    @endfor
  </div>

  <div class="section__accessory">
    @if(section.getAccessory() instanceof Button button)
      @template.discord.components.button(button = button)
    @elseif(section.getAccessory() instanceof Thumbnail thumbnail)
      @template.util.image(src = thumbnail.getMedia().getUrl(), alt = "Thumbnail")
    @endif
  </div>
</div>
