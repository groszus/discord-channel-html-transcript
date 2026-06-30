package gg.jte.generated.precompiled.discord.message.accessory;
import dev.omardiaa.transcript.core.util.TimeUtil;
import dev.omardiaa.transcript.core.model.payload.message.Poll;
@SuppressWarnings("unchecked")
@javax.annotation.processing.Generated("gg.jte.TemplateEngine")
public final class JtepollGenerated {
	public static final String JTE_NAME = "discord/message/accessory/poll.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,5,5,9,9,9,10,10,10,14,14,16,16,17,17,18,18,20,20,20,32,32,37,37,37,40,40,40,43,43,43,3,3,3,3};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtepollGenerated.class, "JtepollGenerated.bin", 2,89,46,51,31,6,2,39,425,89,110,27);
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
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Poll poll) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
		jteOutput.setContext("h4", null);
		jteOutput.writeUserContent(poll.question().text());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(poll.allowMultiselect() ? "Select one or more answers" : "Select one answer");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		for (Poll.Answer answer : poll.answers()) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
			if (answer.pollMedia().emoji() != null) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				gg.jte.generated.precompiled.util.JteemojiGenerated.render(jteOutput, jteHtmlInterceptor, answer.pollMedia().emoji(), "poll__answer__emoji");
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(answer.pollMedia().text());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(poll.results() != null ? poll.results().answerCounts().stream().mapToInt(Poll.AnswerCount::count).sum() + " votes" : "0 votes");
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
		jteOutput.setContext("time", null);
		jteOutput.writeUserContent(TimeUtil.formatDateShort(poll.expiry()));
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Poll poll = (Poll)params.get("poll");
		render(jteOutput, jteHtmlInterceptor, poll);
	}
}
