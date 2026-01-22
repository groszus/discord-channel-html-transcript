@import dev.omardiaa.transcript.core.model.payload.message.Attachment
@import java.util.List

@param List<Attachment> attachments
<%-- TODO: filter in Attachment.java instead --%>
!{List<Attachment> images = attachments.stream().filter(Attachment::isImage).toList();}
!{List<Attachment> files = attachments.stream().filter(a -> !a.isImage()).toList();}

@if(!images.isEmpty())
  <div class="images" data-count="${images.size()}">
    @for(Attachment image : images)
      @template.util.image(src = image.getUrl())
    @endfor
  </div>
@endif

@for(Attachment file : files)
  @template.discord.components.file(file = file.toFile())
@endfor
