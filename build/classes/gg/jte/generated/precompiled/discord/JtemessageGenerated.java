package gg.jte.generated.precompiled.discord;
import dev.omardiaa.transcript.TranscriberUtils;
import net.dv8tion.jda.api.entities.Message;
@SuppressWarnings("unchecked")
public final class JtemessageGenerated {
	public static final String JTE_NAME = "discord/message.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,6,6,6,6,6,6,6,6,6,6,9,9,11,11,13,13,15,15,17,17,21,21,23,23,25,25,25,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtemessageGenerated.class, "JtemessageGenerated.bin", 9,5,1,33,6,6,6,4,83,12,8);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	private static final byte[] TEXT_PART_BINARY_9 = BINARY_CONTENT.get(9);
	private static final byte[] TEXT_PART_BINARY_10 = BINARY_CONTENT.get(10);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Message message) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		var __jte_html_attribute_0 = message.getId();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("div", "id");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("div", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		jteOutput.writeUnsafeContent(TranscriberUtils.parseMarkup(message.getGuild(), message.getContentRaw()));
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
		gg.jte.generated.precompiled.discord.message.JteattachmentsGenerated.render(jteOutput, jteHtmlInterceptor, message);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		gg.jte.generated.precompiled.discord.message.JtecomponentsGenerated.render(jteOutput, jteHtmlInterceptor, message);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
		gg.jte.generated.precompiled.discord.message.JtereactionsGenerated.render(jteOutput, jteHtmlInterceptor, message.getReactions());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		if (message.getTimeEdited() != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			gg.jte.generated.precompiled.discord.ui.JtetimestampGenerated.render(jteOutput, jteHtmlInterceptor, message.getTimeEdited());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Message message = (Message)params.get("message");
		render(jteOutput, jteHtmlInterceptor, message);
	}
}
