package gg.jte.generated.precompiled.discord.components;
import dev.omardiaa.transcript.core.model.payload.message.component.ActionRow;
import dev.omardiaa.transcript.core.model.payload.message.component.ActionRowChildComponent;
import dev.omardiaa.transcript.core.model.payload.message.component.Button;
import dev.omardiaa.transcript.core.model.payload.message.component.SelectMenu;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JteactionrowGenerated {
	public static final String JTE_NAME = "discord/components/action-row.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,8,8,8,9,10,10,11,11,12,12,13,13,14,16,16,16,5,5,5,5};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteactionrowGenerated.class, "JteactionrowGenerated.bin", 45,2,2,2,2,8);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ActionRow actionRow) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		for (ActionRowChildComponent component : actionRow.components()) {
			if (component instanceof Button button) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				gg.jte.generated.precompiled.discord.components.JtebuttonGenerated.render(jteOutput, jteHtmlInterceptor, button);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			} else if (component instanceof SelectMenu selectMenu) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				gg.jte.generated.precompiled.discord.components.JteselectmenuGenerated.render(jteOutput, jteHtmlInterceptor, selectMenu);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			}
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ActionRow actionRow = (ActionRow)params.get("actionRow");
		render(jteOutput, jteHtmlInterceptor, actionRow);
	}
}
