package constant;

import java.awt.Color;

/**
 * Constantes de colores utilizadas para el diseño
 * @author Ilyasse Essadak Samaali
 */
public enum ApplicationColor {
	BACKGROUND_COLOR(Color.decode("#AB0101")),
	TEXT_COLOR(Color.decode("#FFFFFF")),
	ERROR_MESSAGE_COLOR(Color.decode("#030101")),
	BUTTON_BACKGROUND_COLOR(Color.decode("#FFFFFF")),
	BUTTON_TEXT_COLOR(Color.decode("#000000"));
	
	private Color color;
	
	private ApplicationColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
}
