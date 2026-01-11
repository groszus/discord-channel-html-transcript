@import dev.omardiaa.transcript.schema.payload.message.Attachment
@import java.util.List

@param List<Attachment> attachments

!{List<Attachment> images = attachments.stream().filter(Attachment::isImage).toList();}
!{List<Attachment> files = attachments.stream().filter(a -> !a.isImage()).toList();}

@if(!images.isEmpty())
  <div class="image__container" data-count="${images.size()}">
    @for(Attachment image : images)
      @template.util.image(src = image.getUrl(), alt = image.getFilename())
    @endfor
  </div>
@endif

@for(Attachment file : files)
  @template.discord.components.file(file = file.toFile())
@endfor
