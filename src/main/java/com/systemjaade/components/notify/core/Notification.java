package com.systemjaade.components.notify.core;

import com.systemjaade.components.notify.core.server.ServerOSD;
import com.systemjaade.components.notify.core.util.NotifyConfig;
import com.systemjaade.components.notify.gui.notify.DesktopConfirm;
import com.systemjaade.components.notify.gui.notify.DesktopNotify;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:52:51
 */
public class Notification {

  private static ServerOSD serverOSD;

  public static final int SUPERIOR_IZQUIERDO = 0;

  public static final int SUPERIOR_DERECHO = 1;

  public static final int INFERIOR_IZQUIERDO = 2;

  public static final int INFERIOR_DERECHO = 3;

  public static final byte OK_MESSAGE = 0;

  public static final byte ERROR_MESSAGE = 1;

  public static final byte WARNING_MESSAGE = 2;

  public static final byte CONFIRM_MESSAGE = 3;

  public static final byte DEFAULT_MESSAGE = 4;

  public static final short FACEBOOK_ICON = 1;

  public static final short TWITTER_ICON = 2;

  public static final short GOOGLE_ICON = 3;

  public static final short YOUTUBE_ICON = 4;

  public static final short INSTAGRAM_ICON = 5;

  public static final short WHATSAPP_ICON = 6;

  public static final short LINKEDIN_ICON = 7;

  public static final short GMAIL_ICON = 8;

  public static final short YAHOO_ICON = 9;

  public static final short MESSENGER_ICON = 10;

  public static final short SKYPE_ICON = 11;

  public static final short MAPS_ICON = 12;

  public static final short CALENDAR_ICON = 13;

  public static final short TRANSLATE_ICON = 14;

  public static final short WINDOWS_ICON = 15;

  public static final short LINUX_ICON = 16;

  public static final short WORD_ICON = 17;

  public static final short EXCEL_ICON = 18;

  public static final short PDF_ICON = 19;

  public static final short CSV_ICON = 20;

  public static final short WINRAR_ICON = 21;

  public static final short FOLDER_ICON = 22;

  public static final short DOCUMENTS_ICON = 23;

  public static final short HDD_ICON = 24;

  public static final short SSD_ICON = 25;

  public static final short CDRIVE_ICON = 26;

  public static final short SOFTWAREINSTALLER_ICON = 27;

  public static final short UPDATE_ICON = 28;

  public static final short SECURE_ICON = 29;

  public static final short WEATHER_ICON = 30;

  public static final short WIFI_ICON = 31;

  public static final short BLUETOOTH_ICON = 32;

  public static final short NFC_ICON = 33;

  public static final short RSS_ICON = 34;

  public static final short MESSAGE_ICON = 35;

  public static final short MUSIC_ICON = 36;

  public static final short DOWNLOAD_ICON = 37;

  public static final short PLUGIN_ICON = 38;

  public static final short RESTAPI_ICON = 39;

  public static final short SYNC_ICON = 40;

  public static final short NOTES_ICON = 41;

  public static final short SHUTDOWN_ICON = 42;

  public static final short PIECHART_ICON = 43;

  public static final short MOUSE_ICON = 44;

  public static final short LIGHTNING_ICON = 45;

  public static final short CHIP_ICON = 46;

  public static final short QUERY_ICON = 47;

  public static final short VISA_ICON = 48;

  public static final short BANKCARDS_ICON = 49;

  public static final short FUNDACCOUNTING_ICON = 50;

  public static final short QUESTION_ICON = 51;

  public static final short NEXT_ICON = 52;

  public static final short HASH_ICON = 53;

  public static final short HEADSET_ICON = 54;

  public static final short INFO_ICON = 55;

  public static final short FULLCHARGE_ICON = 56;

  public static final short CONTACT_ICON = 57;

  public static final short IMAGE_ICON = 58;

  public static final short ALARM_ICON = 59;

  public static final short TOGGLEON_ICON = 60;

  public static final short TOGGLEOFF_ICON = 61;

  public static final short CLINIC_ICON = 62;

  public static final short DOCTOR_ICON = 63;

  public static final short DOCTORSBAG_ICON = 64;

  public static final short HEARTHEALTH_ICON = 65;

