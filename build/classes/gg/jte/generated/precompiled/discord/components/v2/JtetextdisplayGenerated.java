package gg.jte.generated.precompiled.discord.components.v2;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import dev.omardiaa.transcript.TranscriberUtils;
@SuppressWarnings("unchecked")
public final class JtetextdisplayGenerated {
	public static final String JTE_NAME = "discord/components/v2/text-display.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,9,9,9,12,12,12,4,5,5,5,5};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtetextdisplayGenerated.class, "JtetextdisplayGenerated.bin", 66,20);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Guild guild, TextDisplay textDisplay) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.writeUnsafeContent(TranscriberUtils.parseMarkup(guild, textDisplay.getContent()));
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Guild guild = (Guild)params.get("guild");
		TextDisplay textDisplay = (TextDisplay)params.get("textDisplay");
		render(jteOutput, jteHtmlInterceptor, guild, textDisplay);
	}
}
