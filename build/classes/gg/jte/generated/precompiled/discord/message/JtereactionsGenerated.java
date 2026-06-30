package gg.jte.generated.precompiled.discord.message;
import java.util.List;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.emoji.CustomEmoji;
import net.dv8tion.jda.api.entities.emoji.UnicodeEmoji;
@SuppressWarnings("unchecked")
public final class JtereactionsGenerated {
	public static final String JTE_NAME = "discord/message/reactions.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7,7,7,9,9,11,11,13,13,13,13,13,13,13,13,13,15,15,15,15,15,15,15,15,15,18,18,19,19,19,20,20,22,22,22,24,24,26,26,27,27,5,5,5,5};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtereactionsGenerated.class, "JtereactionsGenerated.bin", 2,42,26,15,6,1,33,8,1,41,37,10,34,19,8);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<MessageReaction> reactions) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (!reactions.isEmpty()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			for (MessageReaction reaction : reactions) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				if (reaction.getEmoji() instanceof CustomEmoji customEmoji) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
					var __jte_html_attribute_0 = customEmoji.getImageUrl();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
						jteOutput.setContext("img", "src");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("img", null);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
					var __jte_html_attribute_1 = customEmoji.getName();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
						jteOutput.setContext("img", "title");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("img", null);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
				} else if (reaction.getEmoji() instanceof UnicodeEmoji unicodeEmoji) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
					jteOutput.setContext("span", null);
					jteOutput.writeUserContent(unicodeEmoji.getAsCodepoints().replace("U+", ""));
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(reaction.getCount());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<MessageReaction> reactions = (List<MessageReaction>)params.get("reactions");
		render(jteOutput, jteHtmlInterceptor, reactions);
	}
}
