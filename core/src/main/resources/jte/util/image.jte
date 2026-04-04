@import dev.omardiaa.transcript.core.model.payload.PayloadOptions.AttachmentOptions
@import dev.omardiaa.transcript.core.util.ImageUtil

@param String src
@param AttachmentOptions options

<div class="image__wrapper">
  <img
    src="${options.save() ? ImageUtil.downloadAndEncode(src) : src}"
    alt="Image"
    class="image"
  />
</div>