  public static final short PILL_ICON = 66;

  public static final short SYRINGE_ICON = 67;

  public static final short TOOTH_ICON = 68;

  public static final short STETHOSCOPE_ICON = 69;

  public static final short RODOFASCLEPIUS_ICON = 70;

  public static final short TREATMENT_ICON = 71;

  public static final short AMBULANCE_ICON = 72;

  public static final short SJ_ICON = 73;

  public static final short HEALTHY_ICON = 74;

  public static final char DARK_THEME = 'D';

  public static final char LIGHT_THEME = 'L';

  public static final char GRAY_THEME = 'G';

  public static final char BLUE_THEME = 'B';

  private static DesktopNotify notify;

  private static Event event;

  private static DesktopConfirm confirm;

  private static int option;

  public static void show(int posicion, String title, String message, char theme) {
    init_Server();
    event = new Event(title, message, (byte) 4);
    notify = new DesktopNotify(event, theme);
    serverOSD.send(notify, 2000, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, int timeout) {
    init_Server();
    event = new Event(title, message, (byte) 4);
    notify = new DesktopNotify(event, theme);
    serverOSD.send(notify, timeout, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, byte type) {
    init_Server();
    event = new Event(title, message, type);
    notify = new DesktopNotify(event, theme);
    serverOSD.send(notify, 2000, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, byte type, int timeout) {
    init_Server();
    event = new Event(title, message, type);
    notify = new DesktopNotify(event, theme);
    serverOSD.send(notify, timeout, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, boolean sound) {
    init_Server();
    event = new Event(title, message, (byte) 4);
    notify = new DesktopNotify(event, theme);
    if (sound) {
      notify.playSound(0);
    }
    serverOSD.send(notify, 2000, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, boolean sound, int timeout) {
    init_Server();
    event = new Event(title, message, (byte) 4);
    notify = new DesktopNotify(event, theme);
    if (sound) {
      notify.playSound(0);
    }
    serverOSD.send(notify, timeout, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, boolean sound, byte type) {
    init_Server();
    event = new Event(title, message, type);
    notify = new DesktopNotify(event, theme);
    if (sound) {
      if (event.getTipeMessage() == 0) {
        notify.playSound(0);
      }
      if (event.getTipeMessage() == 2) {
        notify.playSound(1);
      }
      if (event.getTipeMessage() == 1) {
        notify.playSound(2);
      }
    }
    serverOSD.send(notify, 2000, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, boolean sound, byte type, int timeout) {
    init_Server();
    event = new Event(title, message, type);
    notify = new DesktopNotify(event, theme);
    if (sound) {
      if (event.getTipeMessage() == 0) {
        notify.playSound(0);
      }
      if (event.getTipeMessage() == 2) {
        notify.playSound(1);
      }
      if (event.getTipeMessage() == 1) {
        notify.playSound(2);
      }
    }
    serverOSD.send(notify, timeout, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, short icon) {
    init_Server();
    event = new Event(title, message, (byte) 4);
    notify = new DesktopNotify(event, icon, theme);
    serverOSD.send(notify, 2000, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, short icon, int timeout) {
    init_Server();
    event = new Event(title, message, (byte) 4);
    notify = new DesktopNotify(event, icon, theme);
    serverOSD.send(notify, timeout, posicion);
  }

  public static void show(int posicion, String title, String message, char theme, short icon, boolean sound) {
    init_Server();
    event = new Event(title, message, (byte) 4);
    notify = new DesktopNotify(event, icon, theme);
    serverOSD.send(notify, 2000, posicion);
    if (sound) {
      notify.playSound(0);
    }
  }

  public static void show(int posicion, String title, String message, char theme, short icon, boolean sound, int timeout) {
    init_Server();
    event = new Event(title, message, (byte) 4);
    notify = new DesktopNotify(event, icon, theme);
    serverOSD.send(notify, timeout, posicion);
    if (sound) {
      notify.playSound(0);
    }
  }

  public static int showConfirm(int posicion, String title, String message, char theme) {
    init_Server();
    option = -1;
    event = new Event(title, message, (byte) 4);
    confirm = new DesktopConfirm(event, theme);
    serverOSD.send((DesktopNotify) confirm, 2000, posicion);
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, int timeout) {
    init_Server();
    option = -1;
    event = new Event(title, message, (byte) 4);
    confirm = new DesktopConfirm(event, theme);
    serverOSD.send((DesktopNotify) confirm, timeout, posicion);
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, byte type) {
    init_Server();
    option = -1;
    event = new Event(title, message, type);
    confirm = new DesktopConfirm(event, theme);
    serverOSD.send((DesktopNotify) confirm, 2000, posicion);
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, byte type, int timeout) {
    init_Server();
    option = -1;
    event = new Event(title, message, type);
    confirm = new DesktopConfirm(event, theme);
    serverOSD.send((DesktopNotify) confirm, timeout, posicion);
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, boolean sound) {
    init_Server();
    option = -1;
    event = new Event(title, message, (byte) 4);
    confirm = new DesktopConfirm(event);
    serverOSD.send((DesktopNotify) confirm, 2000, posicion);
    if (sound) {
      confirm.playSound(0);
    }
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, boolean sound, int timeout) {
    init_Server();
    option = -1;
    event = new Event(title, message, (byte) 4);
    confirm = new DesktopConfirm(event, theme);
    serverOSD.send((DesktopNotify) confirm, timeout, posicion);
    if (sound) {
      confirm.playSound(0);
    }
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, boolean sound, byte type) {
    init_Server();
    option = -1;
    event = new Event(title, message, type);
    confirm = new DesktopConfirm(event);
    serverOSD.send((DesktopNotify) confirm, 2000, posicion);
    if (sound) {
      switch (event.getTipeMessage()) {
        case 0 ->
          confirm.playSound(0);
        case 2 ->
          confirm.playSound(1);
        case 1 ->
          confirm.playSound(2);
      }
    }
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, boolean sound, byte type, int timeout) {
    init_Server();
    option = -1;
    event = new Event(title, message, type);
    confirm = new DesktopConfirm(event);
    serverOSD.send((DesktopNotify) confirm, timeout, posicion);
    if (sound) {
      switch (event.getTipeMessage()) {
        case 0 ->
          confirm.playSound(0);
        case 2 ->
          confirm.playSound(1);
        case 1 ->
          confirm.playSound(2);
      }
    }
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, short icon) {
    init_Server();
    option = -1;
    event = new Event(title, message, (byte) 4);
    confirm = new DesktopConfirm(event, theme, icon);
    serverOSD.send((DesktopNotify) confirm, 2000, posicion);
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, short icon, int timeout) {
    init_Server();
    option = -1;
    event = new Event(title, message, (byte) 4);
    confirm = new DesktopConfirm(event, theme, icon);
    serverOSD.send((DesktopNotify) confirm, timeout, posicion);
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, short icon, boolean sound) {
    init_Server();
    option = -1;
    event = new Event(title, message, (byte) 4);
    confirm = new DesktopConfirm(event, theme, icon);
    serverOSD.send((DesktopNotify) confirm, 2000, posicion);
    if (sound) {
      confirm.playSound(0);
    }
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  public static int showConfirm(int posicion, String title, String message, char theme, short icon, boolean sound, int timeout) {
    init_Server();
    option = -1;
    event = new Event(title, message, (byte) 4);
    confirm = new DesktopConfirm(event, theme, icon);
    serverOSD.send((DesktopNotify) confirm, timeout, posicion);
    if (sound) {
      confirm.playSound(0);
    }
    if (confirm.isShowing() != true) {
      option = confirm.getSelectedOption();
    }
    return option;
  }

  private static void init_Server() {
    serverOSD = ServerOSD.getInstance();
  }

  public static void showVersionLib() {
    showVersionLib(1);
  }

  public static void showVersionLib(int posicion) {
    init_Server();
    String title = NotifyConfig.getInstance().getNameLib();
    String version = NotifyConfig.getInstance().getVersionLib();
    String info = NotifyConfig.getInstance().getInfoLib();
    event = new Event(title, "Version: " + version + "\n" + info, (byte) 4);
    notify = new DesktopNotify(event, (short) 73, Notification.DARK_THEME);
    serverOSD.send(notify, 2000, posicion);
  }
}
