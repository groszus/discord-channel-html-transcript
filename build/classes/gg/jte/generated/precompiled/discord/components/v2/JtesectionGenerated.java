package gg.jte.generated.precompiled.discord.components.v2;
import dev.omardiaa.transcript.TranscriberUtils;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.components.section.Section;
import net.dv8tion.jda.api.components.section.SectionContentComponentUnion;
import net.dv8tion.jda.api.components.buttons.Button;
import net.dv8tion.jda.api.components.thumbnail.Thumbnail;
@SuppressWarnings("unchecked")
public final class JtesectionGenerated {
	public static final String JTE_NAME = "discord/components/v2/section.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,5,7,7,7,7,7,7,7,7,7,7,7,7,7,7,12,12,12,14,14,16,16,20,20,21,21,22,22,23,23,24,24,27,27,27,7,8,8,8,8};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtesectionGenerated.class, "JtesectionGenerated.bin", 59,40,14,48,4,2,4,2,18);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Section section) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		for (SectionContentComponentUnion contentComponent : section.getContentComponents()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.writeUnsafeContent(TranscriberUtils.parseMarkup(guild, contentComponent.asTextDisplay().getContent()));
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		if (section.getAccessory() instanceof Button button) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			gg.jte.generated.precompiled.discord.components.v1.JtebuttonGenerated.render(jteOutput, jteHtmlInterceptor, button);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		} else if (section.getAccessory() instanceof Thumbnail thumbnail) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			gg.jte.generated.precompiled.util.JteimageGenerated.render(jteOutput, jteHtmlInterceptor, thumbnail.getUrl(), "Thumbnail");
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Section section = (Section)params.get("section");
		render(jteOutput, jteHtmlInterceptor, guild, section);
	}
}
