package teacher_window;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constant.ApplicationColor;
import constant.ApplicationIconImage;

/**
 * Esta clase muestra la ventana del profesor.
 * @author Ilyasse Essadak Samaali
 */
public class TeacherWindow extends JFrame {

	private JPanel pMain = new JPanel();

	public TeacherWindow() {
		initComponents();
	}

	
	public void initComponents() {
		createFrame();
		createPanel();
		setVisible(true);
	}

	public void createFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
	}

	private void createPanel() {
		pMain = new JPanel();

		pMain.setBackground(ApplicationColor.BACKGROUND_COLOR.getColor());
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
