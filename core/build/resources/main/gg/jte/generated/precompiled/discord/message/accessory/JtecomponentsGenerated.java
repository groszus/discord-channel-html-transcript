package gg.jte.generated.precompiled.discord.message.accessory;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.PayloadOptions;
import dev.omardiaa.transcript.core.model.payload.message.component.ActionRow;
import dev.omardiaa.transcript.core.model.payload.message.component.Component;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtecomponentsGenerated {
	public static final String JTE_NAME = "discord/message/accessory/components.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,6,6,6,6,6,6,6,6,6,10,10,10,11,13,13,14,14,15,15,17,17,18,19,20,20,21,22,23,23,6,7,8,8,8,8};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtecomponentsGenerated.class, "JtecomponentsGenerated.bin", 2,26,2,2,8,2);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Message message, PayloadOptions options) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (message.components() != null && !message.components().isEmpty()) {
			if (message.isComponentsV2()) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				for (Component component : message.components()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
					gg.jte.generated.precompiled.discord.components.JtecomponentGenerated.render(jteOutput, jteHtmlInterceptor, guild, message, component, options);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			} else {
				for (ActionRow actionRow : message.components().stream().filter(c -> c instanceof ActionRow).map(c -> (ActionRow) c).toList()) {
					gg.jte.generated.precompiled.discord.components.JteactionrowGenerated.render(jteOutput, jteHtmlInterceptor, actionRow);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				}
			}
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Message message = (Message)params.get("message");
		PayloadOptions options = (PayloadOptions)params.get("options");
		render(jteOutput, jteHtmlInterceptor, guild, message, options);
	}
}
