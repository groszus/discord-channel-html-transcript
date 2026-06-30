package gg.jte.generated.precompiled.discord.ui;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
@SuppressWarnings("unchecked")
public final class JteheaderGenerated {
	public static final String JTE_NAME = "discord/ui/header.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,14,14,14,32,32,32,35,35,35,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteheaderGenerated.class, "JteheaderGenerated.bin", 135,6,1,9,6,1,95,631,29);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, GuildMessageChannel channel) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		var __jte_html_attribute_0 = channel.getGuild().getIconUrl();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("img", "src");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("img", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		var __jte_html_attribute_1 = channel.getGuild().getName();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			jteOutput.setContext("img", "alt");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("img", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(channel.getGuild().getName());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(channel.getName());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		GuildMessageChannel channel = (GuildMessageChannel)params.get("channel");
		render(jteOutput, jteHtmlInterceptor, channel);
	}
}
