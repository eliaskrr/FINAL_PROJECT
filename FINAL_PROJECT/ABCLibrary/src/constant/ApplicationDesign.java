package constant;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicComboPopup;

/**
 * Clase mediante la cual implementamos el diseño de la interfaz 
 * @author Ilyasse Essadak Samaali
 */
public class ApplicationDesign {
	
	public ApplicationDesign() {}

	public static void addNewTheme() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	public static void changeSelectedTextBackgroundColor(JComboBox comboBox, Color color) {
		Object child = comboBox.getAccessibleContext().getAccessibleChild(0);
		BasicComboPopup popup = (BasicComboPopup)child;
		JList list = popup.getList();
		list.setSelectionBackground(color);
	}
}
