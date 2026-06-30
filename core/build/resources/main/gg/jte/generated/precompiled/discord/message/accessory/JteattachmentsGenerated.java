package gg.jte.generated.precompiled.discord.message.accessory;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.PayloadOptions;
import dev.omardiaa.transcript.core.model.payload.message.Attachment;
import dev.omardiaa.transcript.core.model.payload.message.component.File;
import java.util.List;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JteattachmentsGenerated {
	public static final String JTE_NAME = "discord/message/accessory/attachments.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,9,9,9,11,12,12,12,12,12,12,12,12,12,13,13,14,14,15,15,17,17,19,21,22,23,24,24,25,26,26,6,7,7,7,7};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteattachmentsGenerated.class, "JteattachmentsGenerated.bin", 2,19,13,1,3,2,2,8,2);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Message message, PayloadOptions options) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		List<Attachment> images = message.getImages();
		if (!images.isEmpty()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			var __jte_html_attribute_0 = images.size();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				jteOutput.setContext("div", "data-count");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("div", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			for (Attachment image : images) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				gg.jte.generated.precompiled.util.JteimageGenerated.render(jteOutput, jteHtmlInterceptor, image.url());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		}
		List<File> files = message.getFiles();
		if (!files.isEmpty()) {
			for (File file : files) {
				gg.jte.generated.precompiled.discord.components.JtefileGenerated.render(jteOutput, jteHtmlInterceptor, file);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			}
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Message message = (Message)params.get("message");
		PayloadOptions options = (PayloadOptions)params.get("options");
		render(jteOutput, jteHtmlInterceptor, message, options);
	}
}
