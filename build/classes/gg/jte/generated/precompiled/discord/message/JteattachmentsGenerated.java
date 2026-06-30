package gg.jte.generated.precompiled.discord.message;
import java.util.List;
import dev.omardiaa.transcript.TranscriberUtils;
import net.dv8tion.jda.api.entities.Message;
@SuppressWarnings("unchecked")
public final class JteattachmentsGenerated {
	public static final String JTE_NAME = "discord/message/attachments.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,6,6,6,7,9,10,10,10,10,10,10,10,10,10,11,11,12,12,13,13,15,15,17,37,37,37,37,37,37,37,37,37,40,40,40,43,43,43,46,46,47,47,4,4,4,4};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteattachmentsGenerated.class, "JteattachmentsGenerated.bin", 2,47,13,1,3,2,2,8,926,7,1,53,55,27);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Message message) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		List<Message.Attachment> images = message.getAttachments().stream().filter(Message.Attachment::isImage).toList();
		List<Message.Attachment> files = message.getAttachments().stream().filter(a -> !a.isImage()).toList();
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
			for (Message.Attachment image : images) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				gg.jte.generated.precompiled.util.JteimageGenerated.render(jteOutput, jteHtmlInterceptor, image.getUrl(), image.getFileName());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		}
		for (Message.Attachment file : files) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			var __jte_html_attribute_1 = file.getUrl();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("a", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(file.getFileName());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(TranscriberUtils.formatBytes(file.getSize()));
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Message message = (Message)params.get("message");
		render(jteOutput, jteHtmlInterceptor, message);
	}
}
