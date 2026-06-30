package gg.jte.generated.precompiled.discord.components;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.PayloadOptions;
import dev.omardiaa.transcript.core.model.payload.message.component.Section;
import dev.omardiaa.transcript.core.model.payload.message.component.SectionChildComponent;
import dev.omardiaa.transcript.core.model.payload.message.component.Button;
import dev.omardiaa.transcript.core.model.payload.message.component.Thumbnail;
import dev.omardiaa.transcript.core.model.payload.message.component.TextDisplay;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtesectionGenerated {
	public static final String JTE_NAME = "discord/components/section.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,5,6,7,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,16,16,16,17,18,18,19,19,20,24,24,25,25,26,26,27,27,28,28,31,31,31,9,10,11,12,12,12,12};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtesectionGenerated.class, "JtesectionGenerated.bin", 59,4,2,65,4,2,4,2,18);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Message message, Section section, PayloadOptions options) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		for (SectionChildComponent component : section.components()) {
			if (component instanceof TextDisplay textDisplay) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				gg.jte.generated.precompiled.discord.message.JtecontentGenerated.render(jteOutput, jteHtmlInterceptor, guild, message, textDisplay.content());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			}
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		if (section.accessory() instanceof Button button) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			gg.jte.generated.precompiled.discord.components.JtebuttonGenerated.render(jteOutput, jteHtmlInterceptor, button);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		} else if (section.accessory() instanceof Thumbnail thumbnail) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			gg.jte.generated.precompiled.util.JteimageGenerated.render(jteOutput, jteHtmlInterceptor, thumbnail.media().url());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Message message = (Message)params.get("message");
		Section section = (Section)params.get("section");
		PayloadOptions options = (PayloadOptions)params.get("options");
		render(jteOutput, jteHtmlInterceptor, guild, message, section, options);
	}
}
