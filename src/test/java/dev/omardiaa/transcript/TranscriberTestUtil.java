package dev.omardiaa.transcript;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.omardiaa.transcript.schema.Payload;
import dev.omardiaa.transcript.schema.payload.Channel;
import dev.omardiaa.transcript.schema.payload.Guild;
import dev.omardiaa.transcript.schema.payload.Message;
import dev.omardiaa.transcript.schema.payload.User;
import dev.omardiaa.transcript.schema.payload.message.Attachment;
import dev.omardiaa.transcript.schema.payload.message.Embed;
import dev.omardiaa.transcript.schema.payload.message.component.*;
import dev.omardiaa.transcript.schema.payload.util.Emoji;
import dev.omardiaa.transcript.schema.payload.util.UnfurledMediaItem;
import org.jspecify.annotations.NullMarked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@NullMarked
class TranscriberTestUtil {
  static final String AVATAR_URL_USER = "https://avatars.githubusercontent.com/u/70555240";
  static final User AUTHOR_1 =
    new User("974748803305455627", "omardiaadev", "0", "Omar", "55cecf807bd4b0d702ea8b8376d48f55", false, false);
  static final User AUTHOR_2 =
    new User("1093684128437764136", "VORTEX", "6969", "VORTEX", "3b2cb4620d02fbcae500a447d0c14de9", false, false);
  static final String TIME = "2030-02-20T00:00:00Z";

  static Payload createPayload() throws JsonProcessingException {
    Payload payload = new Payload(
      new Guild(
        "1055244032105787472",
        "Discord Channel HTML Transcript",
        "3c970034e345f0f833b0d010f10a3be7",
        new ArrayList<>()),
      new Channel("1371192695279849504", 0, "discord-channel-html-transcript"),
      TranscriberTestUtil.createMessages());

    String s = new ObjectMapper()
      .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
      .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
      .registerModules(new JavaTimeModule())
      .writerWithDefaultPrettyPrinter()
      .writeValueAsString(payload);

    System.out.println(s);

    return payload;
  }

  static List<Message> createMessages() {
    Message message = new Message(
      String.valueOf(new Random().nextLong(100000000000000000L, 999999999999999999L)),
      AUTHOR_1, "", TIME, TIME, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(),
      null, 1 << 15, null, null, createComponentsV2());

    return List.of(
      message,

      new Message(
        String.valueOf(new Random().nextLong(100000000000000000L, 999999999999999999L)),
        AUTHOR_2, "", TIME, null, Collections.emptyList(), Collections.emptyList(), List.of(createMessageEmbed()),
        null, null, message, null, new ArrayList<>(createComponentsV1())),

      new Message(
        String.valueOf(new Random().nextLong(100000000000000000L, 999999999999999999L)),
        AUTHOR_2, "", TIME, null, Collections.emptyList(),
        List.of(
          new Attachment("image.png", "png", 420, AVATAR_URL_USER),
          new Attachment("file.txt", "txt", 420, AVATAR_URL_USER)), Collections.emptyList(),
        List.of(
          new Message.Reaction(69, new Emoji.Unicode("⭐")),
          new Message.Reaction(69, new Emoji.Custom("1364983213554008146", "catDance"))),
        null, null, new Message.InteractionMetadata(2, AUTHOR_1), null));
  }

  static Embed createMessageEmbed() {
    return new Embed(
      "Title",
      "rich",
      "Description",
      "https://github.com/omardiaadev",
      TIME,
      21712,
      new Embed.Footer("Footer", AVATAR_URL_USER),
      new Embed.Image(AVATAR_URL_USER),
      new Embed.Thumbnail(AVATAR_URL_USER),
      new Embed.Author("Author Name", "https://github.com/omardiaadev", AVATAR_URL_USER),
      List.of(
        new Embed.Field("#1 Field Name", "#1 Field Value", true),
        new Embed.Field("", "", true),
        new Embed.Field("#1 Field Name", "#1 Field Value", true)));
  }

  static List<Button> createButtons() {
    return List.of(
      new Button(2, ButtonStyle.PRIMARY.getValue(), "All", null, null),
      new Button(2, ButtonStyle.SECONDARY.getValue(), "Button", null, null),
      new Button(2, ButtonStyle.SUCCESS.getValue(), "Variants", null, null),
      new Button(2, ButtonStyle.DANGER.getValue(), "Displayed", null, null),
      new Button(
        2, ButtonStyle.LINK.getValue(), "Star The Project",
        new Emoji.Unicode("⭐"), "https://github.com/omardiaadev/discord-channel-html-transcript"));
  }

  static List<ActionRow> createComponentsV1() {
    List<Button> buttons = createButtons();

    List<Button> buttonsDisabled = List.of(
      new Button(2, ButtonStyle.PRIMARY.getValue(), "All", null, null, true),
      new Button(2, ButtonStyle.SECONDARY.getValue(), "Button", null, null, true),
      new Button(2, ButtonStyle.SUCCESS.getValue(), "Variants", null, null, true),
      new Button(2, ButtonStyle.DANGER.getValue(), "Displayed", null, null, true),
      new Button(
        2, ButtonStyle.LINK.getValue(), "Star The Project",
        new Emoji.Unicode("⭐"), "https://github.com/omardiaadev/discord-channel-html-transcript", true));

    SelectMenu selectMenu = new SelectMenu(3, null);

    return List.of(
      new ActionRow(1, buttons),
      new ActionRow(1, buttonsDisabled),
      new ActionRow(1, List.of(selectMenu)));
  }

  static List<Component> createComponentsV2() {
    return List.of(
      new Container(
        17, List.of(
        new TextDisplay(10, "# ComponentsV2 Are Here"),

        new Separator(14, true, 2),

        new Section(
          9,
          List.of(new TextDisplay(
            10,
            """
            # Big Header
            ## Medium Header
            ### Small Header
            
            `System.out.println("discord-channel-html-transcript");`
            ```
            public static void main(String args[]) {
                System.out.println("Hello World!");
            }
            ```
            
            **Users:** <@974748803305455627> <@545902760453996546>
            **Roles:** <@&420> <@&0>
            **Channels:** <#420> <#0>
            -# Subtext
            """)),
          new Button(2, ButtonStyle.LINK.getValue(), "Link", null, "https://github.com/omardiaadev")),

        new Separator(14, true, 2),

        new Section(
          9,
          List.of(new TextDisplay(
            10,
            "**This** [Library](https://github.com/omardiaadev/discord-channel-html-transcript) __is__ *Awesome!*")),
          new Thumbnail(11, new UnfurledMediaItem(AVATAR_URL_USER))),

        new Separator(14, true, 2),

        new ActionRow(1, createButtons()))),

      new Container(
        17, List.of(
        new TextDisplay(10, "# Dynamic Media Gallery"),

        new Separator(14, true, 1),

        new MediaGallery(
          12, Collections.nCopies(3, new MediaGalleryItem(new UnfurledMediaItem(AVATAR_URL_USER)))))));
  }
}
