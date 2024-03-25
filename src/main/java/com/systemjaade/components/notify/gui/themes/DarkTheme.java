package com.systemjaade.components.notify.gui.themes;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:56:11
 */
public class DarkTheme extends Theme {

  private final String nameTheme = "Dark";

  private final String bakcgroundPanel = "303030";

  private final String titleForeground = "FFFFFF";

  private final String messageForeground = "EEEEEE";

  private final String titleWarningForeground = "f39c12";

  private final String titleErrorForeground = "e74c3c";

  private final String titleOKForeground = "4BAF4F";

  private static DarkTheme instance;

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

  public static DarkTheme getInstance() {
    if (instance == null) {
      instance = new DarkTheme();
    }
    return instance;
  }
}
