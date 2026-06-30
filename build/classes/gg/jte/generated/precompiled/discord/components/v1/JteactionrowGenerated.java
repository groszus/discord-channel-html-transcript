package gg.jte.generated.precompiled.discord.components.v1;
import net.dv8tion.jda.api.components.actionrow.ActionRow;
import net.dv8tion.jda.api.components.ActionComponent;
import net.dv8tion.jda.api.components.buttons.Button;
import net.dv8tion.jda.api.components.selections.SelectMenu;
@SuppressWarnings("unchecked")
public final class JteactionrowGenerated {
	public static final String JTE_NAME = "discord/components/v1/action-row.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,8,8,8,9,10,10,11,11,12,12,13,13,14,16,16,16,5,5,5,5};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteactionrowGenerated.class, "JteactionrowGenerated.bin", 28,2,2,2,2,8);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ActionRow actionRow) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		for (ActionComponent actionComponent : actionRow.getActionComponents()) {
			if (actionComponent instanceof Button button) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				gg.jte.generated.precompiled.discord.components.v1.JtebuttonGenerated.render(jteOutput, jteHtmlInterceptor, button);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			} else if (actionComponent instanceof SelectMenu selectMenu) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				gg.jte.generated.precompiled.discord.components.v1.JteselectmenuGenerated.render(jteOutput, jteHtmlInterceptor, selectMenu);
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
