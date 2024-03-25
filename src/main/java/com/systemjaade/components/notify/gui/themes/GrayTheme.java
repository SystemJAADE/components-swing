package com.systemjaade.components.notify.gui.themes;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:56:20
 */
public class GrayTheme extends Theme {

  private final String nameTheme = "Gray";

  private final String bakcgroundPanel = "DDDDDD";

  private final String titleForeground = "0987CA";

  private final String messageForeground = "292929";

  private final String titleWarningForeground = "EE6837";

  private final String titleErrorForeground = "C64064";

  private final String titleOKForeground = "5FB95F";

  private static GrayTheme instance;

  @Override
  public String getBakcgroundPanel() {
    return this.bakcgroundPanel;
  }

  @Override
  public String getTitleForeground() {
    return this.titleForeground;
  }

  @Override
  public String getMessageForeground() {
    return this.messageForeground;
  }

  @Override
  public String getTitleWarningForeground() {
    return this.titleWarningForeground;
  }

  @Override
  public String getTitleErrorForeground() {
    return this.titleErrorForeground;
  }

  @Override
  public String getTitleOKForeground() {
    return this.titleOKForeground;
  }

  @Override
  public String getNameTheme() {
    return this.nameTheme;
  }

  public static GrayTheme getInstance() {
    if (instance == null) {
      instance = new GrayTheme();
    }
    return instance;
  }
}
