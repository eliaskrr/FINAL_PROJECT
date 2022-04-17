package constant;

import javax.swing.ImageIcon;

/**
 * Este enum contiene las imágenes que vamos a utilizar en nuestra
 * aplicación.
 * @author Ilyasse Essadak Samaali
 */
public enum ApplicationIconImage {
	ICON(new ImageIcon(".\\res\\icon.png")),
	MINIMIZE_PRIMARY_BUTTON(new ImageIcon(".\\res\\title_bar\\minimize_primary.png")),
	MINIMIZE_SECONDARY_BUTTON(new ImageIcon(".\\res\\title_bar\\minimize_secondary.png")),
	CROSS_PRIMARY_BUTTON(new ImageIcon(".\\res\\title_bar\\cross_primary.png")),
	CROSS_SECONDARY_BUTTON(new ImageIcon(".\\res\\title_bar\\cross_secondary.png"));
	
	private ImageIcon icon;
	
	private ApplicationIconImage(ImageIcon icon) {
		this.icon = icon;
	}
	
	public ImageIcon getIcon() {
		return icon;
	}

}
