package window.login;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constant.ApplicationColor;
import constant.ApplicationIconImage;
import net.miginfocom.swing.MigLayout;

/**
 * Esta clase será para presentar nuestro programa
 * y lógicamente será la primera en ejecutarse.
 * @author Ilyasse Essadak Samaali
 */
public class ScreenSplash extends Thread {
	private JFrame frMain;
	private JPanel pMain;
	private JLabel lblApp; 
	
	public ScreenSplash() {
		initComponents();
	}
	
	private void initComponents() {
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
		frMain.setIconImage(ApplicationIconImage.ICON.getIcon().getImage());
	}
	
	private void createPanel() {
		pMain = new JPanel();
		
		pMain.setBackground(ApplicationColor.BACKGROUND_COLOR.getColor());
		frMain.setContentPane(pMain);
	}
	
	private void createLabels() {
		ImageIcon scaledIconAppImage = new ImageIcon(ApplicationIconImage.ICON.getIcon()
				.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		lblApp = new JLabel("<html> ABC <br>Library </html>");
		
		pMain.setLayout(new MigLayout("", "[204.00px][260.00px][213.00px]", "[33%,top][33%,center][33%,center]"));
		lblApp.setFont(new Font("Calibri", Font.BOLD, 30));
		lblApp.setForeground(ApplicationColor.TEXT_COLOR.getColor());
		lblApp.setIcon(scaledIconAppImage);
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
