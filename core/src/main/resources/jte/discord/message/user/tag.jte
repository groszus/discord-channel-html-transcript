@import dev.omardiaa.transcript.core.model.payload.message.User

@param User user

@if(user.getTag() != null)
  <span class="author__tag user-select-none">${user.getTag()}</span>
@endif
