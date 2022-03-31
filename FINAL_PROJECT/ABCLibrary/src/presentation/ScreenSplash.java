package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class ScreenSplash extends JFrame {

	private JPanel pMain;
	private JLabel lblApp; 
	private JLabel lblLoading;
	private JLabel lblAuthors;
	private ImageIcon iconApp;
	
	public ScreenSplash() {
		iconApp = new ImageIcon(new ImageIcon(".\\resources\\app_icon.png").getImage()
				.getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		// Cierra la ejecución por defecto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Dimensión del marco
		setSize(600, 300);
		// Elimina la barra de título
		setUndecorated(true);
		// Centra la ventana
		setLocationRelativeTo(null);
		setIconImage(iconApp.getImage());
	}
	
	public void showWindow() {
		createPanel();
		createAppLabel();
		createLoadingLabel();
		createAuthorsLabel();
		setVisible(true);
		closeWindow();
	}
	
	private void createPanel() {
		pMain = new JPanel();
		pMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pMain.setBackground(Color.decode("#960018"));
		setContentPane(pMain);
		pMain.setLayout(new MigLayout("", "[590px]", "[249px][41px]"));
	}
	
	private void createAppLabel() {
		lblApp = new JLabel(
				"<html>" + 
				"ABC <br>Library" + 
				"</html>");
		lblApp.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblApp.setForeground(Color.decode("#DACA84"));
		lblApp.setIcon(iconApp);
		// Margen de separción entre el texto y la imagen
		lblApp.setIconTextGap(25);
		// Centra horizontalmente la etiquete
		lblApp.setHorizontalAlignment(JLabel.CENTER);

		// Agrega al panel
		pMain.add(lblApp, "cell 0 0,grow");
	}
	
	private void createLoadingLabel() {
		lblLoading = new JLabel("Loading...");
		lblLoading.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLoading.setForeground(Color.decode("#DACA84"));
		// Margénes de seraración
		lblLoading.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
		
		// Agrega al panel
		pMain.add(lblLoading, "flowx,cell 0 1,growx,aligny top");
	}
	

	private void createAuthorsLabel() {
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
		pMain.add(lblAuthors, "cell 0 1 1 2,alignx right,aligny bottom");
	}
	
	private void closeWindow() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispose();
	}
	
}