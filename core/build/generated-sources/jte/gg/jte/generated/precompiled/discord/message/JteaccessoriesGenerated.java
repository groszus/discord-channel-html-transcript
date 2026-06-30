package gg.jte.generated.precompiled.discord.message;
import dev.omardiaa.transcript.core.model.Payload;
import dev.omardiaa.transcript.core.model.payload.Message;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JteaccessoriesGenerated {
	public static final String JTE_NAME = "discord/message/accessories.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,6,6,6,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,15,16,16,18,18,19,19,3,4,4,4,4};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteaccessoriesGenerated.class, "JteaccessoriesGenerated.bin", 2,36,2,2,2,4,4,4,4,2,8);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Payload payload, Message message) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (message.hasAccessories()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			if (message.poll() != null) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				gg.jte.generated.precompiled.discord.message.accessory.JtepollGenerated.render(jteOutput, jteHtmlInterceptor, message.poll());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
			} else {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
				gg.jte.generated.precompiled.discord.message.accessory.JteattachmentsGenerated.render(jteOutput, jteHtmlInterceptor, message, payload.options());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				gg.jte.generated.precompiled.discord.message.accessory.JteembedsGenerated.render(jteOutput, jteHtmlInterceptor, payload.guild(), message);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
				gg.jte.generated.precompiled.discord.message.accessory.JtecomponentsGenerated.render(jteOutput, jteHtmlInterceptor, payload.guild(), message, payload.options());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
				gg.jte.generated.precompiled.discord.message.accessory.JtestickersGenerated.render(jteOutput, jteHtmlInterceptor, message);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
				gg.jte.generated.precompiled.discord.message.accessory.JtereactionsGenerated.render(jteOutput, jteHtmlInterceptor, message);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Payload payload = (Payload)params.get("payload");
		Message message = (Message)params.get("message");
		render(jteOutput, jteHtmlInterceptor, payload, message);
	}
}
