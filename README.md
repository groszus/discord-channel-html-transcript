<h1 align="center">discord-html-transcript</h1>

<p align="center">
    <strong>Generate natively styled logs for your Discord chats</strong>
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

## Features

- **Beautiful UI:** Modern HTML/CSS that has the look and feel of the Discord desktop client.
- **Asynchronous:** Built with `CompletableFuture` for non-blocking performance.
- **100% Offline:** All styling and fonts are contained in the generated HTML file.

##### Supported Components

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

There are 3 ways you can use this library:

1. [Library](#one-library-recommended): recommended for most users.
2. [Installation](#two-installation): for Java developers.
3. [Standalone API](#three-standalone-api): for non-Java developers.

### :one: Library (Recommended)

The following libraries retrieve the required [Payload](core/src/main/java/dev/omardiaa/transcript/core/model/Payload.java)
with respect to your bot's instance to handle rate limits efficiently.

Choose the library that corresponds with the Discord API you use.


<table>
    <tr>
        <th>Discord API</th>
        <th>Library</th>
    </tr>
    <tr align="center">
        <td>
            <img alt="JDA" src="https://avatars.githubusercontent.com/u/103134607" height="64" />
            <p>Java Discord API</p>
        </td>
        <td><a href="https://github.com/omardiaadev/discord-html-transcript-jda">discord-html-transcript-jda</a></td>
    </tr>
    <tr align="center">
        <td>
            <img alt="discord.js" src="https://avatars.githubusercontent.com/u/26492485" height="64" />
            <p>discord.js</p>
        </td>
        <td><code>WIP</code></td>
    </tr>
    <tr align="center">
        <td>
            <img alt="discord.py" src="https://discordpy.readthedocs.io/en/latest/_static/discord_py_logo.ico" height="64" />
            <p>discord.py</p>
        </td>
        <td><code>WIP</code></td>
    </tr>
</table>

### :two: Installation

You can install the core implementation as a Maven dependency:

#### Prerequisites

- Java 17+

<a href="#two-installation"><img alt="Maven" src="https://img.shields.io/badge/Maven-C71A36?logo=apachemaven"></a>

```xml

<dependency>
  <groupId>dev.omardiaa</groupId>
  <artifactId>discord-html-transcript-core</artifactId>
  <version>0.1.0-beta.2</version>
</dependency>
```

<a href="#two-installation"><img alt="Gradle" src="https://img.shields.io/badge/Gradle-02303A?logo=gradle"></a>

```kts

implementation("dev.omardiaa:discord-html-transcript-core:0.1.0-beta.2")
```

### :three: Standalone API

> [!NOTE]
> This section of the documentation is incomplete.

You can [download the latest release](https://github.com/omardiaadev/discord-html-transcript/releases) and self-host the executable as a standalone service.

#### Configuration

##### Environment Variables

<table>
    <tr>
        <th>Variable</th>
        <th>Default</th>
    </tr>
    <tr align="center">
        <td>
            <code>TRANSCRIPT_SERVER_HOST</code>
            <p>Specifies a custom host for the Javalin web server.</p>
        </td>
        <td><code>127.0.0.1</code></td>
    </tr>
    <tr align="center">
        <td>
            <code>TRANSCRIPT_SERVER_PORT</code>
            <p>Specifies a custom port for the Javalin web server.</p>
        </td>
        <td><code>7000</code></td>
    </tr>
    <tr align="center">
        <td>
            <code>TRANSCRIPT_SERVER_API_KEY</code>
            <p>Specifies an API key to validate on client requests.</p>
        </td>
        <td><code>-</code></td>
    </tr>
</table>

## Development

> [!NOTE]
> This section of the documentation is incomplete.

### Configuration

#### Environment Variables

In addition to the previous [variables](#environment-variables), you can specify the following during development:

<table>
    <tr>
        <th>Variable</th>
        <th>Default</th>
    </tr>
    <tr align="center">
        <td>
            <code>JTE_DEV</code>
            <p>Allows you to compile templates to Java classes on demand.</p>
        </td>
        <td><code>false</code></td>
    </tr>
</table>

## 🌟 Support The Project

If you found this useful, please consider giving it a 🌟!

<a href="https://fiverr.com/skywolfxp"><img alt="Fiverr" src="https://img.shields.io/badge/-1DBF73?style=for-the-badge&logo=fiverr&logoColor=FFF&logoSize=auto"/></a>
<a href="https://ko-fi.com/omardiaadev"><img alt="Ko-fi" src="https://img.shields.io/badge/ko--fi-FF6433?style=for-the-badge&logo=kofi&logoColor=FFF"/></a>
