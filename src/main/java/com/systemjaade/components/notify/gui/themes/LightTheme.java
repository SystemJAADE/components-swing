package com.systemjaade.components.notify.gui.themes;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:56:30
 */
public class LightTheme extends Theme {

  private final String nameTheme = "Light";

  private final String bakcgroundPanel = "F8F8F8";

  private final String titleForeground = "313030";

  private final String messageForeground = "777777";

  private final String titleWarningForeground = "C34000";

  private final String titleErrorForeground = "C91313";

  private final String titleOKForeground = "4BAF4F";

  private static LightTheme instance;

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

  public static LightTheme getInstance() {
    if (instance == null) {
      instance = new LightTheme();
    }
    return instance;
  }
}
