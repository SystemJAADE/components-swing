package com.systemjaade.components.notify.core.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:49:55
 */
public class ControlFont {

  private static ControlFont controlFont;

  private Font font;
  private String urlFont = "/font/font.OTF";

  private InputStream inputStream;

  private ControlFont() {
    try {
      this.inputStream = getClass().getResourceAsStream(this.urlFont);
      this.font = Font.createFont(0, this.inputStream);
      this.inputStream.close();
    } catch (FontFormatException | IOException e) {
      System.out.println("Ocurrio el siguiente error al Intentar cargar La fuente:\n" + e);
    }
  }

  public Font getFont(float size) {
    return this.font != null ? this.font.deriveFont(size) : null;
  }

  public Font getFontBold(float size) {
    return this.font != null ? this.font.deriveFont(Font.BOLD, size) : null;
  }

  public static ControlFont getInstance() {
    if (controlFont == null) {
      controlFont = new ControlFont();
    }
    return controlFont;
  }
}
