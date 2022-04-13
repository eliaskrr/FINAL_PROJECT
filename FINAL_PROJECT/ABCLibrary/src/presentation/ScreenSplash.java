package presentation;

import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import assistant.Images;
import assistant.Style;
import net.miginfocom.swing.MigLayout;

/*
 * Esta clase será para presentar nuestro programa
 * y lógicamente será la primera en ejecutarse
 */
public class ScreenSplash extends Thread {

	private JFrame frMain;
	private JPanel pMain;
	private JLabel lblApp; 
	private Style style;
	private Images image;
	
	public ScreenSplash() {
		createWindow();
	}

	private void createWindow() {
		style = new Style();
		image = new Images();
		
		createFrame();
		createPanel();
		createLabels();
		// Muestra la ventana
		frMain.setVisible(true);
		closeWindow();
	}
	
	private void createFrame() {
		frMain = new JFrame();
		frMain.setSize(600, 300);
		frMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frMain.setUndecorated(true);
		frMain.setLocationRelativeTo(null);
		// Agrega la imagen a la barra de título
		frMain.setIconImage(image.getIconApp().getImage());
	}
	
	private void createPanel() {
		pMain = new JPanel();
		
		pMain.setBackground(style.getRedColor());
		frMain.setContentPane(pMain);
	}
	
	private void createLabels() {
		pMain.setLayout(new MigLayout("", "[204.00px][260.00px][213.00px]", "[33%,top][33%,center][33%,center]"));
		// Label del icono de la app
		lblApp = new JLabel(
				"<html>" + 
				"ABC <br>Library" + 
				"</html>");
		lblApp.setFont(new Font("Calibri", Font.BOLD, 30));
		lblApp.setForeground(style.getYellowColor());
		// Escalamos la imagen
		image.setIconScaledApp(80, 80, Image.SCALE_SMOOTH);
		// Agregamos la imagen al label
		lblApp.setIcon(image.getIconScaledApp());
		lblApp.setIconTextGap(25);
		lblApp.setHorizontalAlignment(JLabel.CENTER);
		pMain.add(lblApp, "cell 1 1,growx,aligny center");
	}
	

	private void closeWindow() {
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Cierra la ventana
		frMain.dispose();
	}
	
}
