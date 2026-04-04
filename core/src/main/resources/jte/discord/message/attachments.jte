@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.PayloadOptions
@import dev.omardiaa.transcript.core.model.payload.message.Attachment
@import dev.omardiaa.transcript.core.model.payload.message.component.File

@param Message message
@param PayloadOptions options

@if(!message.images().isEmpty())
  <div class="images" data-count="${message.images().size()}">
    @for(Attachment image : message.images())
      @template.util.image(src = image.url(), options = options.attachment())
    @endfor
  </div>
@endif

@for(File file : message.files())
  @template.discord.components.file(file = file)
@endfor
