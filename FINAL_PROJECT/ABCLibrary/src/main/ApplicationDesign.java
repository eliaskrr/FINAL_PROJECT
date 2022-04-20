package main;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboPopup;

public class ApplicationDesign {
	
	public ApplicationDesign() {}

	public static void changeSelectedTextBackgroundColor(JComboBox comboBox, Color color) {
		Object child = comboBox.getAccessibleContext().getAccessibleChild(0);
		BasicComboPopup popup = (BasicComboPopup)child;
		JList list = popup.getList();
		list.setSelectionBackground(color);
	}
}
