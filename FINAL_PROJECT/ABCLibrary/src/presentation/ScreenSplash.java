package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/*
 * Esta clase será para presentar nuestro programa
 * y lógicamente será la primera en ejecutarse
 */

public class ScreenSplash extends Thread {

	private JFrame frMain;
	private JPanel pMain;
	private JLabel lblApp; 
	private JLabel lblLoading;
	private JLabel lblAuthors;
	private ImageIcon iconApp;
	
	public void openWindow() {
		createWindow();
	}
	
	private void createWindow() {
		createFrame();
		createPanel();
		createLabels();
		// Muestra la ventana
		frMain.setVisible(true);
		closeWindow();
	}
	
	private void createFrame() {
		frMain = new JFrame();
		// Imagen del icono de la app
		iconApp = new ImageIcon(new ImageIcon(".\\resources\\icon.png").getImage()
				.getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		
		frMain.setSize(600, 300);
		frMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frMain.setUndecorated(true);
		frMain.setLocationRelativeTo(null);
		// Agrega la imagen a la barra de título
		frMain.setIconImage(iconApp.getImage());
	}
	
	private void createPanel() {
		pMain = new JPanel();
		
		pMain.setBackground(Color.decode("#960018"));
		frMain.setContentPane(pMain);
	}
	
	private void createLabels() {
		pMain.setLayout(new MigLayout("", "[204.00px][260.00px][213.00px]", "[33%,top][33%,center][33%,center]"));
		// Label del icono de la app
		lblApp = new JLabel(
				"<html>" + 
				"ABC <br>Library" + 
				"</html>");
		lblApp.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblApp.setForeground(Color.decode("#DACA84"));
		lblApp.setIcon(iconApp);
		lblApp.setIconTextGap(25);
		lblApp.setHorizontalAlignment(JLabel.CENTER);
		pMain.add(lblApp, "cell 1 1,growx,aligny center");
		
		// Label de carga 
		lblLoading = new JLabel("Loading...");
		lblLoading.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLoading.setForeground(Color.decode("#DACA84"));
		lblLoading.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
		pMain.add(lblLoading, "cell 0 2,alignx left,aligny bottom");
		
		// Label de los desarrolladores
		lblAuthors = new JLabel(
				"<html>" + 
				"Creado por:<br>" + 
				"&emsp;&emsp;Ilyasse Essadak Samaali<br>" +
				"&emsp;&emsp;Jose María Sandoval Cerezo<br>" + 
				"&emsp;&emsp;Diego Hoyos Puche" + 
				"</html>");
		lblAuthors.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAuthors.setForeground(Color.decode("#DACA84"));
		
		// Agrega al panel
		pMain.add(lblAuthors, "cell 2 2,alignx right,aligny bottom");
	}
	

	private void closeWindow() {
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierra la ventana
		frMain.dispose();
	}
	
}
