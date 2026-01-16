@import dev.omardiaa.transcript.api.schema.payload.*
@import dev.omardiaa.transcript.api.schema.payload.message.component.*
@import dev.omardiaa.transcript.api.util.MarkdownUtil

@param Guild guild
@param Section section
@param Message message

<div class="section">
  <div class="section__content">
    @for(SectionChildComponent component : section.getComponents())
      @if(component instanceof TextDisplay textDisplay)
        <div class="message markup">
          $unsafe{MarkdownUtil.parseMarkup(guild, message, textDisplay.getContent())}
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
