package dev.omardiaa.transcript.api.schema.payload.message;

public enum InteractionType {
  UNKNOWN(-1),
  APPLICATION_COMMAND(2);

  private final int value;

  InteractionType(int value) {
    this.value = value;
  }

  public static InteractionType fromValue(int value) {
    if (value == 2) {
      return APPLICATION_COMMAND;
    }

    return UNKNOWN;
  }
}
