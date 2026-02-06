@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.Embed
@import dev.omardiaa.transcript.core.util.TimeUtil
@import dev.omardiaa.transcript.core.util.MarkdownUtil

@param Guild guild
@param Embed embed
@param Message message

@if(embed.getType() == Embed.Type.GIFV)
  @if(embed.getVideo() != null)
    <video
      src="${embed.getVideo().getUrl()}"
      data-embed-type="${embed.getType().name()}"
      class="embed"
      playsinline <%-- iOS --%>
      autoplay
      muted
      loop
    ></video>
  @endif
@elseif (embed.getType() == Embed.Type.RICH)
  <article
    style="${embed.getColor() == null ? "" : "border-left-color: " + embed.getColor()}"
    data-embed-type="${embed.getType()}"
    class="embed"
  >
    @if(embed.getAuthor() != null)
      <div class="embed__author embed__margin">
        @if(embed.getAuthor().getIconUrl() != null)
          <img
            src="${embed.getAuthor().getIconUrl()}"
            alt="Embed Author"
            class="embed__author__icon"
          />
        @endif

        @if(embed.getAuthor().getUrl() != null)
          <a
            href="${embed.getAuthor().getUrl()}"
            class="embed__author__name markup"
          >
            ${embed.getAuthor().getName()}
          </a>
        @else
          <span class="embed__author__name">${embed.getAuthor().getName()}</span>
        @endif
      </div>
    @endif

    @if(embed.getTitle() != null)
      <div class="embed__title embed__margin">
        @if(embed.getUrl() != null)
          <a
            href="${embed.getUrl()}"
            class="markup"
          >
            ${embed.getTitle()}
          </a>
        @else
          <span>${embed.getTitle()}</span>
        @endif
      </div>
    @endif

    @if(embed.getDescription() != null)
      <div class="embed__description embed__margin">
        <span>$unsafe{MarkdownUtil.parseMarkup(guild, message, embed.getDescription())}</span>
      </div>
    @endif

    @if((embed.getFields() != null) && !embed.getFields().isEmpty())
      <div class="embed__fields">
        @for(Embed.Field field : embed.getFields())
          <div
            data-embed-field-inline="${field.isInline()}"
            class="embed__field"
          >
            <div class="embed__field__name">
              <span>${field.getName()}</span>
            </div>

            <div class="embed__field__value">
              <span>${field.getValue()}</span>
            </div>
          </div>
        @endfor
      </div>
    @endif

    @if(embed.getImage() != null)
      <div class="embed__image__wrapper">
        <img
          src="${embed.getImage().getUrl()}"
          alt="Embed Image"
          class="embed__image"
        />
      </div>
    @endif

    @if(embed.getThumbnail() != null)
      <div class="embed__thumbnail__wrapper">
        <img
          src="${embed.getThumbnail().getUrl()}"
          alt="Embed Thumbnail"
          class="embed__thumbnail"
        />
      </div>
    @endif

    @if(embed.getFooter() != null)
      <div class="embed__footer embed__margin">
        @if(embed.getFooter().getIconUrl() != null)
          <img
            src="${embed.getFooter().getIconUrl()}"
            alt="Embed Footer Icon"
            class="embed__footer__icon"
          />
        @endif

        <span class="embed__footer__text">
        <span>${embed.getFooter().getText()}</span>

        @if(embed.getTimestamp() != null)
          <span>•</span>

          <span>${TimeUtil.formatDateShort(embed.getTimestamp())}</span>
        @endif
      </span>
      </div>
    @endif
  </article>
@endif
