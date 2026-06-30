package gg.jte.generated.precompiled;
import dev.omardiaa.transcript.core.model.Payload;
import dev.omardiaa.transcript.core.model.payload.Message;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,10,10,10,10,10,10,10,16,16,19,19,19,19,19,19,19,19,19,21,21,22,22,23,23,26,26,29,29,31,32,32,33,33,34,39,39,39,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteindexGenerated.class, "JteindexGenerated.bin", 156,3,13210,34,7,1,8,2,2,17,27,2,2,27);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Payload payload) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(payload.channel().name());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(payload.guild().name());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		if (payload.options().style().path() != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
			var __jte_html_attribute_0 = payload.options().style().path();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
				jteOutput.setContext("link", "href");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("link", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
		} else {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			gg.jte.generated.precompiled.JtestyleGenerated.render(jteOutput, jteHtmlInterceptor);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
		gg.jte.generated.precompiled.discord.ui.JteheaderGenerated.render(jteOutput, jteHtmlInterceptor, payload.guild(), payload.channel());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
		Message previousMessage = null;
		for (Message message : payload.messages()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			gg.jte.generated.precompiled.discord.JtemessageGenerated.render(jteOutput, jteHtmlInterceptor, payload, message, previousMessage);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
			previousMessage = message;
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Payload payload = (Payload)params.get("payload");
		render(jteOutput, jteHtmlInterceptor, payload);
	}
}
