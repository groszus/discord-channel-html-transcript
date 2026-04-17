@import dev.omardiaa.transcript.core.model.payload.message.User

@param User user

@if(user.tag() != null)
  <span class="author__tag">${user.tag()}</span>
@endif
