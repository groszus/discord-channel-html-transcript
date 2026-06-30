package gg.jte.generated.precompiled.util;
import dev.omardiaa.transcript.core.util.Helper;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JteimageGenerated {
	public static final String JTE_NAME = "util/image.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,2,2,2,2,2,6,6,6,6,6,6,6,6,6,6,11,11,11,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteimageGenerated.class, "JteimageGenerated.bin", 43,6,1,52);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String src) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		var __jte_html_attribute_0 = Helper.downloadAndEncode(src);
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("img", "src");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("img", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String src = (String)params.get("src");
		render(jteOutput, jteHtmlInterceptor, src);
	}
}
