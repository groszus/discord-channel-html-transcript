package gg.jte.generated.precompiled.discord.components.v1;
import net.dv8tion.jda.api.components.buttons.Button;
import net.dv8tion.jda.api.components.buttons.ButtonStyle;
import net.dv8tion.jda.api.entities.emoji.CustomEmoji;
import net.dv8tion.jda.api.entities.emoji.UnicodeEmoji;
@SuppressWarnings("unchecked")
public final class JtebuttonGenerated {
	public static final String JTE_NAME = "discord/components/v1/button.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,12,12,12,12,12,12,12,12,12,15,15,16,18,18,18,18,18,18,18,18,18,19,19,19,19,19,19,19,19,19,22,22,24,24,24,26,26,27,29,29,29,31,31,40,40,42,42,42,5,5,5,5};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtebuttonGenerated.class, "JtebuttonGenerated.bin", 7,7,1,3,16,1,39,20,1,40,11,6,1,5,6,1,35,39,14,8,11,401,6);
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
	private static final byte[] TEXT_PART_BINARY_16 = BINARY_CONTENT.get(16);
	private static final byte[] TEXT_PART_BINARY_17 = BINARY_CONTENT.get(17);
	private static final byte[] TEXT_PART_BINARY_18 = BINARY_CONTENT.get(18);
	private static final byte[] TEXT_PART_BINARY_19 = BINARY_CONTENT.get(19);
	private static final byte[] TEXT_PART_BINARY_20 = BINARY_CONTENT.get(20);
	private static final byte[] TEXT_PART_BINARY_21 = BINARY_CONTENT.get(21);
	private static final byte[] TEXT_PART_BINARY_22 = BINARY_CONTENT.get(22);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Button button) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		var __jte_html_attribute_0 = button.isDisabled() ? null : button.getUrl();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		var __jte_html_attribute_1 = button.isDisabled();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			jteOutput.setContext("a", "aria-disabled");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
		var __jte_html_attribute_2 = button.getStyle().name();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			jteOutput.setContext("a", "data-button-style");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
		if (button.getEmoji() != null) {
			if (button.getEmoji() instanceof CustomEmoji customEmoji) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
				var __jte_html_attribute_3 = customEmoji.getImageUrl();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
					jteOutput.setContext("img", "src");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("img", null);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
				var __jte_html_attribute_4 = customEmoji.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
					jteOutput.setContext("img", "alt");
					jteOutput.writeUserContent(__jte_html_attribute_4);
					jteOutput.setContext("img", null);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
			} else if (button.getEmoji() instanceof UnicodeEmoji unicodeEmoji) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(unicodeEmoji.getAsCodepoints().replace("U+", ""));
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
			}
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(button.getLabel());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
		if (button.getStyle() == ButtonStyle.LINK) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Button button = (Button)params.get("button");
		render(jteOutput, jteHtmlInterceptor, button);
	}
}
