<h1 align="center">discord-html-transcript</h1>

<p align="center"><strong>Generate natively styled Discord chat logs</strong></p>

<p align="center">
    <a href="https://central.sonatype.com/artifact/dev.omardiaa/discord-html-transcript"><img alt="Maven Version" src="https://img.shields.io/maven-central/v/dev.omardiaa/discord-html-transcript?label=Maven&color=0055D2"></a>
    <a href="https://github.com/omardiaadev/discord-html-transcript/blob/main/LICENSE"><img alt="License" src="https://img.shields.io/github/license/omardiaadev/discord-html-transcript?label=License&color=0055D2"></a>
    <a href="https://discord.omardiaa.dev"><img alt="Discord" src="https://img.shields.io/badge/Discord-5865F2?logo=discord&logoColor=FFF&color=5865F2"></a>
</p>

<details>
    <summary>Table of Contents</summary>
    <ul>
        <li><a href="#features">Features</a></li>
        <li><a href="#preview">Preview</a></li>
        <li><a href="#usage">Usage</a></li>
        <li><a href="#contributing">Contributing</a></li>
    </ul>
</details>

## Features

- **Beautiful UI:** Modern HTML/CSS that has the look and feel of the Discord desktop client.
- **Asynchronous:** Built with `CompletableFuture` for non-blocking performance.
- **100% Offline:** All styling and fonts are contained in the generated HTML file.

**Supported Components**

<ul>
    <li>
        <strong>ComponentsV2</strong>
        <img alt="NEW" src="https://img.shields.io/badge/NEW-FF2E2E" height="12">
    </li>
    <li><strong>Markdown:</strong> Standard Markup, Mentions, Custom Emojis, and more...</li>
    <li><strong>Message Accessories:</strong> Attachments, Embeds, Polls, References, and more...</li>
</ul>

> [!IMPORTANT]
> This project is not affiliated with Discord Inc.

## Preview

<a title="Click For Full Preview" href="https://htmlpreview.github.io/?https://github.com/omardiaadev/discord-html-transcript/blob/main/examples/transcript.html">
    <img alt="Preview" src="https://res.cloudinary.com/omardiaadev/image/upload/discord-html-transcript_ocjq03.png">
</a>

## Usage

There are 3 ways to use this library:

1. [**Library**](#1-library-recommended): recommended for most users.
2. [**Installation**](#2-installation): for custom Java implementations.
3. [**Standalone API**](#3-standalone-api): for non-Java developers.

### 1. Library (Recommended)

The following libraries retrieve the required [Payload](core/src/main/java/dev/omardiaa/transcript/core/model/Payload.java)
while safely handling Discord's rate limits.

Pick the library of choice:

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
        <td><a href="https://github.com/omardiaadev/discord-html-transcript-discordjs">discord-html-transcript-discordjs</a></td>
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

- **Java 17+**

[![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven)](#2-installation)

```xml

<dependency>
  <groupId>dev.omardiaa</groupId>
  <artifactId>discord-html-transcript-core</artifactId>
  <version>0.1.0-beta.5</version>
</dependency>
```

[![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle)](#2-installation)

```kts

implementation("dev.omardiaa:discord-html-transcript-core:0.1.0-beta.5")
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
            Authenticates client requests.
            <br>
            Required if <code>TRANSCRIPT_SERVER_API_KEY</code> is set.
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
            Accepts a transcript Payload and asynchronously generates an HTML byte stream.
        </td>
    </tr>
</table>

##### Versioning

The server validates the [`Server-Version`](#headers) header using the following rules:

- Pre-release versions must match exactly.
- Major versions must match exactly.
- Server minor version must be greater than or equal to the `Server-Version` minor version.

> [!TIP]
> HTTP request examples can be found at [requests](examples/requests.http).

##### Payload

You can specify the `options` object in your payload to specify transcript options:

```json5
{
  "options": {
    "attachment": {
      // If set to "true", attachments referenced in the payload will be downloaded and encoded into a Base64 Data URI
      // default: false
      "save_images": true
    },
    "style": {
      // If set, the custom style.css will be used instead of the inline styles.
      // default: null
      "path": "path/to/style.css"
    }
  }
}
```

## Contributing

**If you found `discord-html-transcript` useful, please consider giving it a 🌟!**

Need help? [Ask the Community](https://discord.omardiaa.dev)!

<div align="center">
    <p>Made With ❤️ By <a href="https://github.com/omardiaadev"><b>Omar Diaa</b></a></p>
    <a href="https://fiverr.com/skywolfxp"><img alt="Fiverr" src="https://img.shields.io/badge/-1DBF73?style=for-the-badge&logo=fiverr&logoColor=FFF&logoSize=auto"></a>
    <a href="https://ko-fi.com/omardiaadev"><img alt="Ko-fi" src="https://img.shields.io/badge/ko--fi-FF6433?style=for-the-badge&logo=kofi&logoColor=FFF"></a>
</div>
