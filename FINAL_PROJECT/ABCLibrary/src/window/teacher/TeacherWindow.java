package window.teacher;

import javax.swing.JFrame;
import javax.swing.JPanel;

import constant.ApplicationColor;
import constant.ApplicationIconImage;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import java.awt.Color;
	
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
		this.setIconImage(ApplicationIconImage.ICON.getIcon().getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
	}

	private void createPanel() {
		pMain = new JPanel();

		pMain.setBackground(ApplicationColor.BACKGROUND_COLOR.getColor());
		this.setContentPane(pMain);
		pMain.setLayout(new MigLayout("", "[100%]", "[22px]"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.MAGENTA);
		pMain.add(menuBar, "cell 0 0,growx,aligny top");
	}
}
