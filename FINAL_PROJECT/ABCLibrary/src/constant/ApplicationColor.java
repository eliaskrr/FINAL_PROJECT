package constant;

import java.awt.Color;

/**
 * Este enum contiene los colores que vamos a 
 * utilizar en nuestra aplicación.
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
