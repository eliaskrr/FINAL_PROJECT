import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenSplash extends Thread {

	private JFrame frScreenSplash;
	private JPanel pScreenSplash;
	private JLabel lbAppName;
	private JLabel lbLoading;
	private GridBagConstraints gbc;
	private ImageIcon iconApp;

	public void run() {
		// Marco
		frScreenSplash = new JFrame();
		// Panel
		pScreenSplash = new JPanel();
		// Etiquetas
		lbAppName = new JLabel("<html>ABC <br>Library</html>");
		lbLoading = new JLabel("Loading");
		// Estructura el layout
		gbc = new GridBagConstraints();
		
		// Imagen escalada
		iconApp = new ImageIcon(new ImageIcon("./resources/app_icon.png")
				.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		
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
		// Agrega los elementos al panel
		addLabelsToPanel();

		// Tipo de layout
		pScreenSplash.setLayout(new GridBagLayout());
		pScreenSplash.setBackground(Color.decode("#B22222"));

		// Agrega el panel al marco
		frScreenSplash.getContentPane().add(pScreenSplash);
	}
	
	private void addLabelsToPanel() {
		// Crea las etiquetas
		createAppNameLabel();
		createLoadingLabel();
	}

	private void createAppNameLabel() {
		Font fAppName = new Font("Times New Roman", Font.PLAIN, 30);
		
		// Agrega la fuente
		lbAppName.setFont(fAppName);
		// Color del texto
		lbAppName.setForeground(Color.decode("#E5CD24"));
		// Agrega la imagen icono
		lbAppName.setIcon(iconApp);
		// Margen de separaci�n entre el texto y el icono
		lbAppName.setIconTextGap(20);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.WEST;
		
		// Agrega la etiqueta al panel
		pScreenSplash.add(lbAppName, gbc);
	}

	private void createLoadingLabel() {
		Font fLoading = new Font("Times New Roman", Font.PLAIN, 15);
		
		// Agrega la fuente
		lbLoading.setFont(fLoading);
		// Color del texto
		lbLoading.setForeground(Color.decode("#00000"));
		
		gbc.gridy = 1;
		
		// Agrega la etiqueta al panel
		pScreenSplash.add(lbLoading, gbc);
	}

	private void closeFrame() {
		try {
			this.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frScreenSplash.dispose();
	}
}
