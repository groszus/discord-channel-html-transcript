package dev.omardiaa.transcript.api.schema.payload.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class Role {
  private final String id;
  private final String name;
  private final Colors colors;

  @JsonCreator
  public Role(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("colors") Colors colors) {
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

  @NullMarked
  public static class Colors {
    private final int primaryColor;

    @JsonCreator
    public Colors(@JsonProperty("primary_color") int primaryColor) {
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
