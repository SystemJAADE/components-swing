package com.systemjaade.components.notify.gui.notify;

import com.systemjaade.components.notify.core.Event;
import com.systemjaade.components.notify.core.server.ServerOSD;
import com.systemjaade.components.notify.core.util.NLabel;
import com.systemjaade.components.notify.core.util.NotifyConfig;
import com.systemjaade.components.notify.core.util.NotifyUtil;
import com.systemjaade.components.notify.gui.themes.BlueTheme;
import com.systemjaade.components.notify.gui.themes.DarkTheme;
import com.systemjaade.components.notify.gui.themes.GrayTheme;
import com.systemjaade.components.notify.gui.themes.LightTheme;
import com.systemjaade.components.notify.gui.themes.Theme;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Tarazona Marrujo Elí Gamaliel - "System JAADE S.A.C."
 * @since 24 mar. 2024 - 10:55:08
 */
public class DesktopNotify extends JDialog implements ActionListener {

  private final Event ev;

  private int nid;

  private short icon;

  private char nicon_theme;

  private String urlIcon;

  private JLabel jlTitle;

  private NLabel jlMessage;

  private JLabel jlIcon;

  private final NotifyConfig config;

  private final NotifyUtil util;

  private Theme theme;

  private JButton jbClose;

  private JPanel panel;

  private static final Map<Integer, String> ICON_MAPPING = new HashMap<>();

  static {
    ICON_MAPPING.put(-1, "NotifyCustomIcon.png");
    ICON_MAPPING.put(1, "NotifyFacebook.png");
    ICON_MAPPING.put(2, "NotifyTwitter.png");
    ICON_MAPPING.put(3, "NotifyGoogle.png");
    ICON_MAPPING.put(4, "NotifyYouTube.png");
    ICON_MAPPING.put(5, "NotifyInstagram.png");
    ICON_MAPPING.put(6, "NotifyWhatsApp.png");
    ICON_MAPPING.put(7, "NotifyLinkedIn.png");
    ICON_MAPPING.put(8, "NotifyGmail.png");
    ICON_MAPPING.put(9, "NotifyYahoo.png");
    ICON_MAPPING.put(10, "NotifyMessenger.png");
    ICON_MAPPING.put(11, "NotifySkype.png");
    ICON_MAPPING.put(12, "NotifyMaps.png");
    ICON_MAPPING.put(13, "NotifyCalendar.png");
    ICON_MAPPING.put(14, "NotifyTranslate.png");
    ICON_MAPPING.put(15, "NotifyWindows.png");
    ICON_MAPPING.put(16, "NotifyLinux.png");
    ICON_MAPPING.put(17, "NotifyWord.png");
    ICON_MAPPING.put(18, "NotifyExcel.png");
    ICON_MAPPING.put(19, "NotifyPDF.png");
    ICON_MAPPING.put(20, "NotifyCSV.png");
    ICON_MAPPING.put(21, "NotifyWinRAR.png");
    ICON_MAPPING.put(22, "NotifyFolder.png");
    ICON_MAPPING.put(23, "NotifyDocuments.png");
    ICON_MAPPING.put(24, "NotifyHDD.png");
    ICON_MAPPING.put(25, "NotifySSD.png");
    ICON_MAPPING.put(26, "NotifyCDrive.png");
    ICON_MAPPING.put(27, "NotifySoftwareInstaller.png");
    ICON_MAPPING.put(28, "NotifyUpdate.png");
    ICON_MAPPING.put(29, "NotifySecure.png");
    ICON_MAPPING.put(30, "NotifyWeather.png");
    ICON_MAPPING.put(31, "NotifyWifi.png");
    ICON_MAPPING.put(32, "NotifyBluetooth.png");
    ICON_MAPPING.put(33, "NotifyNFC.png");
    ICON_MAPPING.put(34, "NotifyRss.png");
    ICON_MAPPING.put(35, "NotifyMessage.png");
    ICON_MAPPING.put(36, "NotifyMusic.png");
    ICON_MAPPING.put(37, "NotifyDownload.png");
    ICON_MAPPING.put(38, "NotifyPlugin.png");
    ICON_MAPPING.put(39, "NotifyRestAPI.png");
    ICON_MAPPING.put(40, "NotifySync.png");
    ICON_MAPPING.put(41, "NotifyNotes.png");
    ICON_MAPPING.put(42, "NotifyShutdown.png");
    ICON_MAPPING.put(43, "NotifyPieChart.png");
    ICON_MAPPING.put(44, "NotifyMouse.png");
    ICON_MAPPING.put(45, "NotifyLightning.png");
    ICON_MAPPING.put(46, "NotifyChip.png");
    ICON_MAPPING.put(47, "NotifyQuery.png");
    ICON_MAPPING.put(48, "NotifyVisa.png");
    ICON_MAPPING.put(49, "NotifyBankCards.png");
    ICON_MAPPING.put(50, "NotifyFundAccounting.png");
    ICON_MAPPING.put(51, "NotifyQuestion.png");
    ICON_MAPPING.put(52, "NotifyNext.png");
    ICON_MAPPING.put(53, "NotifyHash.png");
    ICON_MAPPING.put(54, "NotifyHeadset.png");
    ICON_MAPPING.put(55, "NotifyInfo.png");
    ICON_MAPPING.put(56, "NotifyFullCharge.png");
    ICON_MAPPING.put(57, "NotifyContact.png");
    ICON_MAPPING.put(58, "NotifyImage.png");
    ICON_MAPPING.put(59, "NotifyAlarm.png");
    ICON_MAPPING.put(60, "NotifyToggleOn.png");
    ICON_MAPPING.put(61, "NotifyToggleOff.png");
    ICON_MAPPING.put(62, "NotifyClinic.png");
    ICON_MAPPING.put(63, "NotifyDoctor.png");
    ICON_MAPPING.put(64, "NotifyDoctorsBag.png");
    ICON_MAPPING.put(65, "NotifyHeartHealth.png");
    ICON_MAPPING.put(66, "NotifyPill.png");
    ICON_MAPPING.put(67, "NotifySyringe.png");
    ICON_MAPPING.put(68, "NotifyTooth.png");
    ICON_MAPPING.put(69, "NotifyStethoscope.png");
    ICON_MAPPING.put(70, "NotifyRodOfAsclepius.png");
    ICON_MAPPING.put(71, "NotifyTreatment.png");
    ICON_MAPPING.put(72, "NotifyAmbulance.png");
    ICON_MAPPING.put(73, "NotifySystemJaade.png");
    ICON_MAPPING.put(74, "NotifyHealthy.png");
  }

