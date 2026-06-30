package gg.jte.generated.precompiled.util;
@SuppressWarnings("unchecked")
public final class JteimageGenerated {
	public static final String JTE_NAME = "util/image.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,10,10,10,0,1,1,1,1};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteimageGenerated.class, "JteimageGenerated.bin", 43,6,1,5,6,1,35);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String src, String alt) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		var __jte_html_attribute_0 = src;
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("img", "src");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("img", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		var __jte_html_attribute_1 = alt;
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			jteOutput.setContext("img", "alt");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("img", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String src = (String)params.get("src");
		String alt = (String)params.get("alt");
		render(jteOutput, jteHtmlInterceptor, src, alt);
	}
}
