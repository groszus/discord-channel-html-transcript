@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.PayloadOptions
@import dev.omardiaa.transcript.core.model.payload.message.Attachment
@import dev.omardiaa.transcript.core.model.payload.message.component.File
@import java.util.List

@param Message message
@param PayloadOptions options

!{List<Attachment> images = message.getImages();}

@if(!images.isEmpty())
  <div class="images" data-count="${images.size()}">
    @for(Attachment image : images)
      @template.util.image(src = image.url())
    @endfor
  </div>
@endif

!{List<File> files = message.getFiles();}

@if(!files.isEmpty())
  @for(File file : files)
    @template.discord.components.file(file = file)
  @endfor
@endif