  public DesktopNotify(Event ev) {
    this.ev = ev;
    this.config = NotifyConfig.getInstance();
    this.util = NotifyUtil.getInstance();
    this.theme = (Theme) DarkTheme.getInstance();
    setSize(380, 98);
    setUndecorated(true);
    setAlwaysOnTop(true);
    setResizable(false);
    init();
    setDesktopInterface();
  }

  public DesktopNotify(Event ev, char theme) {
    this.ev = ev;
    this.nicon_theme = theme;
    this.config = NotifyConfig.getInstance();
    this.util = NotifyUtil.getInstance();
    setNotifyTheme();
    setSize(380, 98);
    setUndecorated(true);
    setAlwaysOnTop(true);
    setResizable(false);
    init();
    setDesktopInterface();
  }

  public DesktopNotify(Event ev, short icon) {
    this.ev = ev;
    this.icon = icon;
    this.config = NotifyConfig.getInstance();
    this.util = NotifyUtil.getInstance();
    this.theme = (Theme) DarkTheme.getInstance();
    setSize(380, 98);
    setUndecorated(true);
    setAlwaysOnTop(true);
    setResizable(false);
    init();
    setDesktopInterface();
    setIconOption();
  }

  public DesktopNotify(Event ev, short icon, char theme) {
    this.ev = ev;
    this.icon = icon;
    this.nicon_theme = theme;
    this.config = NotifyConfig.getInstance();
    this.util = NotifyUtil.getInstance();
    setNotifyTheme();
    setSize(380, 110);
    setUndecorated(true);
    setAlwaysOnTop(true);
    setResizable(false);
    init();
    setDesktopInterface();
    setIconOption();
  }

  public DesktopNotify(Event ev, String url) {
    this.ev = ev;
    this.icon = -1;
    this.urlIcon = url;
    this.theme = (Theme) DarkTheme.getInstance();
    this.config = NotifyConfig.getInstance();
    this.util = NotifyUtil.getInstance();
    setNotifyTheme();
    setSize(380, 110);
    setUndecorated(true);
    setAlwaysOnTop(true);
    setResizable(false);
    init();
    setDesktopInterface();
    setIconOption();
  }

  public DesktopNotify(Event ev, String url, char skin) {
    this.ev = ev;
    this.icon = -1;
    this.urlIcon = url;
    this.nicon_theme = skin;
    this.config = NotifyConfig.getInstance();
    this.util = NotifyUtil.getInstance();
    setNotifyTheme();
    setSize(380, 98);
    setUndecorated(true);
    setAlwaysOnTop(true);
    setResizable(false);
    init();
    setDesktopInterface();
    setIconOption();
  }

