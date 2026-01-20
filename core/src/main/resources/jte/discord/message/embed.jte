@import dev.omardiaa.transcript.core.model.payload.Guild
@import dev.omardiaa.transcript.core.model.payload.Message
@import dev.omardiaa.transcript.core.model.payload.message.Embed
@import dev.omardiaa.transcript.core.util.TimeUtil
@import dev.omardiaa.transcript.core.util.MarkdownUtil

@param Guild guild
@param Embed embed
@param Message message

<article
  style="border-left: 0.25rem solid ${"#%1$06X".formatted(embed.getColor())};"
  class="embed"
>
  !{Embed.Author author = embed.getAuthor();}

  @if(author != null)
    <div class="embed__author embed__margin">
      @if(author.getIconUrl() != null)
        <img
          src="${author.getIconUrl()}"
          alt="Embed Author"
          class="embed__author__icon"
        />
      @endif

      @if(author.getUrl() != null)
        <a
          href="${author.getUrl()}"
          class="embed__author__name markup"
        >
          ${author.getName()}
        </a>
      @else
        <span class="embed__author__name">${author.getName()}</span>
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
