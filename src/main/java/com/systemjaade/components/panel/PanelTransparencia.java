package com.systemjaade.components.panel;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:40:02
 */
public class PanelTransparencia extends JPanel {

  protected float tran = 0.5F;

  private float valor = this.tran;

  protected void paintComponent(Graphics graphics) {
    Graphics2D graphics2D = (Graphics2D) graphics;
    Composite oldComposite = graphics2D.getComposite();
    AlphaComposite newComposite = AlphaComposite.getInstance(3, this.valor);
    graphics2D.setComposite(newComposite);
    super.paintComponent(graphics);
    graphics2D.setComposite(oldComposite);
  }

  public float getTran() {
    return this.tran;
  }

  public void setTran(float tran) {
    this.tran = tran;
    this.valor = tran;
  }
}
