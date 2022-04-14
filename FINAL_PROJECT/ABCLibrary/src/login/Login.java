package login;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import constant.ApplicationColor;
import constant.ApplicationIconImage;
import net.miginfocom.swing.MigLayout;

/**
 * En esta clase se realizará el logueo del usuario (alumno, profesor o admin)
 * que podrá acceder a su ventana en concreto
 */
public class Login extends JFrame {
	private JPanel pMain;
	private JTextField txtUser;
	private JPasswordField passUser;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel btCancel;
	private JLabel btAcept;

	public Login() {
		//openWindow();
	}

	public void openWindow() {
		createFrame();
		createPanel();
		createLabels();
		createTextFields();
		createButtons();
		configureLayout();
		// Muestra la ventana
		setVisible(true);
	}

	private void createFrame() {
		setTitle("LIBRARY ABC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(ApplicationIconImage.ICON.getIcon().getImage());
	}

	private void createPanel() {
		pMain = new JPanel();

		pMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pMain.setBackground(ApplicationColor.RED.getColor());
		// Agrega el panel al marco
		setContentPane(pMain);
	}

	private void createLabels() {
		// Label usuario
		lblUser = new JLabel("Usuario:");
		lblUser.setFont(new Font("Calibri", Font.BOLD, 14));
		lblUser.setForeground(ApplicationColor.YELLOW.getColor());

		// Label contraseña
		lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPassword.setForeground(ApplicationColor.YELLOW.getColor());

	}

	private void createTextFields() {
		// Cuadro de texto usuario
		txtUser = new JTextField();

		// Cuadro de texto contraseña
		passUser = new JPasswordField();
	}

	private void createButtons() {
		createAceptButton();
		createCancelButton();
	}
	
	public void createAceptButton() {
		ImageIcon scaledPrimaryAceptButton = new ImageIcon(ApplicationIconImage.ACEPT_PRIMARY_BUTTON.getIcon()
				.getImage().getScaledInstance(70, 35, Image.SCALE_SMOOTH));
		ImageIcon scaledSecondaryAceptButton = new ImageIcon(ApplicationIconImage.ACEPT_SECONDARY_BUTTON.getIcon()
				.getImage().getScaledInstance(70, 35, Image.SCALE_SMOOTH));
		btAcept = new JLabel(scaledPrimaryAceptButton);
		
		btAcept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btAcept.setIcon(scaledSecondaryAceptButton);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btAcept.setIcon(scaledPrimaryAceptButton);
			}
		});
		// Acción al pulsar el botón
		tryLogging();
	}
	
	private void createCancelButton() {
		ImageIcon scaledPrimaryCancelButton = new ImageIcon(ApplicationIconImage.CANCEL_PRIMARY_BUTTON.getIcon()
				.getImage().getScaledInstance(70, 35, Image.SCALE_SMOOTH));
		ImageIcon scaledSecondaryCancelButton = new ImageIcon(ApplicationIconImage.CANCEL_SECONDARY_BUTTON.getIcon()
				.getImage().getScaledInstance(70, 35, Image.SCALE_SMOOTH));
		btCancel = new JLabel(scaledPrimaryCancelButton);
		
		btCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btCancel.setIcon(scaledSecondaryCancelButton);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btCancel.setIcon(scaledPrimaryCancelButton);
			}
		});
		
		// Acción al pulsar el botón
		exitApplication();
	}

	public void tryLogging() {
		
	}
	
	private void exitApplication() {
		
	}

	private void configureLayout() {
		pMain.setLayout(new MigLayout("", "[25%][25%][25%][25%]", "[33%][33%][33%]"));
		pMain.add(lblUser, "cell 0 0,alignx center,aligny bottom");
		pMain.add(lblPassword, "cell 0 1,alignx center,aligny center");
		pMain.add(passUser, "cell 1 1,growx,aligny center");
		pMain.add(txtUser, "cell 1 0,growx,aligny bottom");
		pMain.add(btAcept, "cell 2 2,alignx center,aligny center");
		pMain.add(btCancel, "cell 3 2,alignx leading,aligny baseline");
	}
}
