@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.Attachment
@import dev.omardiaa.transcript.core.model.payload.message.component.File

@param Message message

@if(!message.getImages().isEmpty())
  <div class="images" data-count="${message.getImages().size()}">
    @for(Attachment image : message.getImages())
      @template.util.image(src = image.getUrl())
    @endfor
  </div>
@endif

@for(File file : message.getFiles())
  @template.discord.components.file(file = file)
@endfor
