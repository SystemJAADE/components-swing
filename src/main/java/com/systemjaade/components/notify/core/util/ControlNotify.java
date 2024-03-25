package com.systemjaade.components.notify.core.util;

import com.systemjaade.components.notify.gui.notify.DesktopNotify;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:51:36
 */
public class ControlNotify {

  public static int displayed = 0;
  private static int ypos;
  private static int prevHeight = 0;
  private static int prevYPos = 0;
  private static final ArrayList listNotify = new ArrayList();
  private static final NotifyUtil util = NotifyUtil.getInstance();
  private static final int[] pos = util.getDesktopNotifyPosition();

  public static void launchNotify(DesktopNotify notify) {
    if (notify != null) {
      System.out.println("ControllerDesktopNotify:  Preparando notificacion ...");
      ypos = setYAxisPosition();
      notify.setLocation(pos[0], ypos);
      prevHeight = notify.getHeight();
      prevYPos = notify.getY();
      displayed++;
      listNotify.add(notify);
      notify.setVisible(true);
    }
  }

  public static void removeNotify(DesktopNotify notify) {
    Iterator<DesktopNotify> iterator = listNotify.iterator();
    while (iterator.hasNext()) {
      DesktopNotify deskNotify = iterator.next();
      if (notify.equals(deskNotify)) {
        deskNotify.dispose();
        iterator.remove();
        displayed--;
        break; // Termina el bucle después de encontrar y eliminar la notificación
      }
    }
  }

  private static int setYAxisPosition() {
    if (displayed == 0) {
      ypos = pos[1];
      System.out.println("ControllerDesktopNotify: YAxisPosition #" + ypos);
    } else {
      ypos = prevYPos + prevHeight + 8;
      System.out.println("ControllerDesktopNotify: YAxisPosition #" + ypos);
    }
    return ypos;
  }
}
