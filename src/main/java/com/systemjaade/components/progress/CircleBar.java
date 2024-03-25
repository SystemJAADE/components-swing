package com.systemjaade.components.progress;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:42:14
 */
public class CircleBar extends JPanel {

  int progress = 0;

  String program = "";

  public void updateProgress(int progress) {
    this.progress = progress;
  }

  public void updateProgram(String program) {
    this.program = program;
  }

  public void paint(Graphics graphics) {
    super.paint(graphics);
    setOpaque(false);
    Graphics2D graphics2D = (Graphics2D) graphics;
    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    graphics2D.translate(getWidth() / 2, getHeight() / 2);
    graphics2D.rotate(Math.toRadians(270.0D));
    Arc2D.Float arc = new Arc2D.Float(2);
    Ellipse2D circle = new Ellipse2D.Float(0.0F, 0.0F, 110.0F, 110.0F);
    arc.setFrameFromCenter(new Point(0, 0), new Point(120, 120));
    circle.setFrameFromCenter(new Point(0, 0), new Point(110, 110));
    arc.setAngleStart(1.0D);
    arc.setAngleExtent(-this.progress * 3.6D);
    graphics2D.setColor(Color.red);
    graphics2D.draw(arc);
    graphics2D.fill(arc);
    graphics2D.setColor(getBackground());
    graphics2D.draw(circle);
    graphics2D.fill(circle);
    graphics2D.setColor(Color.red);
    graphics2D.rotate(Math.toRadians(90.0D));
    graphics.setFont(new Font("Verdana", 1, 14));
    FontMetrics fmm = graphics2D.getFontMetrics();
    Rectangle2D rr = fmm.getStringBounds(this.program, graphics);
    int a = (0 - (int) rr.getWidth()) / 2;
    int b = (0 - (int) rr.getHeight()) * 2;
    graphics2D.drawString(this.program, a, b);
    graphics.setFont(new Font("Verdana", 0, 50));
    FontMetrics fm = graphics2D.getFontMetrics();
    Rectangle2D r = fm.getStringBounds(this.progress + "%", graphics);
    int x = (0 - (int) r.getWidth()) / 2;
    int y = (0 - (int) r.getHeight()) / 2 + fm.getAscent();
    graphics2D.drawString(this.progress + "%", x, y);
  }
}
