package dev.omardiaa.transcript.core.util;

import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A builder class for constructing HTML elements.
 */
@NullMarked
public final class HtmlBuilder {
  private static final Set<String> VOID_ELEMENTS = Set.of("img", "hr", "br");

  private final String tag;
  private final Map<String, String> attributes;

  private HtmlBuilder(String tag) {
    this.tag = tag;
    this.attributes = new HashMap<>();
  }

  /**
   * Convenience method for adding the {@code class} attribute.
   *
   * @param classes
   *   the CSS classes.
   *
   * @return this {@link HtmlBuilder} instance for chaining.
   */
  public HtmlBuilder classes(String classes) {
    this.attributes.put("class", classes);
    return this;
  }

  /**
   * Adds an attribute to the HTML element.
   *
   * @param name
   *   the attribute's name.
   * @param value
   *   the attribute's value.
   *
   * @return this {@link HtmlBuilder} instance for chaining.
   */
  public HtmlBuilder attribute(String name, String value) {
    this.attributes.put(name, value);
    return this;
  }

  /**
   * Builds the {@link HtmlBuilder} into a {@link String} without inner content.
   *
   * @return the string representation of the HTML element.
   */
  public String build() {
    return build("");
  }

  /**
   * Builds the {@link HtmlBuilder} into a {@link String} with inner content.
   *
   * @param content
   *   the inner content.
   *
   * @return the string representation of the HTML element.
   */
  public String build(String content) {
    StringBuilder output = new StringBuilder().append("<").append(tag).append(" ");

    attributes.forEach((name, value) -> output.append(name).append("=\"").append(value).append("\""));

    output.append(">");

    if (!VOID_ELEMENTS.contains(tag)) {
      output.append(content).append("</").append(tag).append(">");
    }

    return output.toString();
  }

  /**
   * Constructs a new {@link HtmlBuilder} with the provided {@code tag}.
   *
   * @param tag
   *   the HTML tag to build.
   *
   * @return a new {@link HtmlBuilder}.
   */
  public static HtmlBuilder create(String tag) {
    return new HtmlBuilder(tag);
  }
}
