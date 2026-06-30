package gg.jte.generated.precompiled.discord.message.accessory;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.message.StickerItem;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtestickersGenerated {
	public static final String JTE_NAME = "discord/message/accessory/stickers.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,5,5,5,6,7,9,9,9,9,9,9,9,9,9,13,13,14,15,16,16,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtestickersGenerated.class, "JtestickersGenerated.bin", 2,7,6,1,41);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Message message) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (message.stickerItems() != null) {
			for (StickerItem stickerItem : message.stickerItems()) {
				if (stickerItem.iconUrl() != null) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
					var __jte_html_attribute_0 = stickerItem.iconUrl();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
						jteOutput.setContext("img", "src");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("img", null);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
				}
			}
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Message message = (Message)params.get("message");
		render(jteOutput, jteHtmlInterceptor, message);
	}
}
