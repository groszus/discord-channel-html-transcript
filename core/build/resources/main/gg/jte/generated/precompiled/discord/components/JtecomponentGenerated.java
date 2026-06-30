package gg.jte.generated.precompiled.discord.components;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.PayloadOptions;
import dev.omardiaa.transcript.core.model.payload.message.component.*;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtecomponentGenerated {
	public static final String JTE_NAME = "discord/components/component.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,10,10,10,11,12,12,13,14,14,15,16,16,17,18,18,19,20,20,21,22,22,23,24,24,25,25,5,6,7,8,8,8,8};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtecomponentGenerated.class, "JtecomponentGenerated.bin", 2,2,2,2,2,2,2,2);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Message message, Component component, PayloadOptions options) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (component instanceof ActionRow actionRow) {
			gg.jte.generated.precompiled.discord.components.JteactionrowGenerated.render(jteOutput, jteHtmlInterceptor, actionRow);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
		} else if (component instanceof Section section) {
			gg.jte.generated.precompiled.discord.components.JtesectionGenerated.render(jteOutput, jteHtmlInterceptor, guild, message, section, options);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		} else if (component instanceof TextDisplay textDisplay) {
			gg.jte.generated.precompiled.discord.components.JtetextdisplayGenerated.render(jteOutput, jteHtmlInterceptor, guild, message, textDisplay);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		} else if (component instanceof MediaGallery mediaGallery) {
			gg.jte.generated.precompiled.discord.components.JtemediagalleryGenerated.render(jteOutput, jteHtmlInterceptor, mediaGallery, options);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
		} else if (component instanceof File file) {
			gg.jte.generated.precompiled.discord.components.JtefileGenerated.render(jteOutput, jteHtmlInterceptor, file);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		} else if (component instanceof Separator separator) {
			gg.jte.generated.precompiled.discord.components.JteseparatorGenerated.render(jteOutput, jteHtmlInterceptor, separator);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
		} else if (component instanceof Container container) {
			gg.jte.generated.precompiled.discord.components.JtecontainerGenerated.render(jteOutput, jteHtmlInterceptor, guild, message, container, options);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Message message = (Message)params.get("message");
		Component component = (Component)params.get("component");
		PayloadOptions options = (PayloadOptions)params.get("options");
		render(jteOutput, jteHtmlInterceptor, guild, message, component, options);
	}
}
