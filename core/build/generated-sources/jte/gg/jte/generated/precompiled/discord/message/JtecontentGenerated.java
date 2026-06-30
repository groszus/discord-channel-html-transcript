package gg.jte.generated.precompiled.discord.message;
import dev.omardiaa.transcript.core.util.MarkdownUtil;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtecontentGenerated {
	public static final String JTE_NAME = "discord/message/content.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,4,8,8,8,9,9,10,10,11,11,4,5,6,6,6,6};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtecontentGenerated.class, "JtecontentGenerated.bin", 2,37,8);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Message message, String content) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (!content.isBlank()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.writeUnsafeContent(MarkdownUtil.parseMarkup(guild, message, content));
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Message message = (Message)params.get("message");
		String content = (String)params.get("content");
		render(jteOutput, jteHtmlInterceptor, guild, message, content);
	}
}
