package max.servidor.guis;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class ServidorTry {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		// Chequeo si esta soportado el SystemTry
		if (!SystemTray.isSupported()) {
			// Mostrar GUI Servidor por falta de soporte de TraySystem
			return;
		}
		final PopupMenu popup = new PopupMenu();
	
		final TrayIcon trayIcon = new TrayIcon(createImage(
				"/max/recursos/iconos/logoServidor_on_16x16.gif",
				"INDUMATICS Server ON"));

		final SystemTray tray = SystemTray.getSystemTray();

		//Creo los SubMenus
		MenuItem menuAbrir = new MenuItem("Opciones");
		MenuItem menuStart = new MenuItem("Iniciar");
		MenuItem menuStop = new MenuItem("Parar");
		MenuItem menuExit = new MenuItem("Cerrar");

		// Agrego los SubMenus al PopupMenu
		popup.add(menuAbrir);
		popup.add(menuStart);
		popup.addSeparator();
		popup.add(menuStart);
		popup.add(menuStop);
		popup.addSeparator();
		popup.add(menuExit);

		//Agrego el PopUpMenu al TrayIcon creado
		trayIcon.setPopupMenu(popup);

		try {
			tray.add(trayIcon);
			trayIcon.setImageAutoSize(true);
			trayIcon.setToolTip("INDUMATICS Server");
			 setTrayIconEstado(false, trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
			return;
		}

		trayIcon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		menuAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Codigo para abrir ventana de opciones
			}
		});
		menuStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Codigo para iniciar el servidor
			}
		});

		menuStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Codigo para detener el servidor
			}
		});

		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tray.remove(trayIcon);
				System.exit(0);
			}
		});
	}
	//Cambio el icono en el tray dependiendo el estado pasado (On / Off)
	protected static void setTrayIconEstado(boolean stateOn, TrayIcon trayIcon) {
		if (stateOn) {
			final TrayIcon trayIconOn = new TrayIcon(
					createImage(
							"/max/recursos/iconos/logoServidor_on_16x16.gif",
							"INDUMATICS Server ON"));
			trayIcon.setImage(trayIconOn.getImage());
			trayIcon.setToolTip("INDUMATICS Server ON");
			trayIcon.displayMessage("INDUMATICS Server", "Servidor en linea!",
					TrayIcon.MessageType.INFO);
		} else {
			final TrayIcon trayIconOff = new TrayIcon(
					createImage(
							"/max/recursos/iconos/logoServidor_off_16x16.gif",
							"INDUMATICS Server OFF"));
			trayIcon.setImage(trayIconOff.getImage());
			trayIcon.setToolTip("INDUMATICS Server OFF");
			trayIcon.displayMessage("INDUMATICS Server",
					"Servidor Desconectado!", TrayIcon.MessageType.WARNING);
		}
	}

	// Obtener imagen URL
	protected static Image createImage(String path, String description) {
		URL imageURL = ServidorTry.class.getResource(path);
		if (imageURL == null) {
			System.err.println("No se encontro el recurso: " + path);
			return null;
		} else {
			return (new ImageIcon(imageURL, description)).getImage();
		}
	}
}
