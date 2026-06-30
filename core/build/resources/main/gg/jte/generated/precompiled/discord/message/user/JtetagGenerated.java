package gg.jte.generated.precompiled.discord.message.user;
import dev.omardiaa.transcript.core.model.payload.message.User;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtetagGenerated {
	public static final String JTE_NAME = "discord/message/user/tag.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,2,2,2,2,4,4,4,5,5,5,6,6,7,7,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtetagGenerated.class, "JtetagGenerated.bin", 2,26,9);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, User user) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (user.tag() != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(user.tag());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		User user = (User)params.get("user");
		render(jteOutput, jteHtmlInterceptor, user);
	}
}
