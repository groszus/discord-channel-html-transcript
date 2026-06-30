package gg.jte.generated.precompiled.util;
import dev.omardiaa.transcript.core.model.payload.common.Emoji;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JteemojiGenerated {
	public static final String JTE_NAME = "util/emoji.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,5,5,5,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,11,11,12,12,12,12,12,12,12,12,12,12,12,13,13,14,14,2,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteemojiGenerated.class, "JteemojiGenerated.bin", 2,7,6,1,3,6,1,3,8,1,6,5,8,1,1,9);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	private static final byte[] TEXT_PART_BINARY_9 = BINARY_CONTENT.get(9);
	private static final byte[] TEXT_PART_BINARY_10 = BINARY_CONTENT.get(10);
	private static final byte[] TEXT_PART_BINARY_11 = BINARY_CONTENT.get(11);
	private static final byte[] TEXT_PART_BINARY_12 = BINARY_CONTENT.get(12);
	private static final byte[] TEXT_PART_BINARY_13 = BINARY_CONTENT.get(13);
	private static final byte[] TEXT_PART_BINARY_14 = BINARY_CONTENT.get(14);
	private static final byte[] TEXT_PART_BINARY_15 = BINARY_CONTENT.get(15);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Emoji emoji, String classes) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (emoji instanceof Emoji.Custom customEmoji) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			var __jte_html_attribute_0 = customEmoji.iconUrl();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				jteOutput.setContext("img", "src");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			var __jte_html_attribute_1 = customEmoji.name();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				jteOutput.setContext("img", "alt");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			var __jte_html_attribute_2 = classes;
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
				jteOutput.setContext("img", "class");
				jteOutput.writeUserContent(__jte_html_attribute_2);
				jteOutput.setContext("img", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
		} else if (emoji instanceof Emoji.Unicode unicodeEmoji) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			var __jte_html_attribute_3 = classes;
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
				jteOutput.setContext("span", "class");
				jteOutput.writeUserContent(__jte_html_attribute_3);
				jteOutput.setContext("span", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
			jteOutput.writeUnsafeContent(unicodeEmoji.asUTF8());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Emoji emoji = (Emoji)params.get("emoji");
		String classes = (String)params.get("classes");
		render(jteOutput, jteHtmlInterceptor, emoji, classes);
	}
}
