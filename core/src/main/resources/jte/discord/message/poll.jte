@import dev.omardiaa.transcript.core.util.TimeUtil
@import dev.omardiaa.transcript.core.model.payload.message.Poll

@param Poll poll

<%-- TODO: implement poll closed representation --%>
<%-- TODO: render message reactions (reactions are not rendered intentionally) --%>
<div class="poll">
  <div class="poll__header">
    <h4 class="poll__header__question">${poll.question().text()}</h4>
    <span class="poll__header__prompt">${poll.allowMultiselect() ? "Select one or more answers" : "Select one answer"}</span>
  </div>

  <ul class="poll__answers">
    @for(Poll.Answer answer : poll.answers())
      <li class="poll__answer">
        @if(answer.pollMedia().emoji() != null)
          @template.util.emoji(emoji = answer.pollMedia().emoji(), classes = "poll__answer__emoji")
        @endif

        <span class="poll__answer__text">${answer.pollMedia().text()}</span>
        <svg
          viewBox="0 0 24 24"
          width="24"
          height="24"
        >
          <path
            fill="currentColor"
            fill-rule="evenodd"
            d="M12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4C7.58172 4 4 7.58172 4 12C4 16.4183 7.58172 20 12 20ZM12 22C17.5228 22 22 17.5228 22 12C22 6.47715 17.5228 2 12 2C6.47715 2 2 6.47715 2 12C2 17.5228 6.47715 22 12 22Z"
          />
        </svg>
      </li>
    @endfor
  </ul>

  <div class="poll__details">
    <span class="poll_details__votes">
      ${poll.results() != null ? poll.results().answerCounts().stream().mapToInt(Poll.AnswerCount::count).sum() + " votes" : "0 votes"}
    </span>
    <span class="poll_details__expiry">&bull;</span>
    <time class="poll_details__expiry">${TimeUtil.formatDateShort(poll.expiry())}</time>
  </div>
</div>
