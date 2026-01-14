<h1 align="center">discord-html-transcript-api</h1>

<p align="center"><strong>Discord HTML transcript generator that preserves your favorite Discord styles</strong></p>

<p align="center">
    <a href="https://central.sonatype.com/artifact/dev.omardiaa/discord-channel-html-transcript"><img alt="Maven Version" src="https://img.shields.io/maven-central/v/dev.omardiaa/discord-channel-html-transcript?label=Maven&color=0055D2&labelColor=0055D2"/></a>
    <a href="https://github.com/omardiaadev/discord-channel-html-transcript/blob/main/LICENSE"><img alt="License" src="https://img.shields.io/github/license/omardiaadev/discord-channel-html-transcript?label=License&color=0055D2&labelColor=0055D2"/></a>
</p>

## About

This is the most
**up-to-date** Discord transcript generator, ensuring your archive is consistent with Discord's new styles!\
You can get a preview for the HTML file [here](https://htmlpreview.github.io/?https://github.com/omardiaadev/discord-channel-html-transcript/blob/60ab0f8c62798f1678917518fe211e2e629bc8ef/examples/transcript.example.html).

**Uses:**

- [**Javalin**](https://github.com/javalin/javalin) to start a server that accepts a payload of Discord messages.
- [**Java Template Engine**](https://github.com/casid/jte/) to generate the HTML transcript.

<details>
    <summary>
        <strong>Contents</strong>
    </summary>
    <ul>
        <li><a href="#legal-compliance">Legal Compliance</a></li>
        <li><a href="#features">Features</a></li>
        <li><a href="#preview">Preview</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#development">Development</a></li>
    </ul>
</details>

## Legal Compliance

> [!NOTE]
> This project utilizes the [gg sans](src/main/resources/font/ggsansvf.woff) font that is the property of Discord Inc.

## Features

<ul>
    <li>
        <strong>ComponentsV2</strong>
        <img src="https://img.shields.io/badge/NEW-FF2E2E" alt="NEW" height="12"/>
    </li>
    <li><strong>Markdown:</strong> Standard Markup, Mentions, Custom Emojis, and more...</li>
    <li><strong>Attachments</strong></li>
    <li><strong>Embeds</strong></li>
    <li><strong>Reactions</strong></li>
    <li><strong>References:</strong> Messages and Interactions</li>
</ul>

<ul>
    <li><strong>To-Do:</strong></li>
    <ul>
        <li>Cleanup CSS</li>
        <li>Add List Markdown</li>
    </ul>
</ul>

## Installation

##### Requirements

- **Java 21+**

##### Usage

```xml

<dependency>
  <groupId>dev.omardiaa</groupId>
  <artifactId>discord-channel-html-transcript</artifactId>
  <version>4.0.0</version>
</dependency>
```

```kts

implementation("dev.omardiaa:discord-channel-html-transcript:4.0.0")
```

## Development

1. Run [TranscriberTest#transcribe()](src/test/java/dev/omardiaa/transcript/TranscriberTest.java), an HTML file will appear in:
    - **Windows:** `%TEMP%\discord-channel-html-transcript\transcript.html`
    - **macOS:** `/tmp/discord-channel-html-transcript/transcript.html`
    - **Linux:** `/tmp/discord-channel-html-transcript/transcript.html`

- Pass
  `testStylePath` to [Payload](src/main/java/dev/omardiaa/transcript/schema/Payload.java) for live CSS updates during development.

## Enjoying My Work? Give it A Star!

<a href="https://fiverr.com/skywolfxp"><img alt="Fiverr" src="https://img.shields.io/badge/-1DBF73?style=for-the-badge&logo=fiverr&logoColor=FFF&logoSize=auto"/></a>
<a href="https://reddit.com/user/omardiaadev"><img alt="Reddit" src="https://img.shields.io/badge/Reddit-FF4500?style=for-the-badge&logo=reddit&logoColor=FFF&logoSize=auto"/></a>
<a href="https://discord.gg/fWtQjEJgWX"><img alt="Discord" src="https://img.shields.io/discord/1055244032105787472?style=for-the-badge&logo=discord&logoColor=FFF&logoSize=auto&label=%20&color=5865F2"/></a>
