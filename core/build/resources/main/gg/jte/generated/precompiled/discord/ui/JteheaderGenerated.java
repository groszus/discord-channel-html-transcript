package gg.jte.generated.precompiled.discord.ui;
import dev.omardiaa.transcript.core.model.payload.Channel;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.util.MarkdownUtil;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JteheaderGenerated {
	public static final String JTE_NAME = "discord/ui/header.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,9,9,9,11,11,11,11,11,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,17,17,17,33,33,33,35,35,37,37,38,38,41,41,41,4,5,5,5,5};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteheaderGenerated.class, "JteheaderGenerated.bin", 75,15,6,1,7,6,1,45,38,573,9,103,6,21);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Channel channel) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (guild.iconUrl() != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			var __jte_html_attribute_0 = guild.iconUrl();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				jteOutput.setContext("img", "src");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			var __jte_html_attribute_1 = guild.name();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				jteOutput.setContext("img", "alt");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(guild.name());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(channel.name());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
		if (channel.topic() != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			jteOutput.writeUnsafeContent(MarkdownUtil.parseMarkup(channel.topic()));
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Channel channel = (Channel)params.get("channel");
		render(jteOutput, jteHtmlInterceptor, guild, channel);
	}
}