  private void init() {
    this.panel = new JPanel();
    this.panel.setLayout((LayoutManager) null);
    this.panel.setBackground(new Color(Integer.parseInt(this.theme.getBakcgroundPanel(), 16)));
    this.jbClose = new JButton();
    this.jbClose.setBounds(362, 2, 15, 15);
    this.jbClose.setBorderPainted(false);
    this.jbClose.setContentAreaFilled(false);
    this.jbClose.setIcon(new ImageIcon(getClass().getResource(this.config.getIcons8IconsPath() + "CloseNotify.png")));
    this.jbClose.addActionListener(this);
    this.jlIcon = new JLabel();
    this.jlIcon.setBounds(0, 0, 65, 65);
    this.jlTitle = new JLabel(this.ev.getTitleEvent());
    this.jlTitle.setFont(this.config.getTitleFontDesk());
    this.jlTitle.setBounds(72, 6, 305, 25);
    this.jlMessage = new NLabel(this.util.setTextMessageEvent(this.ev.getTextEvent()));
    this.jlMessage.setFont(this.config.getMessageFontDesk());
    this.jlMessage.setBounds(72, 30, 299, 53);
    this.jlMessage.setForeground(new Color(Integer.parseInt(this.theme.getMessageForeground(), 16)));
    this.panel.add(this.jlIcon);
    this.panel.add(this.jlTitle);
    this.panel.add((Component) this.jlMessage);
    this.panel.add(this.jbClose);
    add(this.panel);
  }

  public Event getEvent() {
    return this.ev;
  }

  public int getNid() {
    return this.nid;
  }

  public void setNid(int nid) {
    this.nid = nid;
  }

  public void addButton(JButton buton) {
    this.panel.add(buton);
  }

  private void setIconNotify(ImageIcon icon) {
    this.jlIcon.setIcon(icon);
  }

  private void setDesktopInterface() {
    switch (this.ev.getTipeMessage()) {
      case 0 -> {
        setIconNotify(new ImageIcon(getClass().getResource(this.config.getIcons8IconsPath() + "NotifyOk.png")));
        this.jlTitle.setForeground(new Color(Integer.parseInt(this.theme.getTitleOKForeground(), 16)));
      }
      case 1 -> {
        setIconNotify(new ImageIcon(getClass().getResource(this.config.getIcons8IconsPath() + "NotifyError.png")));
        this.jlTitle.setForeground(new Color(Integer.parseInt(this.theme.getTitleErrorForeground(), 16)));
      }
      case 2 -> {
        setIconNotify(new ImageIcon(getClass().getResource(this.config.getIcons8IconsPath() + "NotifyWarning.png")));
        this.jlTitle.setForeground(new Color(Integer.parseInt(this.theme.getTitleWarningForeground(), 16)));
      }
      case 3 -> {
        setIconNotify(new ImageIcon(getClass().getResource(this.config.getIcons8IconsPath() + "NotifyConfirm.png")));
        this.jlTitle.setForeground(new Color(Integer.parseInt(this.theme.getTitleForeground(), 16)));
      }
      default -> {
        setIconNotify(new ImageIcon(getClass().getResource(this.config.getIcons8IconsPath() + "NotifyDefault.png")));
        this.jlTitle.setForeground(new Color(Integer.parseInt(this.theme.getTitleForeground(), 16)));
      }
    }
  }

  private void setIconOption() {
    String iconName = ICON_MAPPING.get((int) this.icon);
    if (iconName != null) {
      String iconPath = this.config.getIcons8IconsPath() + iconName;
      setIconNotify(new ImageIcon(getClass().getResource(iconPath)));
    } else {
      System.err.println("Icono no encontrado para el valor de this.icon: " + this.icon);
    }
  }

  private void setNotifyTheme() {
    switch (this.nicon_theme) {
      case 'D' -> {
        this.theme = (Theme) DarkTheme.getInstance();
      }
      case 'G' -> {
        this.theme = (Theme) GrayTheme.getInstance();
      }
      case 'B' -> {
        this.theme = (Theme) BlueTheme.getInstance();
      }
      default -> {
        this.theme = (Theme) LightTheme.getInstance();
      }
    }
  }

  public Theme getTheme() {
    return this.theme;
  }

  public Color getForegroundTitle() {
    return this.jlTitle.getForeground();
  }

  public void playSound(int type) {
    String filePath = null;
    switch (type) {
      case 1 ->
        filePath = "/sound/warning.wav";
      case 2 ->
        filePath = "/sound/error.wav";
      default ->
        filePath = "/sound/notify.wav";
    }

    try {
      // Obtiene el archivo de audio
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(filePath));

      // Crea un Clip de audio
      Clip clip = AudioSystem.getClip();

      // Abre el flujo de audio
      clip.open(audioInputStream);

      // Reproduce el clip de audio
      clip.start();

    } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(this.jbClose)) {
      ServerOSD.getInstance().remove(getNid());
    }
  }
}
