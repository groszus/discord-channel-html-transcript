@import dev.omardiaa.transcript.core.model.payload.message.component.MediaGallery
@import dev.omardiaa.transcript.core.model.payload.message.component.MediaGalleryItem

@param MediaGallery mediaGallery

<div class="image__container" data-count="${mediaGallery.getItems().size()}">
  @for(MediaGalleryItem item : mediaGallery.getItems())
    @template.util.image(src = item.getMedia().getUrl(), alt = "Media Gallery Item")
  @endfor
</div>
