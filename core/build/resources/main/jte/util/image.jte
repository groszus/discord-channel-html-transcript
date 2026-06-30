@import dev.omardiaa.transcript.core.util.Helper

@param String src

<div class="image__wrapper">
  <img
    src="${Helper.downloadAndEncode(src)}"
    alt="Image"
    class="image"
  />
</div>
