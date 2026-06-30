package gg.jte.generated.precompiled.discord.message;
import dev.omardiaa.transcript.core.model.payload.Guild;
import dev.omardiaa.transcript.core.model.payload.Message;
import dev.omardiaa.transcript.core.model.payload.message.MessageSnapshot;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtemessagesnapshotsGenerated {
	public static final String JTE_NAME = "discord/message/message-snapshots.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,4,7,7,7,8,22,22,24,24,25,26,26,4,5,5,5,5};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtemessagesnapshotsGenerated.class, "JtemessagesnapshotsGenerated.bin", 2,369,10);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, Message message) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (message.messageSnapshots() != null) {
			for (MessageSnapshot snapshot : message.messageSnapshots()) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				gg.jte.generated.precompiled.discord.message.JtecontentGenerated.render(jteOutput, jteHtmlInterceptor, guild, message, snapshot.message().content());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			}
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		Message message = (Message)params.get("message");
		render(jteOutput, jteHtmlInterceptor, guild, message);
	}
}
