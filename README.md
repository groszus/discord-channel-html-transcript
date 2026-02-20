<h1 align="center">discord-html-transcript</h1>

<p align="center">
    <strong>Generate styled archives for your tickets and chats with ease</strong>
</p>

<p align="center">
    <a href="https://central.sonatype.com/artifact/dev.omardiaa/discord-html-transcript"><img alt="Maven Version" src="https://img.shields.io/maven-central/v/dev.omardiaa/discord-html-transcript?label=Maven&color=0055D2"/></a>
    <a href="https://github.com/omardiaadev/discord-html-transcript/blob/main/LICENSE"><img alt="License" src="https://img.shields.io/github/license/omardiaadev/discord-html-transcript?label=License&color=0055D2"/></a>
    <a href="https://discord.gg/fWtQjEJgWX"><img alt="Discord" src="https://img.shields.io/badge/Discord-5865F2?logo=discord&logoColor=FFF&color=5865F2"/></a>
</p>

<details>
    <summary>Contents</summary>
    <ul>
        <li><a href="#features">Features</a></li>
        <li><a href="#preview">Preview</a></li>
        <li><a href="#getting-started">Getting Started</a></li>
        <li><a href="#development">Development</a></li>
    </ul>
</details>

## About

This is the most
**up-to-date** Discord transcript generator, ensuring your archive is consistent with Discord's latest styles!\
You can get a preview for the HTML file [here](https://htmlpreview.github.io/?https://github.com/omardiaadev/discord-html-transcript/blob/main/examples/example-transcript.html).

## Features

- **Beautiful UI:** Modern HTML/CSS that has the look and feel of the Discord desktop client.
- **Asynchronous:** Built with `CompletableFuture` for non-blocking performance.
- **100% Offline:** All styling and fonts are contained in the generated HTML file.

##### Detailed Features

<ul>
    <li>
        <strong>ComponentsV2</strong>
        <img alt="NEW" src="https://img.shields.io/badge/NEW-FF2E2E" height="12"/>
    </li>
    <li><strong>Markdown:</strong> Standard Markup, Mentions, Custom Emojis, and more...</li>
    <li><strong>Message Accessories:</strong> Attachments, Embeds, Reactions, References, and more...</li>
</ul>

##### To-Do

- [ ] Refine Markdown
- [ ] Refactor CSS

> [!NOTE]
> This project is not affiliated with Discord Inc.

## Preview

<a href="https://htmlpreview.github.io/?https://github.com/omardiaadev/discord-html-transcript/blob/main/examples/example-transcript.html">
    <img alt="discord-html-transcript" src="https://res.cloudinary.com/omardiaadev/image/upload/v1771423142/discord-html-transcript_ocjq03.png"/>
</a>

## Getting Started

There are 3 methods you can use this library:

1. [Library](#one-library): suitable for most users.
2. [Installation](#two-installation): suitable for Java developers.
3. [Self-Host](#three-self-host): suitable for any user.

### :one: Library

Refer to the wrapper of choice for your bot.\
The following libraries carefully retrieve the required [Payload](core/src/main/java/dev/omardiaa/transcript/core/model/Payload.java)
with respect to your bot's instance to handle rate limits efficiently.

<table>
    <tr>
        <th></th>
        <th>Discord Wrapper</th>
        <th>Library</th>
    </tr>
    <tr align="center">
        <td><img alt="JDA" src="https://avatars.githubusercontent.com/u/103134607" height="48" /></td>
        <td><strong>Java Discord API</strong></td>
        <td><a href="https://github.com/omardiaadev/discord-html-transcript-jda">discord-html-transcript-jda</a></td>
    </tr>
    <tr align="center">
        <td><img alt="Discord.js" src="https://avatars.githubusercontent.com/u/26492485" height="48" /></td>
        <td><strong>Discord.js</strong></td>
        <td><code>WIP</code></td>
    </tr>
    <tr align="center">
        <td><img alt="Discord.py" src="https://discordpy.readthedocs.io/en/stable/_static/discord_py_logo.ico" height="48" /></td>
        <td><strong>Discord.py</strong></td>
        <td><code>WIP</code></td>
    </tr>
</table>

### :two: Installation

You can include the following to directly implement the package in your bot.

##### Requirements

- **Java 17+**

```xml

<dependency>
  <groupId>dev.omardiaa</groupId>
  <artifactId>discord-html-transcript-core</artifactId>
  <version>0.1.0-beta.1</version>
</dependency>
```

```kts

implementation("dev.omardiaa:discord-html-transcript-core:0.1.0-beta.1")
```

### :three: Self-Host

You can [download](https://github.com/omardiaadev/discord-html-transcript/releases) the suitable executable for the
`discord-html-transcript-server` module.

Further instructions are to be documented

## Development

- Documentation WIP.

## 🌟 Support The Project

If you found this useful, please consider giving it a 🌟!

<a href="https://fiverr.com/skywolfxp"><img alt="Fiverr" src="https://img.shields.io/badge/-1DBF73?style=for-the-badge&logo=fiverr&logoColor=FFF&logoSize=auto"/></a>
<a href="https://ko-fi.com/omardiaadev"><img alt="Ko-fi" src="https://img.shields.io/badge/ko--fi-FF6433?style=for-the-badge&logo=kofi&logoColor=FFF"/></a>
