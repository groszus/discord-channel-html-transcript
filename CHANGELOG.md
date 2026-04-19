# Changelog

## [0.1.0-beta.6] (Unreleased)

### discord-html-transcript-core

- Support for threads.

### discord-html-transcript-server

## [0.1.0-beta.5]

#### Changed

- Use GraalVM 25 instead of GraalVM 17.

### discord-html-transcript-core

- Support for optional payload options.
- Support for downloading and encoding attachments into the transcript file.
- Extend embed support for types `link` and `article`.

### discord-html-transcript-server

#### Changed

- Replace maven resource filtering with templating-maven-plugin resource filtering for setting server version.

## [0.1.0-beta.4]

### discord-html-transcript-core

#### Added

- Support for Block Quote markdown.
- Support for Message Poll.

#### Changed

- Bump jackson from 2.21.1 to 2.21.2.
- Update all payload models from POJOs to Records.

#### Fixed

- Prevent `IllegalArgumentException` when parsing user or role mentions' names contain `$`.
- Parse normal links.

### discord-html-transcript-server

#### Changed

- Bump javalin from 7.0.1 to 7.1.0.

#### Fixed

- Include missing reachability metadata for error responses.
- Include missing exit handlers.

## [0.1.0-beta.3]

### discord-html-transcript-core

#### Changed

- Update runtime data validation.

### discord-html-transcript-server

#### Added

- Add `TRANSCRIPT_SERVER_API_KEY` environment variable for authentication.

#### Changed

- Bump Javalin to `7.0.1`.

## [0.1.0-beta.2]

### discord-html-transcript-server

#### Fixed

- Fix native image missing reachability metadata.

#### Changed

- Compute asynchronous operations on their own dedicated thread pool instead of common thread pool.
- Update Javalin server logic to its own singleton class.
- Update environment variable names to avoid clashing with other variables.

## [0.1.0-beta.1]

### discord-html-transcript-core

#### Added

- Support for `@everyone` and `@here` markdown parsing.
- Support for `File` component.
- Support for "Custom Emoji" markdown.
- Support for Embed "GIFV" type.
- Support for Channel "Topic".

#### Changed

- **Relocate maven ArtifactID from `discord-channel-html-transcript` to `discord-html-transcript`.**
- Base64 encode font instead of loading it with jsdelivr.

#### Fixed

- Fix Header and Subtext markdown parsing.
