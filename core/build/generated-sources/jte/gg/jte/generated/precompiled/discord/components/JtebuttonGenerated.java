package gg.jte.generated.precompiled.discord.components;
import dev.omardiaa.transcript.core.model.payload.message.component.Button;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtebuttonGenerated {
	public static final String JTE_NAME = "discord/components/button.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,5,5,5,5,5,5,5,5,5,5,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,11,11,12,12,13,13,15,16,16,16,17,17,19,27,27,29,29,29,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtebuttonGenerated.class, "JtebuttonGenerated.bin", 7,7,1,22,23,1,3,20,1,23,2,2,8,9,361,6);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Button button) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		var __jte_html_attribute_0 = button.disabled() ? null : button.url();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		var __jte_html_attribute_1 = button.disabled();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			jteOutput.setContext("a", "data-button-disabled");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
		var __jte_html_attribute_2 = button.style().name();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			jteOutput.setContext("a", "data-button-style");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
		if (button.emoji() != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
			gg.jte.generated.precompiled.util.JteemojiGenerated.render(jteOutput, jteHtmlInterceptor, button.emoji(), "button__emoji");
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
		}
		if (button.label() != null) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(button.label());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
		}
		if (button.style() == Button.Style.LINK) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Button button = (Button)params.get("button");
		render(jteOutput, jteHtmlInterceptor, button);
	}
}
