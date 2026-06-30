package gg.jte.generated.precompiled.discord.ui;
import dev.omardiaa.transcript.TranscriberConstants;
import net.dv8tion.jda.api.entities.Message;
@SuppressWarnings("unchecked")
public final class JtedividerGenerated {
	public static final String JTE_NAME = "discord/ui/divider.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,7,7,7,7,10,10,10,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtedividerGenerated.class, "JtedividerGenerated.bin", 81,21);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Message message) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("time", null);
		jteOutput.writeUserContent(message.getTimeCreated().format(TranscriberConstants.DATE_LONG));
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Message message = (Message)params.get("message");
		render(jteOutput, jteHtmlInterceptor, message);
	}
}
