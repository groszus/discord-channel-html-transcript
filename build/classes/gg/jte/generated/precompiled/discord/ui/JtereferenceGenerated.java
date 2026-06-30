package gg.jte.generated.precompiled.discord.ui;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.interactions.InteractionType;
@SuppressWarnings("unchecked")
public final class JtereferenceGenerated {
	public static final String JTE_NAME = "discord/ui/reference.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,7,7,7,11,11,14,14,14,14,14,14,14,14,14,15,15,15,15,19,19,21,21,23,23,26,26,26,26,27,27,27,27,30,30,30,34,34,34,34,37,37,39,39,40,40,40,41,41,43,56,56,59,59,61,65,65,68,68,68,68,68,68,68,68,68,69,69,69,69,74,74,74,74,75,75,75,75,78,78,78,94,94,94,97,97,98,98,4,5,5,5,5};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtereferenceGenerated.class, "JtereferenceGenerated.bin", 2,82,11,6,1,12,50,40,60,42,15,49,29,49,36,4,2,701,16,82,11,6,1,12,92,15,49,1238,27);
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
	private static final byte[] TEXT_PART_BINARY_17 = BINARY_CONTENT.get(17);
	private static final byte[] TEXT_PART_BINARY_18 = BINARY_CONTENT.get(18);
	private static final byte[] TEXT_PART_BINARY_19 = BINARY_CONTENT.get(19);
	private static final byte[] TEXT_PART_BINARY_20 = BINARY_CONTENT.get(20);
	private static final byte[] TEXT_PART_BINARY_21 = BINARY_CONTENT.get(21);
	private static final byte[] TEXT_PART_BINARY_22 = BINARY_CONTENT.get(22);
	private static final byte[] TEXT_PART_BINARY_23 = BINARY_CONTENT.get(23);
	private static final byte[] TEXT_PART_BINARY_24 = BINARY_CONTENT.get(24);
	private static final byte[] TEXT_PART_BINARY_25 = BINARY_CONTENT.get(25);
	private static final byte[] TEXT_PART_BINARY_26 = BINARY_CONTENT.get(26);
	private static final byte[] TEXT_PART_BINARY_27 = BINARY_CONTENT.get(27);
	private static final byte[] TEXT_PART_BINARY_28 = BINARY_CONTENT.get(28);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Message referencedMessage, Message.Interaction interaction) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (referencedMessage != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			User author = referencedMessage.getAuthor();
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			var __jte_html_attribute_0 = author.getEffectiveAvatarUrl();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				jteOutput.setContext("img", "src");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
			jteOutput.setContext("img", "alt");
			jteOutput.writeUserContent(author.getName());
			jteOutput.setContext("img", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			if (author.isBot()) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			} else if (author.isBot()) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(author.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
			jteOutput.setContext("a", "title");
			jteOutput.writeUserContent(author.getName());
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(author.getEffectiveName());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(referencedMessage.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
			if (referencedMessage.getContentRaw().isEmpty()) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
			} else {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(referencedMessage.getContentRaw());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
			}
			if (!referencedMessage.getAttachments().isEmpty() || referencedMessage.getContentRaw().isEmpty()) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
		}
		if ((interaction != null) && interaction.getType().equals(InteractionType.COMMAND)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
			User user = interaction.getUser();
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
			var __jte_html_attribute_1 = user.getEffectiveAvatarUrl();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
				jteOutput.setContext("img", "src");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
			jteOutput.setContext("img", "alt");
			jteOutput.writeUserContent(user.getName());
			jteOutput.setContext("img", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(user.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
			jteOutput.setContext("a", "title");
			jteOutput.writeUserContent(user.getName());
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(user.getEffectiveName());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_27);
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(interaction.getName());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_28);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Message referencedMessage = (Message)params.get("referencedMessage");
		Message.Interaction interaction = (Message.Interaction)params.get("interaction");
		render(jteOutput, jteHtmlInterceptor, referencedMessage, interaction);
	}
}
