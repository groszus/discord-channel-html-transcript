package gg.jte.generated.precompiled.discord.components;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.PayloadOptions;
import dev.omardiaa.transcript.core.model.payload.message.component.Container;
import dev.omardiaa.transcript.core.model.payload.message.component.ContainerChildComponent;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtecontainerGenerated {
	public static final String JTE_NAME = "discord/components/container.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,6,6,6,6,6,6,6,12,12,12,13,13,14,14,16,16,16,6,7,8,9,9,9,9};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtecontainerGenerated.class, "JtecontainerGenerated.bin", 27,2,2,8);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Message message, Container container, PayloadOptions options) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		for (ContainerChildComponent component : container.components()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			gg.jte.generated.precompiled.discord.components.JtecomponentGenerated.render(jteOutput, jteHtmlInterceptor, guild, message, component, options);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Message message = (Message)params.get("message");
		Container container = (Container)params.get("container");
		PayloadOptions options = (PayloadOptions)params.get("options");
		render(jteOutput, jteHtmlInterceptor, guild, message, container, options);
	}
}
