package com.systemjaade.components.notify.core.server;

import com.systemjaade.components.notify.gui.notify.DesktopNotify;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.HashMap;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:50:40
 */
public class ServerOSD {

  private final HashMap stackServer = new HashMap<>();

  private final HashMap stackThread = new HashMap<>();

  private int nid;

  private int prev_vertical_position;

  private ServerThread serThread;

  private Dimension dimensionDevice;

  private DesktopNotify notify;

  private static ServerOSD server;

  private Toolkit tool;

  private int yPosition;

  private int createNID() {
    this.nid = (int) Math.floor(Math.random() * 1000.0D);
    if (this.stackServer.containsKey(this.nid)) {
      createNID();
    }
    return this.nid;
  }

  public void send(DesktopNotify notify, int time, int posicion) {
    try {
      if (this.stackServer.size() <= 4) {
        notify.setNid(createNID());
        this.stackServer.put(this.nid, notify);
        if (time >= 10) {
          this.serThread = new ServerThread(this, this.nid, time);
          this.serThread.start();
          this.stackThread.put(this.nid, this.serThread);
        }
        posicion(notify, posicion);
        notify.setVisible(true);
        this.prev_vertical_position = notify.getY();
      }
    } catch (Exception exception) {
    }
  }

  private void posicion(DesktopNotify notify, int posicion) {
    int x, y;

    // Determina la posición horizontal
    if (posicion == 0 || posicion == 2) {
      x = 5; // Alineado a la izquierda
    } else {
      x = (getDimensionDevice().width - notify.getWidth() - 5); // Alineado a la derecha
    }

    // Determina la posición vertical
    if (posicion == 0 || posicion == 1) {
      y = setVerticalPosition(); // Posición superior
    } else {
      y = setVerticalPositionInferior(); // Posición inferior
    }

    // Establece la ubicación de la notificación
    notify.setLocation(x, y);
  }

  private int setVerticalPositionInferior() {
    if (this.stackServer.size() == 1) {
      this.yPosition = (getDimensionDevice()).height - 133;
    } else if (this.stackServer.size() > 1) {
      this.yPosition = this.prev_vertical_position + 110;
    }
    return this.yPosition;
  }

  private int setVerticalPosition() {
    if (this.stackServer.size() == 1) {
      this.yPosition = 30;
    } else if (this.stackServer.size() > 1) {
      this.yPosition = this.prev_vertical_position + 110;
    }
    return this.yPosition;
  }

  public void remove(int nid) {
    if (this.stackServer.containsKey(nid)) {
      this.notify = (DesktopNotify) this.stackServer.get(nid);
      if (this.notify.isVisible()) {
        this.notify.dispose();
        ServerThread thrd = (ServerThread) this.stackThread.get(nid);
        thrd.killThread();
        this.stackServer.remove(nid);
        this.stackThread.remove(nid);
      }
    }
  }

  public Dimension getDimensionDevice() {
    try {
      this.tool = Toolkit.getDefaultToolkit();
      this.dimensionDevice = this.tool.getScreenSize();
    } catch (HeadlessException e) {
      System.err.println("ServerOSD: Exception in: " + e);
    }
    return this.dimensionDevice;
  }

  public static ServerOSD getInstance() {
    if (server == null) {
      server = new ServerOSD();
    }
    return server;
  }
}
