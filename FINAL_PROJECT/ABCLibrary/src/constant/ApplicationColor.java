package constant;

import java.awt.Color;

/*
 * Este enum contiene los colores que vamos a utilizar en nuestra
 * aplicación
 */
public enum ApplicationColor {
	BLACK(Color.decode("#1E1818")),
	WHITE(Color.decode("#FFFFFF")),
	RED(Color.decode("#AA0707"));
	
	private Color color;
	
	private ApplicationColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
}
