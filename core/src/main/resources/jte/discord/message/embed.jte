@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.Embed
@import dev.omardiaa.transcript.core.util.TimeUtil
@import dev.omardiaa.transcript.core.util.MarkdownUtil

@param Guild guild
@param Embed embed
@param Message message

@if(embed.type() == Embed.Type.GIFV)
  @if(embed.video() != null)
    <video
      src="${embed.video().url()}"
      data-embed-type="${embed.type().name()}"
      class="embed"
      playsinline <%-- iOS --%>
      autoplay
      muted
      loop
    ></video>
  @endif
@elseif (embed.type() == Embed.Type.RICH)
  <article
    style="${embed.color() == null ? "" : "border-left-color: " + embed.color()}"
    data-embed-type="${embed.type()}"
    class="embed"
  >
    @if(embed.author() != null)
      <div class="embed__author embed__margin">
        @if(embed.author().iconUrl() != null)
          <img
            src="${embed.author().iconUrl()}"
            alt="Embed Author"
            class="embed__author__icon"
          />
        @endif

        @if(embed.author().url() != null)
          <a
            href="${embed.author().url()}"
            class="embed__author__name markup"
          >
            ${embed.author().name()}
          </a>
        @else
          <span class="embed__author__name">${embed.author().name()}</span>
        @endif
      </div>
    @endif

    @if(embed.title() != null)
      <div class="embed__title embed__margin">
        @if(embed.url() != null)
          <a
            href="${embed.url()}"
            class="markup"
          >
            ${embed.title()}
          </a>
        @else
          <span>${embed.title()}</span>
        @endif
      </div>
    @endif

    @if(embed.description() != null)
      <div class="embed__description embed__margin">
        <span>$unsafe{MarkdownUtil.parseMarkup(guild, message, embed.description())}</span>
      </div>
    @endif

    @if((embed.fields() != null) && !embed.fields().isEmpty())
      <div class="embed__fields">
        @for(Embed.Field field : embed.fields())
          <div
            data-embed-field-inline="${field.inline()}"
            class="embed__field"
          >
            <div class="embed__field__name">
              <span>${field.name()}</span>
            </div>

            <div class="embed__field__value">
              <span>${field.value()}</span>
            </div>
          </div>
        @endfor
      </div>
    @endif

    @if(embed.image() != null)
      <div class="embed__image__wrapper">
        <img
          src="${embed.image().url()}"
          alt="Embed Image"
          class="embed__image"
        />
      </div>
    @endif

    @if(embed.thumbnail() != null)
      <div class="embed__thumbnail__wrapper">
        <img
          src="${embed.thumbnail().url()}"
          alt="Embed Thumbnail"
          class="embed__thumbnail"
        />
      </div>
    @endif

    @if(embed.footer() != null)
      <div class="embed__footer embed__margin">
        @if(embed.footer().iconUrl() != null)
          <img
            src="${embed.footer().iconUrl()}"
            alt="Embed Footer Icon"
            class="embed__footer__icon"
          />
        @endif

        <span class="embed__footer__text">
        <span>${embed.footer().text()}</span>

        @if(embed.timestamp() != null)
          <span>&bull;</span>
          <span>${TimeUtil.formatDateShort(embed.timestamp())}</span>
        @endif
      </span>
      </div>
    @endif
  </article>
@endif
