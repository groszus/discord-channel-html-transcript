package dev.omardiaa.transcript.core.model.payload.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

/**
 * Discord <a href="https://discord.com/developers/docs/topics/permissions#role-object">Role</a>.
 */
@NullMarked
public class Role {
  private final String id;
  private final String name;
  private final Colors colors;

  @JsonCreator
  public Role(
    @JsonProperty(value = "id", required = true) String id,
    @JsonProperty(value = "name", required = true) String name,
    @JsonProperty(value = "colors", required = true) Colors colors) {
    this.id = id;
    this.name = name;
    this.colors = colors;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Colors getColors() {
    return colors;
  }

  @Override
  public String toString() {
    return "Role{" +
           "id='" + id + '\'' +
           ", name='" + name + '\'' +
           ", colors=" + colors +
           '}';
  }

  /**
   * Discord <a href="https://discord.com/developers/docs/topics/permissions#role-object-role-colors-object">Role Colors</a>.
   */
  @NullMarked
  public static class Colors {
    private final int primaryColor;

    @JsonCreator
    public Colors(@JsonProperty(value = "primary_color", required = true) int primaryColor) {
      this.primaryColor = primaryColor;
    }

    public int getPrimaryColor() {
      return primaryColor;
    }

    @Override
    public String toString() {
      return "Colors{" +
             "primaryColor=" + primaryColor +
             '}';
    }
  }
}
