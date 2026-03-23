@import dev.omardiaa.transcript.core.model.payload.message.component.MediaGallery

@param MediaGallery mediaGallery

<div class="images" data-count="${mediaGallery.items().size()}">
  @for(MediaGallery.Item item : mediaGallery.items())
    @template.util.image(src = item.media().url())
  @endfor
</div>
