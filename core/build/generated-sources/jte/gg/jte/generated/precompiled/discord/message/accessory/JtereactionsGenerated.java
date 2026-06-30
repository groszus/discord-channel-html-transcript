package gg.jte.generated.precompiled.discord.message.accessory;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.message.Reaction;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtereactionsGenerated {
	public static final String JTE_NAME = "discord/message/accessory/reactions.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,5,5,5,7,7,9,9,10,10,10,12,12,14,14,15,15,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtereactionsGenerated.class, "JtereactionsGenerated.bin", 2,42,30,36,19,8);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Message message) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (message.reactions() != null && !message.reactions().isEmpty()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			for (Reaction reaction : message.reactions()) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				gg.jte.generated.precompiled.util.JteemojiGenerated.render(jteOutput, jteHtmlInterceptor, reaction.emoji(), "reaction__emoji");
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(reaction.count());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Message message = (Message)params.get("message");
		render(jteOutput, jteHtmlInterceptor, message);
	}
}
