package gg.jte.generated.precompiled.discord.components.v2;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.components.container.Container;
import net.dv8tion.jda.api.components.container.ContainerChildComponent;
import net.dv8tion.jda.api.components.actionrow.ActionRow;
import net.dv8tion.jda.api.components.section.Section;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.components.mediagallery.MediaGallery;
import net.dv8tion.jda.api.components.separator.Separator;
@SuppressWarnings("unchecked")
public final class JtecontainerGenerated {
	public static final String JTE_NAME = "discord/components/v2/container.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,5,6,7,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,13,13,13,14,15,15,16,16,17,17,18,18,19,19,20,20,21,21,22,22,23,23,24,24,25,27,27,27,9,10,10,10,10};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtecontainerGenerated.class, "JtecontainerGenerated.bin", 27,2,2,2,2,2,2,2,2,2,2,8);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Container container) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		for (ContainerChildComponent component : container.getComponents()) {
			if (component instanceof ActionRow actionRow) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				gg.jte.generated.precompiled.discord.components.v1.JteactionrowGenerated.render(jteOutput, jteHtmlInterceptor, actionRow);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			} else if (component instanceof Section section) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				gg.jte.generated.precompiled.discord.components.v2.JtesectionGenerated.render(jteOutput, jteHtmlInterceptor, guild, section);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			} else if (component instanceof TextDisplay textDisplay) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				gg.jte.generated.precompiled.discord.components.v2.JtetextdisplayGenerated.render(jteOutput, jteHtmlInterceptor, guild, textDisplay);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			} else if (component instanceof MediaGallery mediaGallery) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
				gg.jte.generated.precompiled.discord.components.v2.JtemediagalleryGenerated.render(jteOutput, jteHtmlInterceptor, mediaGallery);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			} else if (component instanceof Separator separator) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
				gg.jte.generated.precompiled.discord.components.v2.JteseparatorGenerated.render(jteOutput, jteHtmlInterceptor, separator);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
			}
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Container container = (Container)params.get("container");
		render(jteOutput, jteHtmlInterceptor, guild, container);
	}
}
