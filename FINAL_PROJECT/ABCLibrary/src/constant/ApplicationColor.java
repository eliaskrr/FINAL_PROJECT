package constant;

import java.awt.Color;

/*
 * Este enum contiene los colores que vamos a utilizar en nuestra
 * aplicación
 */
public enum ApplicationColor {
	RED(Color.decode("#900B0B")),
	YELLOW(Color.decode("#F4F2B5"));
	
	private Color color;
	
	private ApplicationColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
}
