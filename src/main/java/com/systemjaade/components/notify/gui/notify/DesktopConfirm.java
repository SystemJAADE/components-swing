package com.systemjaade.components.notify.gui.notify;

import com.systemjaade.components.notify.core.Event;
import com.systemjaade.components.notify.core.server.ServerOSD;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:54:56
 */
public class DesktopConfirm extends DesktopNotify implements ActionListener {

  public JButton jbAcept;

  public JButton jbCancel;

  public int option;

  public DesktopConfirm(Event ev) {
    super(ev);
    setSize(380, 106);
    init();
  }

  public DesktopConfirm(Event ev, char theme) {
    super(ev, theme);
    setSize(380, 106);
    init();
  }

  public DesktopConfirm(Event ev, char theme, short icon) {
    super(ev, icon, theme);
    setSize(380, 106);
    init();
  }

  private void init() {
    this.jbAcept = new JButton("Acept");
    this.jbAcept.setBounds(0, 83, 190, 23);
    this.jbAcept.setForeground(Color.white);
    this.jbAcept.setOpaque(true);
    this.jbAcept.setBorderPainted(false);
    this.jbAcept.addActionListener(this);
    this.jbCancel = new JButton("Cancel");
    this.jbCancel.setBounds(190, 83, 190, 23);
    this.jbCancel.setOpaque(true);
    this.jbCancel.setBorderPainted(false);
    this.jbCancel.addActionListener(this);
    addButton(this.jbAcept);
    addButton(this.jbCancel);
    setAceptButtonColor();
  }

  private void setAceptButtonColor() {
    if (getEvent().getTipeMessage() == 4 && getTheme().getNameTheme().equals("Dark")) {
      this.jbAcept.setBackground(new Color(Integer.parseInt("707070", 16)));
    } else {
      this.jbAcept.setBackground(getForegroundTitle());
    }
  }

  public int getSelectedOption() {
    return this.option;
  }

  public void close() {
    ServerOSD.getInstance().remove(getNid());
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource().equals(this.jbAcept)) {
      System.out.println("La opción seleccionada es: aceptar");
      this.option = 1;
      close();
    } else {
      System.out.println("La opción seleccionada es: cancelar");
      this.option = -1;
      close();
    }
  }
}
