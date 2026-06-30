package gg.jte.generated.precompiled.discord.ui;
import java.time.OffsetDateTime;
import dev.omardiaa.transcript.core.util.TimeUtil;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtetimestampGenerated {
	public static final String JTE_NAME = "discord/ui/timestamp.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,6,6,6,6,32,32,32,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtetimestampGenerated.class, "JtetimestampGenerated.bin", 35,762);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, OffsetDateTime timestamp) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("time", null);
		jteOutput.writeUserContent(TimeUtil.formatDateFull(timestamp));
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		OffsetDateTime timestamp = (OffsetDateTime)params.get("timestamp");
		render(jteOutput, jteHtmlInterceptor, timestamp);
	}
}
