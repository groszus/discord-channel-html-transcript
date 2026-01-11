@import dev.omardiaa.transcript.schema.payload.Guild
@import dev.omardiaa.transcript.schema.payload.Message
@import dev.omardiaa.transcript.schema.payload.message.component.Section
@import dev.omardiaa.transcript.schema.payload.message.component.SectionChildComponent
@import dev.omardiaa.transcript.schema.payload.message.component.TextDisplay
@import dev.omardiaa.transcript.schema.payload.message.component.Button
@import dev.omardiaa.transcript.schema.payload.message.component.Thumbnail
@import dev.omardiaa.transcript.util.TranscriberUtil

@param Guild guild
@param Section section
@param Message message

<div class="section">
  <div class="section__content">
    @for(SectionChildComponent component : section.getComponents())
      @if(component instanceof TextDisplay textDisplay)
        <div class="message markup">
          $unsafe{TranscriberUtil.parseMarkup(guild, message, textDisplay.getContent())}
        </div>
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
