package com.systemjaade.components.notify.core.util;

import com.systemjaade.components.notify.core.font.ControlFont;
import java.awt.Color;
import java.awt.Font;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:52:02
 */
public class NotifyConfig {

  private final ControlFont font = ControlFont.getInstance();

  private final Font titleFontDesk = this.font.getFont(20.0F);

  private final Font messageFontDesk = this.font.getFont(15.0F);

  private final Color fontErrorColor = new Color(222, 60, 60);

  private final Color fontWarningColor = new Color(230, 89, 0);

  private final Color fontOKColor = new Color(116, 164, 0);

  private final Color fontConfirmColor = new Color(57, 191, 222);

  private final Color fontDefaultColor = new Color(214, 214, 214);

  private final String Icons8IconsPath = "/icons/icons8/";

  private final String nameLib = "System JAADE Notify";

  private final String versionLib = "24.04";

  private final String infoLib = "Desarrollado por System JAADE SAC \nIconos por Icons 8";

  private static NotifyConfig instance;

  public Font getTitleFontDesk() {
    return this.titleFontDesk;
  }

  public Font getMessageFontDesk() {
    return this.messageFontDesk;
  }

  public Color getFontErrorColor() {
    return this.fontErrorColor;
  }

  public Color getFontWarningColor() {
    return this.fontWarningColor;
  }

  public Color getFontOKColor() {
    return this.fontOKColor;
  }

  public Color getFontConfirmColor() {
    return this.fontConfirmColor;
  }

  public Color getFontDefaultColor() {
    return this.fontDefaultColor;
  }

  public String getIcons8IconsPath() {
    return this.Icons8IconsPath;
  }

  public String getNameLib() {
    return this.nameLib;
  }

  public String getVersionLib() {
    return this.versionLib;
  }

  public String getInfoLib() {
    return this.infoLib;
  }

  public static NotifyConfig getInstance() {
    if (instance == null) {
      instance = new NotifyConfig();
    }
    return instance;
  }
}
