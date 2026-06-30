package gg.jte.generated.precompiled.discord;
import dev.omardiaa.transcript.core.util.TimeUtil;
import dev.omardiaa.transcript.core.model.Payload;
import dev.omardiaa.transcript.core.model.payload.Message;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtemessageGenerated {
	public static final String JTE_NAME = "discord/message.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,10,10,10,11,13,14,15,15,18,18,18,18,18,18,18,18,18,19,19,19,19,19,19,19,19,19,20,20,20,20,20,20,20,20,20,23,23,24,24,27,27,29,29,29,29,29,29,29,29,29,33,33,34,34,34,35,35,39,39,41,41,42,42,45,45,46,46,46,49,49,51,51,52,52,54,54,56,56,59,59,61,61,63,63,64,64,78,78,81,81,81,84,84,85,85,85,89,89,92,92,92,95,95,97,97,98,98,4,5,6,6,6,6};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtemessageGenerated.class, "JtemessageGenerated.bin", 6,2,6,5,1,3,19,1,3,20,1,24,2,47,15,6,1,60,37,9,21,31,8,51,16,34,4,6,4,41,43,4,12,2,671,84,59,16,40,103,31,7);
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
	private static final byte[] TEXT_PART_BINARY_23 = BINARY_CONTENT.get(23);
	private static final byte[] TEXT_PART_BINARY_24 = BINARY_CONTENT.get(24);
	private static final byte[] TEXT_PART_BINARY_25 = BINARY_CONTENT.get(25);
	private static final byte[] TEXT_PART_BINARY_26 = BINARY_CONTENT.get(26);
	private static final byte[] TEXT_PART_BINARY_27 = BINARY_CONTENT.get(27);
	private static final byte[] TEXT_PART_BINARY_28 = BINARY_CONTENT.get(28);
	private static final byte[] TEXT_PART_BINARY_29 = BINARY_CONTENT.get(29);
	private static final byte[] TEXT_PART_BINARY_30 = BINARY_CONTENT.get(30);
	private static final byte[] TEXT_PART_BINARY_31 = BINARY_CONTENT.get(31);
	private static final byte[] TEXT_PART_BINARY_32 = BINARY_CONTENT.get(32);
	private static final byte[] TEXT_PART_BINARY_33 = BINARY_CONTENT.get(33);
	private static final byte[] TEXT_PART_BINARY_34 = BINARY_CONTENT.get(34);
	private static final byte[] TEXT_PART_BINARY_35 = BINARY_CONTENT.get(35);
	private static final byte[] TEXT_PART_BINARY_36 = BINARY_CONTENT.get(36);
	private static final byte[] TEXT_PART_BINARY_37 = BINARY_CONTENT.get(37);
	private static final byte[] TEXT_PART_BINARY_38 = BINARY_CONTENT.get(38);
	private static final byte[] TEXT_PART_BINARY_39 = BINARY_CONTENT.get(39);
	private static final byte[] TEXT_PART_BINARY_40 = BINARY_CONTENT.get(40);
	private static final byte[] TEXT_PART_BINARY_41 = BINARY_CONTENT.get(41);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Payload payload, Message message, Message previousMessage) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		if (message.type() != Message.Type.UNKNOWN) {
			boolean showAuthor = message.showAuthor(previousMessage);
			if (message.showDivider(previousMessage)) {
				gg.jte.generated.precompiled.discord.ui.JtedividerGenerated.render(jteOutput, jteHtmlInterceptor, message.timestamp());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			var __jte_html_attribute_0 = message.id();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				jteOutput.setContext("li", "id");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("li", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
			var __jte_html_attribute_1 = showAuthor;
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
				jteOutput.setContext("li", "data-show-author");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("li", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			var __jte_html_attribute_2 = message.type();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
				jteOutput.setContext("li", "data-message-type");
				jteOutput.writeUserContent(__jte_html_attribute_2);
				jteOutput.setContext("li", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			if (message.type() == Message.Type.DEFAULT) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
				gg.jte.generated.precompiled.discord.ui.JtereferenceGenerated.render(jteOutput, jteHtmlInterceptor, message);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
				if (showAuthor) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
					var __jte_html_attribute_3 = message.author().avatarUrl();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
						jteOutput.setContext("img", "src");
						jteOutput.writeUserContent(__jte_html_attribute_3);
						jteOutput.setContext("img", null);
						jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
					}
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
				} else {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
					jteOutput.setContext("time", null);
					jteOutput.writeUserContent(TimeUtil.formatTimeShort(message.timestamp()));
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
				if (showAuthor) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
					gg.jte.generated.precompiled.discord.message.user.JtenameGenerated.render(jteOutput, jteHtmlInterceptor, message.author());
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
					gg.jte.generated.precompiled.discord.message.user.JtetagGenerated.render(jteOutput, jteHtmlInterceptor, message.author());
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
					gg.jte.generated.precompiled.discord.ui.JtetimestampGenerated.render(jteOutput, jteHtmlInterceptor, message.timestamp());
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
					jteOutput.setContext("time", null);
					jteOutput.writeUserContent(TimeUtil.formatDateShort(message.timestamp()));
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
				gg.jte.generated.precompiled.discord.message.JtecontentGenerated.render(jteOutput, jteHtmlInterceptor, payload.guild(), message, message.content());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_27);
				gg.jte.generated.precompiled.discord.message.JtemessagesnapshotsGenerated.render(jteOutput, jteHtmlInterceptor, payload.guild(), message);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_28);
				if (message.editedTimestamp() != null) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_29);
					gg.jte.generated.precompiled.discord.ui.JtetimestampGenerated.render(jteOutput, jteHtmlInterceptor, message.editedTimestamp());
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_30);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_31);
				gg.jte.generated.precompiled.discord.message.JteaccessoriesGenerated.render(jteOutput, jteHtmlInterceptor, payload, message);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_32);
			} else if (message.type() == Message.Type.THREAD_CREATED) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_33);
				gg.jte.generated.precompiled.discord.ui.JtereferenceGenerated.render(jteOutput, jteHtmlInterceptor, message);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_34);
				gg.jte.generated.precompiled.discord.message.user.JtenameGenerated.render(jteOutput, jteHtmlInterceptor, message.author());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_35);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(message.content());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_36);
				gg.jte.generated.precompiled.discord.ui.JtetimestampGenerated.render(jteOutput, jteHtmlInterceptor, message.timestamp());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_37);
				jteOutput.setContext("time", null);
				jteOutput.writeUserContent(TimeUtil.formatDateShort(message.timestamp()));
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_38);
				gg.jte.generated.precompiled.discord.message.JteaccessoriesGenerated.render(jteOutput, jteHtmlInterceptor, payload, message);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_39);
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(message.content());
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_40);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_41);
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Payload payload = (Payload)params.get("payload");
		Message message = (Message)params.get("message");
		Message previousMessage = (Message)params.get("previousMessage");
		render(jteOutput, jteHtmlInterceptor, payload, message, previousMessage);
	}
}
