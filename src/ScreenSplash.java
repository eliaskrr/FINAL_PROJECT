import java.awt.Color;
import java.awt.Font;
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
	private ImageIcon iconApp;
	private Font font;

	public void run() {
		createSplashScreen();
	}

	private void createSplashScreen() {
		// Crea un nuevo marco
		createFrame();
		// Agrega el panel al marco
		addPanelToFrame();
		// Cierra la ventana ("marco")
		closeFrame();
	}

	private void createFrame() {
		frScreenSplash = new JFrame();

		frScreenSplash.setSize(600, 300);
		// Centra la ventana
		frScreenSplash.setLocationRelativeTo(null);
		// Elimina la barra del título
		frScreenSplash.setUndecorated(true);
		// Apaga el programa una vez cerrada la ventana
		frScreenSplash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addPanelToFrame() {
		pScreenSplash = new JPanel();
		
		// Agrega los elementos al panel
		addElementsToPanel();

		// Tipo de layout
		pScreenSplash.setLayout(new GridBagLayout());
		pScreenSplash.setBackground(Color.decode("#B22222"));

		// Agrega el pScreenSplash al marco
		frScreenSplash.add(pScreenSplash);
		// Muestra el marco
		frScreenSplash.setVisible(true);
	}
	
	private void addElementsToPanel() {
		// Fuente general
		font = new Font("Times New Roman", font.PLAIN, 30);
		// Crea los elementos
		createAppNameLabel();
		
		// Agrega los elementos al panel
		pScreenSplash.add(lbAppName);		
	}

	private void createAppNameLabel() {
		lbAppName = new JLabel("<html>ABC <br>Library</html>");
		iconApp = new ImageIcon(".\\resources\\app_icon.png");
		// Imagen escalada
		iconApp = new ImageIcon(new ImageIcon(".\\resources\\app_icon.png")
				.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		
		// Agrega la fuente
		lbAppName.setFont(font);
		// Color del texto
		lbAppName.setForeground(Color.decode("#E5CD24"));
		// Agrega la imagen icono
		lbAppName.setIcon(iconApp);
		// Margen de separación entre el texto y el icono
		lbAppName.setIconTextGap(20);
	}

	private void createLoadLabel() {
		lbLoading = new JLabel("Loading");
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
