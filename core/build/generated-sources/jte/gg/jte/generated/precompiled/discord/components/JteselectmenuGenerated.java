package gg.jte.generated.precompiled.discord.components;
import dev.omardiaa.transcript.core.model.payload.message.component.SelectMenu;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JteselectmenuGenerated {
	public static final String JTE_NAME = "discord/components/select-menu.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,2,2,2,5,5,5,5,16,16,16,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteselectmenuGenerated.class, "JteselectmenuGenerated.bin", 87,240);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, SelectMenu selectMenu) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(selectMenu.placeholder());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		SelectMenu selectMenu = (SelectMenu)params.get("selectMenu");
		render(jteOutput, jteHtmlInterceptor, selectMenu);
	}
}
