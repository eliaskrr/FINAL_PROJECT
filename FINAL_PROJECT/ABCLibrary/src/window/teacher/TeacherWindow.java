package window.teacher;

import javax.swing.JFrame;
import javax.swing.JPanel;

import constant.ApplicationColor;
	
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
}
