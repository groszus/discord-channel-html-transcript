package gg.jte.generated.precompiled.discord.message;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.components.MessageTopLevelComponent;
import net.dv8tion.jda.api.components.container.Container;
import net.dv8tion.jda.api.components.section.Section;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.components.mediagallery.MediaGallery;
import net.dv8tion.jda.api.components.separator.Separator;
import net.dv8tion.jda.api.components.actionrow.ActionRow;
@SuppressWarnings("unchecked")
public final class JtecomponentsGenerated {
	public static final String JTE_NAME = "discord/message/components.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,5,6,7,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,11,11,11,12,14,14,15,16,16,17,17,18,18,19,19,20,20,21,21,22,22,23,23,24,24,25,25,26,26,27,27,28,30,30,31,33,33,34,35,35,36,37,38,38,9,9,9,9};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtecomponentsGenerated.class, "JtecomponentsGenerated.bin", 2,26,2,2,2,2,2,2,2,2,2,2,2,2,8,4,2);
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
	private static final byte[] TEXT_PART_BINARY_14 = BINARY_CONTENT.get(14);
	private static final byte[] TEXT_PART_BINARY_15 = BINARY_CONTENT.get(15);
	private static final byte[] TEXT_PART_BINARY_16 = BINARY_CONTENT.get(16);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Message message) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (!message.getComponents().isEmpty()) {
			if (message.isUsingComponentsV2()) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				for (MessageTopLevelComponent component : message.getComponents()) {
					if (component instanceof Container container) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
						gg.jte.generated.precompiled.discord.components.v2.JtecontainerGenerated.render(jteOutput, jteHtmlInterceptor, message.getGuild(), container);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
					} else if (component instanceof Section section) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
						gg.jte.generated.precompiled.discord.components.v2.JtesectionGenerated.render(jteOutput, jteHtmlInterceptor, message.getGuild(), section);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
					} else if (component instanceof TextDisplay textDisplay) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
						gg.jte.generated.precompiled.discord.components.v2.JtetextdisplayGenerated.render(jteOutput, jteHtmlInterceptor, message.getGuild(), textDisplay);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
					} else if (component instanceof MediaGallery mediaGallery) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
						gg.jte.generated.precompiled.discord.components.v2.JtemediagalleryGenerated.render(jteOutput, jteHtmlInterceptor, mediaGallery);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
					} else if (component instanceof Separator separator) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
						gg.jte.generated.precompiled.discord.components.v2.JteseparatorGenerated.render(jteOutput, jteHtmlInterceptor, separator);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
					} else if (component instanceof ActionRow actionRow) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
						gg.jte.generated.precompiled.discord.components.v1.JteactionrowGenerated.render(jteOutput, jteHtmlInterceptor, actionRow);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
					}
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
			} else {
				gg.jte.generated.precompiled.discord.message.JteembedsGenerated.render(jteOutput, jteHtmlInterceptor, message.getGuild(), message.getEmbeds());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
				for (ActionRow actionRow : message.getComponentTree().findAll(ActionRow.class)) {
					gg.jte.generated.precompiled.discord.components.v1.JteactionrowGenerated.render(jteOutput, jteHtmlInterceptor, actionRow);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
				}
			}
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Message message = (Message)params.get("message");
		render(jteOutput, jteHtmlInterceptor, message);
	}
}
