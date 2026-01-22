@import dev.omardiaa.transcript.core.model.payload.message.component.MediaGallery

@param MediaGallery mediaGallery

<div class="images" data-count="${mediaGallery.getItems().size()}">
  @for(MediaGallery.Item item : mediaGallery.getItems())
    @template.util.image(src = item.getMedia().getUrl())
  @endfor
</div>
