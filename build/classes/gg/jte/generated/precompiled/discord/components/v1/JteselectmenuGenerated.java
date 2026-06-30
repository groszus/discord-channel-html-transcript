package gg.jte.generated.precompiled.discord.components.v1;
import net.dv8tion.jda.api.components.selections.SelectMenu;
@SuppressWarnings("unchecked")
public final class JteselectmenuGenerated {
	public static final String JTE_NAME = "discord/components/v1/select-menu.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,2,2,6,6,6,6,19,19,19,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteselectmenuGenerated.class, "JteselectmenuGenerated.bin", 93,284);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, SelectMenu selectMenu) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(selectMenu.getPlaceholder() == null ? "Make a selection" : selectMenu.getPlaceholder());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		SelectMenu selectMenu = (SelectMenu)params.get("selectMenu");
		render(jteOutput, jteHtmlInterceptor, selectMenu);
	}
}
