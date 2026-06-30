package gg.jte.generated.precompiled;
import java.util.List;
import dev.omardiaa.transcript.TranscriberConstants;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;;
@SuppressWarnings("unchecked")
public final class JtetranscriptGenerated {
	public static final String JTE_NAME = "transcript.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,13,13,13,13,13,13,13,20,20,23,23,23,23,23,23,23,23,23,25,25,26,26,27,27,31,31,34,34,36,37,38,40,41,41,42,42,45,45,45,45,45,45,45,45,45,48,48,51,51,53,53,53,53,53,53,53,53,53,57,57,58,58,58,59,59,63,63,66,66,66,66,67,67,67,67,70,70,70,73,73,75,75,77,77,80,80,82,82,82,85,85,87,87,91,91,92,96,96,96,5,6,7,7,7,7};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtetranscriptGenerated.class, "JtetranscriptGenerated.bin", 82,3,13212,34,7,1,8,2,2,19,27,2,2,10,19,1,43,66,19,6,1,73,39,9,25,81,21,56,18,63,66,51,20,38,6,25,25);
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
	private static final byte[] TEXT_PART_BINARY_29 = BINARY_CONTENT.get(29);
	private static final byte[] TEXT_PART_BINARY_30 = BINARY_CONTENT.get(30);
	private static final byte[] TEXT_PART_BINARY_31 = BINARY_CONTENT.get(31);
	private static final byte[] TEXT_PART_BINARY_32 = BINARY_CONTENT.get(32);
	private static final byte[] TEXT_PART_BINARY_33 = BINARY_CONTENT.get(33);
	private static final byte[] TEXT_PART_BINARY_34 = BINARY_CONTENT.get(34);
	private static final byte[] TEXT_PART_BINARY_35 = BINARY_CONTENT.get(35);
	private static final byte[] TEXT_PART_BINARY_36 = BINARY_CONTENT.get(36);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, GuildMessageChannel channel, List<Message> messages, String testStyle) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(channel.getName());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(channel.getGuild().getName());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		if (testStyle != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
			var __jte_html_attribute_0 = testStyle;
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
				jteOutput.setContext("link", "href");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("link", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
		} else {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			gg.jte.generated.precompiled.JtestyleGenerated.render(jteOutput, jteHtmlInterceptor);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
		gg.jte.generated.precompiled.discord.ui.JteheaderGenerated.render(jteOutput, jteHtmlInterceptor, channel);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
		Message previousMessage = messages.getFirst();
		for (Message message : messages) {
			boolean showDivider = previousMessage.equals(message) || (previousMessage.getTimeCreated().getDayOfYear() != message.getTimeCreated().getDayOfYear());
			boolean showAuthor = showDivider || !previousMessage.getAuthor().equals(message.getAuthor()) || (message.getReferencedMessage() != null) || (message.getInteraction() != null);
			if (showDivider) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
				gg.jte.generated.precompiled.discord.ui.JtedividerGenerated.render(jteOutput, jteHtmlInterceptor, message);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
			var __jte_html_attribute_1 = showAuthor;
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
				jteOutput.setContext("li", "data-show-author");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("li", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
			gg.jte.generated.precompiled.discord.ui.JtereferenceGenerated.render(jteOutput, jteHtmlInterceptor, message.getReferencedMessage(), message.getInteraction());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
			if (showAuthor) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
				var __jte_html_attribute_2 = message.getAuthor().getEffectiveAvatarUrl();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
					jteOutput.setContext("img", "src");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("img", null);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
			} else {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
				jteOutput.setContext("time", null);
				jteOutput.writeUserContent(message.getTimeCreated().format(TranscriberConstants.TIME_SHORT));
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
			if (showAuthor) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(message.getAuthor().getId());
				jteOutput.setContext("a", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
				jteOutput.setContext("a", "title");
				jteOutput.writeUserContent(message.getAuthor().getName());
				jteOutput.setContext("a", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_27);
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(message.getAuthor().getEffectiveName());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_28);
				if (message.getAuthor().isBot()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_29);
				} else if (message.getAuthor().isSystem()) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_30);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_31);
				gg.jte.generated.precompiled.discord.ui.JtetimestampGenerated.render(jteOutput, jteHtmlInterceptor, message.getTimeCreated());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_32);
				jteOutput.setContext("time", null);
				jteOutput.writeUserContent(message.getTimeCreated().format(TranscriberConstants.DATE_SHORT));
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_33);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_34);
			gg.jte.generated.precompiled.discord.JtemessageGenerated.render(jteOutput, jteHtmlInterceptor, message);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_35);
			previousMessage = message;
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_36);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		GuildMessageChannel channel = (GuildMessageChannel)params.get("channel");
		List<Message> messages = (List<Message>)params.get("messages");
		String testStyle = (String)params.get("testStyle");
		render(jteOutput, jteHtmlInterceptor, channel, messages, testStyle);
	}
}
