package users_windows;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constant.ApplicationColor;
import constant.ApplicationIconImage;

public class StudentWindow extends JFrame {

	private JPanel pMain = new JPanel();
	private ImageIcon iconApp;

	public StudentWindow() {}

	public void openWindow() {
		createFrame();
		createPanel();
		setVisible(true);
	}

	public void createFrame() {
		// Imagen del icono de la app
		iconApp = new ImageIcon(new ImageIcon(".\\res\\icon.png").getImage()
				.getScaledInstance(80, 80, Image.SCALE_DEFAULT));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
	}

	private void createPanel() {
		pMain = new JPanel();

		pMain.setBackground(ApplicationColor.BLACK.getColor());
		setContentPane(pMain);
		pMain.setLayout(null);
	}
	
	private void createCrossButton() {
		ImageIcon scaledPrimaryCrossButton = new ImageIcon(ApplicationIconImage.CROSS_PRIMARY_BUTTON.getIcon()
				.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		ImageIcon scaledSecondaryCrossButton = new ImageIcon(ApplicationIconImage.CROSS_SECONDARY_BUTTON.getIcon()
				.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		
	}

	private void createMinimizeButton() {
		ImageIcon scaledPrimaryMinimizeButton = new ImageIcon(ApplicationIconImage.MINIMIZE_PRIMARY_BUTTON.getIcon()
				.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		ImageIcon scaledSecondaryMinimizeButton = new ImageIcon(ApplicationIconImage.MINIMIZE_SECONDARY_BUTTON.getIcon()
				.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		
	}

}
