@import dev.omardiaa.transcript.core.model.payload.PayloadOptions
@import dev.omardiaa.transcript.core.model.payload.message.component.MediaGallery

@param MediaGallery mediaGallery
@param PayloadOptions options

<div class="images" data-count="${mediaGallery.items().size()}">
  @for(MediaGallery.Item item : mediaGallery.items())
    @template.util.image(src = item.media().url(), options = options.attachment())
  @endfor
</div>
