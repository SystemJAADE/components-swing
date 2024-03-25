package com.systemjaade.components.notify.core.server;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:50:53
 */
public class ServerThread extends Thread {

  private final ServerOSD server;

  private final int nid;

  private final int time;

  private volatile boolean running = true;

  public ServerThread(ServerOSD server, int nid, int time) {
    this.server = server;
    this.nid = nid;
    this.time = time;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(this.time);
      if (running) {
        this.server.remove(this.nid);
      }
    } catch (InterruptedException ex) {
      Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, (String) null, ex);
    }
  }

  protected void killThread() {
    running = false;
    interrupt();
  }
}
