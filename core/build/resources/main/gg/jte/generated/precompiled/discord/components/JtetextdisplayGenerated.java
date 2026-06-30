package gg.jte.generated.precompiled.discord.components;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.message.component.TextDisplay;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtetextdisplayGenerated {
	public static final String JTE_NAME = "discord/components/text-display.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,9,9,9,11,11,11,4,5,6,6,6,6};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtetextdisplayGenerated.class, "JtetextdisplayGenerated.bin", 32,10);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Message message, TextDisplay textDisplay) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.discord.message.JtecontentGenerated.render(jteOutput, jteHtmlInterceptor, guild, message, textDisplay.content());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Message message = (Message)params.get("message");
		TextDisplay textDisplay = (TextDisplay)params.get("textDisplay");
		render(jteOutput, jteHtmlInterceptor, guild, message, textDisplay);
	}
}
