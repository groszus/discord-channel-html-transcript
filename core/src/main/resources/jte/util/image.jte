@import dev.omardiaa.transcript.core.util.ImageUtil
@import dev.omardiaa.transcript.core.model.payload.PayloadOptions.AttachmentOptions

@param String src
@param AttachmentOptions options

<div class="image__wrapper">
  <img
    src="${options.save() ? ImageUtil.downloadAndEncode(src) : src}"
    alt="Image"
    class="image"
  />
</div>
