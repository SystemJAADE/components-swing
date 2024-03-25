package com.systemjaade.components.notify.gui.notify.controller;

import com.systemjaade.components.notify.gui.notify.DesktopConfirm;
import com.systemjaade.components.notify.gui.notify.DesktopNotify;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:55:49
 */
public class NotifyController implements ActionListener {

  private final DesktopConfirm desktopConfirm;

  private int optionPressed;

  public NotifyController(DesktopNotify desktopConfirm) {
    this.desktopConfirm = (DesktopConfirm) desktopConfirm;
    this.desktopConfirm.jbAcept.addActionListener(this);
    this.desktopConfirm.jbCancel.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(this.desktopConfirm.jbAcept)) {
      this.optionPressed = 1;
    }
    if (e.getSource().equals(this.desktopConfirm.jbCancel)) {
      this.optionPressed = 0;
    }
  }

  public int getOptionPressed() {
    return this.optionPressed;
  }
}
