package gg.jte.generated.precompiled.discord.components;
import dev.omardiaa.transcript.core.util.Helper;
import dev.omardiaa.transcript.core.model.payload.message.component.File;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtefileGenerated {
	public static final String JTE_NAME = "discord/components/file.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,23,23,23,23,23,23,23,23,23,23,26,26,26,29,29,29,32,32,32,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtefileGenerated.class, "JtefileGenerated.bin", 864,7,1,41,43,27);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, File file) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		var __jte_html_attribute_0 = file.file().url();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		jteOutput.setContext("a", null);
		jteOutput.writeUserContent(file.name());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(Helper.formatBytes(file.size()));
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		File file = (File)params.get("file");
		render(jteOutput, jteHtmlInterceptor, file);
	}
}
