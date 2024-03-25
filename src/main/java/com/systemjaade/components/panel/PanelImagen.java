package com.systemjaade.components.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:21:26
 */
public class PanelImagen extends JPanel {

  private Image image = null;
  private Icon icon;

  protected void paintComponent(Graphics graphics) {
    Graphics2D graphics2D = (Graphics2D) graphics;
    if (this.image != null) {
      graphics2D.drawImage(this.image, 0, 0, getWidth(), getHeight(), null);
    }
  }

  public Icon getIcon() {
    return this.icon;
  }

  public void setIcon(Icon icon) {
    this.icon = icon;
    if (icon != null) {
      this.image = ((ImageIcon) icon).getImage();
    }
  }
}
