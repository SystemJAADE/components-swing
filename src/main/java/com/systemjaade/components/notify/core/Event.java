package com.systemjaade.components.notify.core;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:52:42
 */
public class Event {

  private final String titleEvent;

  private final String textEvent;

  private final byte typeMessage;

  public Event(String titleEvent, String textEvent, byte typeMessage) {
    this.titleEvent = titleEvent;
    this.textEvent = textEvent;
    this.typeMessage = typeMessage;
  }

  public String getTitleEvent() {
    return this.titleEvent;
  }

  public String getTextEvent() {
    return this.textEvent;
  }

  public int getTipeMessage() {
    return this.typeMessage;
  }

  @Override
  public String toString() {
    return "Event{" + "titleEvent=" + titleEvent + ", textEvent=" + textEvent + ", typeMessage=" + typeMessage + '}';
  }
}
