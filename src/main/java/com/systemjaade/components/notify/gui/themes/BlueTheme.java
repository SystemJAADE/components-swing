package com.systemjaade.components.notify.gui.themes;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:56:30
 */
public class BlueTheme extends Theme {

  private final String nameTheme = "Light";

  private final String bakcgroundPanel = "E0E9F3";

  private final String titleForeground = "1A237E";

  private final String messageForeground = "546E7A";

  private final String titleWarningForeground = "FFA000";

  private final String titleErrorForeground = "D32F2F";

  private final String titleOKForeground = "4CAF50";

  private static BlueTheme instance;

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

  public static BlueTheme getInstance() {
    if (instance == null) {
      instance = new BlueTheme();
    }
    return instance;
  }
}
