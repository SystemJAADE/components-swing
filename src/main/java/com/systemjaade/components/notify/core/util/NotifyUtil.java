package com.systemjaade.components.notify.core.util;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:52:22
 */
public class NotifyUtil {

  private static NotifyUtil instance;

  private int[] screenResol = new int[2];

  private int[] notifyPosition;

  private Toolkit tk;

  private Dimension screen;

  private String textMessage;

  public int[] getScreenResulotion() {
    this.screen = new Dimension();
    this.tk = Toolkit.getDefaultToolkit();
    this.screen = this.tk.getScreenSize();
    this.screenResol[0] = this.screen.width;
    this.screenResol[1] = this.screen.height;
    return this.screenResol;
  }

  public int getHeigtScreen() {
    return this.screenResol[1];
  }

  public int getWidthScreen() {
    return this.screenResol[0];
  }

  public int[] getDesktopNotifyPosition() {
    System.out.println("Calculando posision de la notificacion ...");
    this.notifyPosition = new int[2];
    this.screenResol = getScreenResulotion();
    this.notifyPosition[0] = this.screenResol[0] - 380 - 5;
    this.notifyPosition[1] = 30;
    return this.notifyPosition;
  }

  public String setTextMessageEvent(String text) {
    this.textMessage = text;
    if (this.textMessage.length() > 140) {
      this.textMessage = text.substring(0, 140);
    }
    return this.textMessage;
  }

  public static NotifyUtil getInstance() {
    if (instance == null) {
      instance = new NotifyUtil();
    }
    return instance;
  }
}
