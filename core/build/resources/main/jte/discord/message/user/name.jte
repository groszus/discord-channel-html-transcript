@import dev.omardiaa.transcript.core.model.payload.message.User

@param User author

<a
  href="https://discord.com/users/${author.id()}"
  target="_blank"
  title="${author.username()}${author.discriminator() == null ? "" : "#" + author.discriminator()}"
  class="author__name"
>
  ${author.globalName()}
</a>
