<h1 align="center">discord-html-transcript</h1>

<p align="center">
    <strong>A Discord Java library and microservice to generate the perfect transcripts for your chats</strong>
</p>

<p align="center">
    <a href="https://central.sonatype.com/artifact/dev.omardiaa/discord-html-transcript"><img alt="Maven Version" src="https://img.shields.io/maven-central/v/dev.omardiaa/discord-html-transcript?label=Maven&color=0055D2&labelColor=0055D2"/></a>
    <a href="https://github.com/omardiaadev/discord-html-transcript/blob/main/LICENSE"><img alt="License" src="https://img.shields.io/github/license/omardiaadev/discord-html-transcript?label=License&color=0055D2&labelColor=0055D2"/></a>
</p>

## About

This is the most
**up-to-date** Discord transcript generator, ensuring your archive is consistent with Discord's latest styles!\
You can get a preview for the HTML file [here](https://htmlpreview.github.io/?https://github.com/omardiaadev/discord-html-transcript/blob/main/examples/example-transcript.html).

<details>
    <summary>
        <strong>Contents</strong>
    </summary>
    <ul>
        <li><a href="#notice">Notice</a></li>
        <li><a href="#features">Features</a></li>
        <li><a href="#how-to-use">How To Use</a></li>
        <li><a href="#development">Development</a></li>
    </ul>
</details>

## Notice

> [!NOTE]
> This project is not affiliated with Discord Inc.

## Features

<ul>
    <li>
        <strong>ComponentsV2</strong>
        <img alt="NEW" src="https://img.shields.io/badge/NEW-FF2E2E" height="12"/>
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
        <li>Article Embeds</li>
        <li>Add List Markdown</li>
        <li>Add Quote Markdown</li>
        <li>Refactor CSS</li>
    </ul>
</ul>

## How To Use

There are 3 ways you can use this library:

### Installation

##### Requirements

- **Java 21+**

```xml

<dependency>
  <groupId>dev.omardiaa</groupId>
  <artifactId>discord-html-transcript-core</artifactId>
  <version>0.1.0-beta-1</version>
</dependency>
```

```kts

implementation("dev.omardiaa:discord-html-transcript-core:0.1.0-beta-1")
```

### Library

The following libraries carefully retrieve the required [Payload](core/src/main/java/dev/omardiaa/transcript/core/model/Payload.java)
with respect to your bot's instance to handle Discord's rate limiter.

<table>
    <tr>
        <th>Framework</th>
        <th>Library</th>
    </tr>
    <tr>
        <td>
            <img alt="JDA" src="https://avatars.githubusercontent.com/u/103134607" height="12" />
            <strong>Java Discord API</strong>
        </td>
        <td><a href="https://github.com/omardiaadev/discord-html-transcript-jda">discord-html-transcript-jda</a></td>
    </tr>
    <tr>
        <td>
            <img alt="Discord.js" src="https://avatars.githubusercontent.com/u/26492485" height="12" />
            <strong>Discord.js</strong>
        </td>
        <td>WIP</td>
    </tr>
    <tr>
        <td>
            <img alt="Discord.py" src="https://discordpy.readthedocs.io/en/stable/_static/discord_py_logo.ico" height="12" />
            <strong>Discord.py</strong>
        </td>
        <td>WIP</td>
    </tr>
</table>

### Self-Hosting

- WIP

## Development

- Pass
  `stylePath` to [Payload](core/src/main/java/dev/omardiaa/transcript/core/model/Payload.java) for live CSS updates during development.

## Enjoying The Package? Give it A Star!

<a href="https://fiverr.com/skywolfxp"><img alt="Fiverr" src="https://img.shields.io/badge/-1DBF73?style=for-the-badge&logo=fiverr&logoColor=FFF&logoSize=auto"/></a>
<a href="https://discord.gg/fWtQjEJgWX"><img alt="Discord" src="https://img.shields.io/discord/1055244032105787472?style=for-the-badge&logo=discord&logoColor=FFF&logoSize=auto&label=%20&color=5865F2"/></a>
