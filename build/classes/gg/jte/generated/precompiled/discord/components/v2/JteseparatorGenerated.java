package gg.jte.generated.precompiled.discord.components.v2;
import net.dv8tion.jda.api.components.separator.Separator;
@SuppressWarnings("unchecked")
public final class JteseparatorGenerated {
	public static final String JTE_NAME = "discord/components/v2/separator.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,2,2,2,2,2,2,2,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,9,9,9,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteseparatorGenerated.class, "JteseparatorGenerated.bin", 9,14,1,3,25,1,49);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Separator separator) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		var __jte_html_attribute_0 = !separator.isDivider();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("div", "aria-hidden");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("div", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		var __jte_html_attribute_1 = separator.getSpacing().name();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			jteOutput.setContext("div", "data-separator-spacing");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("div", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Separator separator = (Separator)params.get("separator");
		render(jteOutput, jteHtmlInterceptor, separator);
	}
}
