<h1 align="center">discord-html-transcript</h1>

<p align="center"><strong>Generate natively styled logs for your Discord chats</strong></p>

<p align="center">
    <a href="https://central.sonatype.com/artifact/dev.omardiaa/discord-html-transcript"><img alt="Maven Version" src="https://img.shields.io/maven-central/v/dev.omardiaa/discord-html-transcript?label=Maven&color=0055D2"></a>
    <a href="https://github.com/omardiaadev/discord-html-transcript/blob/main/LICENSE"><img alt="License" src="https://img.shields.io/github/license/omardiaadev/discord-html-transcript?label=License&color=0055D2"></a>
    <a href="https://discord.gg/fWtQjEJgWX"><img alt="Discord" src="https://img.shields.io/badge/Discord-5865F2?logo=discord&logoColor=FFF&color=5865F2"></a>
</p>

<details>
    <summary>Contents</summary>
    <ul>
        <li><a href="#features">Features</a></li>
        <li><a href="#preview">Preview</a></li>
        <li>
            <a href="#getting-started">Getting Started</a>
            <ul>
                <li><a href="#1-library-recommended">1. Library (Recommended)</a></li>
                <li><a href="#2-installation">2. Installation</a></li>
                <li><a href="#3-standalone-api">3. Standalone API</a></li>
            </ul>
        </li>
        <li><a href="#development">Development</a></li>
        <li><a href="#support">Support</a></li>
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
        <img alt="NEW" src="https://img.shields.io/badge/NEW-FF2E2E" height="12">
    </li>
    <li><strong>Markdown:</strong> Standard Markup, Mentions, Custom Emojis, and more...</li>
    <li><strong>Message Accessories:</strong> Attachments, Embeds, Reactions, References, and more...</li>
</ul>

##### To-Do

- [ ] Refactor CSS and Markdown.

> [!IMPORTANT]
> This project is not affiliated with Discord Inc.

## Preview

<a href="https://htmlpreview.github.io/?https://github.com/omardiaadev/discord-html-transcript/blob/main/examples/example-transcript.html">
    <img alt="discord-html-transcript" src="https://res.cloudinary.com/omardiaadev/image/upload/v1771423142/discord-html-transcript_ocjq03.png">
</a>

## Getting Started

There are 3 ways to use this library:

1. [**Library**](#1-library-recommended): recommended for most users.
2. [**Installation**](#2-installation): for custom Java implementations.
3. [**Standalone API**](#3-standalone-api): for non-Java developers.

### 1. Library (Recommended)

The following libraries automatically retrieve the required [Payload](core/src/main/java/dev/omardiaa/transcript/core/model/Payload.java)
while safely handling Discord's rate limits.

Choose the library that corresponds with the Discord API you use:

<table>
    <tr>
        <th>Discord API</th>
        <th>Library</th>
    </tr>
    <tr align="center">
        <td>
            <img alt="JDA" src="https://avatars.githubusercontent.com/u/103134607" height="64">
            <p>Java Discord API</p>
        </td>
        <td><a href="https://github.com/omardiaadev/discord-html-transcript-jda">discord-html-transcript-jda</a></td>
    </tr>
    <tr align="center">
        <td>
            <img alt="discord.js" src="https://avatars.githubusercontent.com/u/26492485" height="64">
            <p>discord.js</p>
        </td>
        <td><code>WIP</code></td>
    </tr>
    <tr align="center">
        <td>
            <img alt="discord.py" src="https://discordpy.readthedocs.io/en/latest/_static/discord_py_logo.ico" height="64">
            <p>discord.py</p>
        </td>
        <td><code>WIP</code></td>
    </tr>
</table>

### 2. Installation

You can install the core implementation as a Maven dependency:

#### Prerequisites

- Java 17+

[![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven)](#2-installation)

```xml

<dependency>
  <groupId>dev.omardiaa</groupId>
  <artifactId>discord-html-transcript-core</artifactId>
  <version>0.1.0-beta.2</version>
</dependency>
```

[![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle)](#2-installation)

```kts

implementation("dev.omardiaa:discord-html-transcript-core:0.1.0-beta.2")
```

### 3. Standalone API

> [!NOTE]
> This section of the documentation is incomplete.

You can [download](https://github.com/omardiaadev/discord-html-transcript/releases) and run the executable as a
standalone web server.

#### Configuration

##### Environment Variables

<table>
    <tr>
        <th>Variable</th>
        <th>Description</th>
    </tr>
    <tr>
        <td><code>TRANSCRIPT_SERVER_HOST</code></td>
        <td>Specifies custom host for the Javalin web server.<br>(default: <code>127.0.0.1</code>)</td>
    </tr>
    <tr>
        <td><code>TRANSCRIPT_SERVER_PORT</code></td>
        <td>Specifies custom port for the Javalin web server.<br>(default: <code>7000</code>)</td>
    </tr>
    <tr>
        <td><code>TRANSCRIPT_SERVER_API_KEY</code></td>
        <td>Specifies secret key for authenticating client requests.</td>
    </tr>
</table>

#### Usage

##### Headers

<table>
    <tr>
        <th>Header</th>
        <th>Description</th>
    </tr>
    <tr>
        <td><code>Server-Version</code></td>
        <td>
            Validates the server version required by the client to ensure compatibility.
            <br>
            Required.
        </td>
    </tr>
    <tr>
        <td><code>Authorization</code></td>
        <td>
            Authenticates the client's request using the server's API key.
            <br>
            Required, if <code>TRANSCRIPT_SERVER_API_KEY</code> is set.
        </td>
    </tr>
</table>

##### Endpoints

<table>
    <tr>
        <th>Endpoint</th>
        <th>Description</th>
    </tr>
    <tr>
        <td><code>GET /health</code></td>
        <td>Retrieves basic server information.</td>
    </tr>
    <tr>
        <td><code>POST /transcript</code></td>
        <td>
            Accepts a transcript <a href="core/src/main/java/dev/omardiaa/transcript/core/model/Payload.java">Payload</a>
            and asynchronously generates an HTML byte stream.
        </td>
    </tr>
</table>

##### Versioning

The server validates the `Server-Version` header on every request using the following rules:

- Pre-release versions must match exactly.
- Major versions must match exactly.
- Server minor version must be greater than or equal to the `Server-Version` minor version.

> [!TIP]
> Refer to [transcript.http](examples/transcript.http) to see an example of the HTTP requests.

## Development

> [!NOTE]
> This section of the documentation is incomplete.

### Configuration

#### Environment Variables

In addition to the previous [variables](#environment-variables), you can specify the following during development:

<table>
    <tr>
        <th>Variable</th>
        <th>Description</th>
    </tr>
    <tr>
        <td><code>JTE_DEV</code></td>
        <td>Allows you to compile templates to Java classes on demand.</td>
    </tr>
</table>

## Support

If you found this useful, please consider giving it a 🌟!

<a href="https://fiverr.com/skywolfxp"><img alt="Fiverr" src="https://img.shields.io/badge/-1DBF73?style=for-the-badge&logo=fiverr&logoColor=FFF&logoSize=auto"/></a>
<a href="https://ko-fi.com/omardiaadev"><img alt="Ko-fi" src="https://img.shields.io/badge/ko--fi-FF6433?style=for-the-badge&logo=kofi&logoColor=FFF"/></a>
