package constant;

import javax.swing.ImageIcon;

/*
 * Este enum contiene las imágenes que vamos a utilizar en nuestra
 * aplicación
 */
public enum ApplicationIconImage {
	ICON(new ImageIcon(".\\res\\icon.png")),
	ACEPT_PRIMARY_BUTTON(new ImageIcon(".\\res\\buttons\\acept_primary.png")),
	ACEPT_SECONDARY_BUTTON(new ImageIcon(".\\res\\buttons\\acept_secondary.png")),
	CANCEL_PRIMARY_BUTTON(new ImageIcon(".\\res\\buttons\\cancel_primary.png")),
	CANCEL_SECONDARY_BUTTON(new ImageIcon(".\\res\\buttons\\cancel_secondary.png")),
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
