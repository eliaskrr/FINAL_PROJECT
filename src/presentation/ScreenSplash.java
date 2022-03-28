package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenSplash extends Thread {

	private JFrame frScreenSplash;
	private JPanel pScreenSplash;
	private JLabel lbAppIcon;
	private JLabel lbLoading;
	private ImageIcon iconApp;

	public void run() {
		// Marco
		frScreenSplash = new JFrame();
		// Panel
		pScreenSplash = new JPanel();
		// Etiquetas
		lbAppIcon = new JLabel("<html>ABC <br>Library</html>");
		lbLoading = new JLabel("Cargando...");
		
		// Imagen escalada
		iconApp = new ImageIcon(new ImageIcon("./resources/app_icon.png")
				.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		
		// Crea la ventana de carga
		createSplashScreen();
	}

	private void createSplashScreen() {
		// Crea un nuevo marco
		createFrame();
		// Crea un nuevo panel
		createPanel();
		// Muestra el marco
		frScreenSplash.setVisible(true);
		// Cierra la ventana ("marco")
		closeFrame();
	}

	private void createFrame() {
		frScreenSplash.setSize(600, 300);
		// Cambia el icono del programa
		frScreenSplash.setIconImage(iconApp.getImage());
		// Centra la ventana
		frScreenSplash.setLocationRelativeTo(null);
		// Elimina la barra del t�tulo
		frScreenSplash.setUndecorated(true);
		// Apaga el programa una vez cerrada la ventana
		frScreenSplash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createPanel() {
		// Tipo de layout
		pScreenSplash.setLayout(new BorderLayout());
		pScreenSplash.setBackground(Color.decode("#960018"));
		
		// Agrega los elementos al panel
		addLabelsToPanel();

		// Agrega el panel al marco
		frScreenSplash.getContentPane().add(pScreenSplash);
	}
	
	private void addLabelsToPanel() {
		// Crea las etiquetas
		createAppIconLabel();
		createLoadingLabel();
	}

	private void createAppIconLabel() {
		Font fntAppIcon = new Font("Times New Roman", Font.PLAIN, 30);
		
		// Agrega la fuente
		lbAppIcon.setFont(fntAppIcon);
		// Color del texto
		lbAppIcon.setForeground(Color.decode("#DACA84"));
		// Agrega la imagen icono
		lbAppIcon.setIcon(iconApp);
		// Margen de separaci�n entre el texto y el icono
		lbAppIcon.setIconTextGap(25);
		// Alinea horizonalmente el panel
		lbAppIcon.setHorizontalAlignment(JLabel.CENTER);
		
		/* 
		 * Agrega la etiqueta al panel
		 * y centra verticalmente el panel
		 */
		pScreenSplash.add(lbAppIcon, BorderLayout.CENTER);
	}

	private void createLoadingLabel() {
		Font fntLoading = new Font("Times New Roman", Font.PLAIN, 18);
		
		// Agrega la fuente
		lbLoading.setFont(fntLoading);
		// Color del texto
		lbLoading.setForeground(Color.decode("#DACA84"));
		// Margénes de seraración
		lbLoading.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
		
		/*
		 *  Agrega la etiqueta al panel y 
		 *  la pone en la esquina inferior izquierda
		 */
		pScreenSplash.add(lbLoading, BorderLayout.PAGE_END);
		
	}

	private void closeFrame() {
		try {
			this.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frScreenSplash.dispose();
	}
}
