package com.systemjaade.components.notify.core.util;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:51:45
 */
public class NLabel extends JTextArea {

  private final String text;

  public NLabel(String text) {
    super(text);
    this.text = text;
    setEditable(false);
    setLineWrap(true);
    setBackground((Color) null);
    setBorder((Border) null);
    setWrapStyleWord(true);
    setFocusable(false);
  }
}
