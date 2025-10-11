@import dev.skywolfxp.transcript.TranscriptUtils
@import net.dv8tion.jda.api.components.Component
@import net.dv8tion.jda.api.components.textdisplay.TextDisplay
@import net.dv8tion.jda.api.entities.Message

@param Message message

@if(!message.getComponents().isEmpty())
    <div class="action-rows user-select-none">
        @for(var actionRow : message.getComponents())
            @if(actionRow.getType().equals(Component.Type.CONTAINER))
                <div class="container">
                    @for(var component : actionRow.asContainer().getComponents())
                        @if(component instanceof TextDisplay text)
                            <div class="message__content markup">
                                $unsafe{TranscriptUtils.parseMarkup(message.getGuild(), text.getContent())}
                            </div>
                        @endif
                    @endfor
                </div>
            @endif
        @endfor
    </div>
@endif
