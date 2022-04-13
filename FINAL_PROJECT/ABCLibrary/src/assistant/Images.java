package assistant;

import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * Contiene las imágenes que vamos a utilizar en nuestro
 * programa
 */
public class Images {

	private ImageIcon iconApp = new ImageIcon(".\\res\\icon.png");
	private ImageIcon iconScaledApp;
	
	public ImageIcon getIconApp() {
		return iconApp;
	}

	public ImageIcon getIconScaledApp() {
		return iconScaledApp;
	}
	
	public void setIconScaledApp(int width, int height, int imageScale) {
		iconScaledApp = new ImageIcon(iconApp.getImage()
				.getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
	
}
