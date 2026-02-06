# Changelog

## [v0.1.0-beta.1]

### Added

- Add `@everyone` and `@here` markdown parsing.
- Add `File` component.
- Add support for "Custom Emoji" markdown.
- Add support for Embed "GIFV" type.
- Add support for Channel "Topic".

### Changed

- **Relocate maven ArtifactID from `discord-channel-html-transcript` to `discord-html-transcript`.**
- Change to Apache License to increase adoption.

### Fixed

- Fix Header and Subtext markdown parsing.

## [v4.0.0]

### Changed

- **Migrate maven GroupID from `dev.skywolfxp` to `dev.omardiaa`.**
- Add Discord Components V2.
- Add message formatting inside embeds.
- Add `style.css` to test resources for modification during testing.
- Update the Trancript to be returned in a CompletableFuture.

### Fixed

- Fix handling of the generated tanscript output.

## [v3.0.0]

### Changed

- Remove the ability to construct Transcript with a custom TemplateEngine.

### Fixed

- Fix NPE when loading JTE precompiled classes ([#1](https://github.com/omardiaadev/discord-channel-html-transcript/issues/1))

## [v2.0.0]

### Changed

- **Migrate the maven GroupID from `io.github.skywolfxp` to `dev.skywolfxp`.**
- Update footer styling.

## [v1.1.1]

### Changed

- Replace Google's "DM sans" font with Discord's "gg sans" font.
- Update footer styling.

## [v1.1.0]

### Changed

- Update HTML and CSS to match Discord's new 2025 interface.

### Fixed

- Fix Discord markdown parsing only the first matched mention.
- Fix role mention background and foreground colors.
