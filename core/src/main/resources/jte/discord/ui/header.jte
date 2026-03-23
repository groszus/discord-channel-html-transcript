@import dev.omardiaa.transcript.core.model.payload.Channel
@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.util.MarkdownUtil

@param Guild guild
@param Channel channel

<header class="header user-select-none">
  <div class="header__guild">
    <img
      src="${guild.iconUrl()}"
      alt="${guild.name()}"
      class="header__guild__icon"
    />

    <span class="header__guild__name">${guild.name()}</span>
  </div>

  <div class="header__channel">
    <svg
      viewBox="0 0 24 24"
      height="20"
      width="20"
    >
      <path
        fill="#82838b"
        fill-rule="evenodd"
        d="M10.99 3.16A1 1 0 1 0 9 2.84L8.15 8H4a1 1 0 0 0 0 2h3.82l-.67 4H3a1 1 0 1 0 0 2h3.82l-.8 4.84a1 1 0 0 0 1.97.32L8.85 16h4.97l-.8 4.84a1 1 0 0 0 1.97.32l.86-5.16H20a1 1 0 1 0 0-2h-3.82l.67-4H21a1 1 0 1 0 0-2h-3.82l.8-4.84a1 1 0 1 0-1.97-.32L15.15 8h-4.97l.8-4.84ZM14.15 14l.67-4H9.85l-.67 4h4.97Z"
      />
    </svg>

    <h1 class="header__channel__title">${channel.name()}</h1>

    @if(channel.topic() != null)
      <span class="header__channel__divider">&bull;</span>
      <p class="header__channel__topic markup">$unsafe{MarkdownUtil.parseMarkup(channel.topic())}</p>
    @endif
  </div>
</header>
