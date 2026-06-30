package gg.jte.generated.precompiled.discord.components;
import dev.omardiaa.transcript.core.model.payload.PayloadOptions;
import dev.omardiaa.transcript.core.model.payload.message.component.MediaGallery;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtemediagalleryGenerated {
	public static final String JTE_NAME = "discord/components/media-gallery.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,3,6,6,6,6,6,6,6,6,6,6,7,7,8,8,9,9,11,11,11,3,4,4,4,4};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtemediagalleryGenerated.class, "JtemediagalleryGenerated.bin", 21,13,1,3,2,2,8);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MediaGallery mediaGallery, PayloadOptions options) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		var __jte_html_attribute_0 = mediaGallery.items().size();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("div", "data-count");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("div", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		for (MediaGallery.Item item : mediaGallery.items()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			gg.jte.generated.precompiled.util.JteimageGenerated.render(jteOutput, jteHtmlInterceptor, item.media().url());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MediaGallery mediaGallery = (MediaGallery)params.get("mediaGallery");
		PayloadOptions options = (PayloadOptions)params.get("options");
		render(jteOutput, jteHtmlInterceptor, mediaGallery, options);
	}
}
