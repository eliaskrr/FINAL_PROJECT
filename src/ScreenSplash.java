import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScreenSplash extends Thread {

	private JFrame frame;	
	private JPanel panel;
	private ImageIcon appIcon;
	
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
		frame = new JFrame();
		
		frame.setSize(600, 300);
		// Centra la ventana
		frame.setLocationRelativeTo(null);
		// Elimina la barra del título
		frame.setUndecorated(true);
		// Apaga el programa una vez cerrada la ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	}	
				
	private void addPanelToFrame() {
		panel  = new JPanel();
				
		// Tipo de layout 
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.decode("#B22222"));
		
		// Agrega el panel al marco
		frame.add(panel);
		// Muestra el marco
		frame.setVisible(true);	
	}
	
	private void closeFrame() {
		try {
			this.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.dispose();
	}
}
