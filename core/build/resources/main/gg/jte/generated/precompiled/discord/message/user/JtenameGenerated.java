package gg.jte.generated.precompiled.discord.message.user;
import dev.omardiaa.transcript.core.model.payload.message.User;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtenameGenerated {
	public static final String JTE_NAME = "discord/message/user/name.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,2,2,2,2,2,5,5,5,5,5,7,7,7,7,7,7,7,10,10,10,12,12,12,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtenameGenerated.class, "JtenameGenerated.bin", 40,31,32,8);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, User author) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("a", "href");
		jteOutput.writeUserContent(author.id());
		jteOutput.setContext("a", null);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
		jteOutput.setContext("a", "title");
		jteOutput.writeUserContent(author.username());
		jteOutput.setContext("a", null);
		jteOutput.setContext("a", "title");
		jteOutput.writeUserContent(author.discriminator() == null ? "" : "#" + author.discriminator());
		jteOutput.setContext("a", null);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		jteOutput.setContext("a", null);
		jteOutput.writeUserContent(author.globalName());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		User author = (User)params.get("author");
		render(jteOutput, jteHtmlInterceptor, author);
	}
}
