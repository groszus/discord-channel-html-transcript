package gg.jte.generated.precompiled.discord.ui;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.message.InteractionType;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtereferenceGenerated {
	public static final String JTE_NAME = "discord/ui/reference.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,5,5,5,10,10,10,10,10,10,10,10,10,11,11,11,11,11,11,11,11,11,15,15,18,18,18,18,19,19,19,19,19,19,19,19,19,22,22,22,26,26,26,26,32,32,34,39,39,39,39,39,39,39,39,39,40,40,40,40,40,40,40,40,40,45,45,45,45,46,46,46,46,46,46,46,46,46,49,49,49,66,66,67,67,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtereferenceGenerated.class, "JtereferenceGenerated.bin", 2,93,6,1,5,6,1,50,46,6,8,1,48,29,91,93,6,1,5,6,1,90,6,8,1,48,1203);
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
	private static final byte[] TEXT_PART_BINARY_11 = BINARY_CONTENT.get(11);
	private static final byte[] TEXT_PART_BINARY_12 = BINARY_CONTENT.get(12);
	private static final byte[] TEXT_PART_BINARY_13 = BINARY_CONTENT.get(13);
	private static final byte[] TEXT_PART_BINARY_14 = BINARY_CONTENT.get(14);
	private static final byte[] TEXT_PART_BINARY_15 = BINARY_CONTENT.get(15);
	private static final byte[] TEXT_PART_BINARY_16 = BINARY_CONTENT.get(16);
	private static final byte[] TEXT_PART_BINARY_17 = BINARY_CONTENT.get(17);
	private static final byte[] TEXT_PART_BINARY_18 = BINARY_CONTENT.get(18);
	private static final byte[] TEXT_PART_BINARY_19 = BINARY_CONTENT.get(19);
	private static final byte[] TEXT_PART_BINARY_20 = BINARY_CONTENT.get(20);
	private static final byte[] TEXT_PART_BINARY_21 = BINARY_CONTENT.get(21);
	private static final byte[] TEXT_PART_BINARY_22 = BINARY_CONTENT.get(22);
	private static final byte[] TEXT_PART_BINARY_23 = BINARY_CONTENT.get(23);
	private static final byte[] TEXT_PART_BINARY_24 = BINARY_CONTENT.get(24);
	private static final byte[] TEXT_PART_BINARY_25 = BINARY_CONTENT.get(25);
	private static final byte[] TEXT_PART_BINARY_26 = BINARY_CONTENT.get(26);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Message message) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (message.referencedMessage() != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			var __jte_html_attribute_0 = message.referencedMessage().author().avatarUrl();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				jteOutput.setContext("img", "src");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			var __jte_html_attribute_1 = message.referencedMessage().author().username();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				jteOutput.setContext("img", "alt");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			gg.jte.generated.precompiled.discord.message.user.JtetagGenerated.render(jteOutput, jteHtmlInterceptor, message.author());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(message.referencedMessage().author().id());
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
			var __jte_html_attribute_2 = message.referencedMessage().author().username();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
				jteOutput.setContext("a", "title");
				jteOutput.writeUserContent(__jte_html_attribute_2);
				jteOutput.setContext("a", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(message.referencedMessage().author().globalName());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(message.referencedMessage().id());
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
		}
		if ((message.interactionMetadata() != null) && (message.interactionMetadata().type() == InteractionType.APPLICATION_COMMAND)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
			var __jte_html_attribute_3 = message.interactionMetadata().user().avatarUrl();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
				jteOutput.setContext("img", "src");
				jteOutput.writeUserContent(__jte_html_attribute_3);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
			var __jte_html_attribute_4 = message.interactionMetadata().user().username();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
				jteOutput.setContext("img", "alt");
				jteOutput.writeUserContent(__jte_html_attribute_4);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(message.interactionMetadata().user().id());
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
			var __jte_html_attribute_5 = message.interactionMetadata().user().username();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
				jteOutput.setContext("a", "title");
				jteOutput.writeUserContent(__jte_html_attribute_5);
				jteOutput.setContext("a", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(message.interactionMetadata().user().globalName());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Message message = (Message)params.get("message");
		render(jteOutput, jteHtmlInterceptor, message);
	}
}
