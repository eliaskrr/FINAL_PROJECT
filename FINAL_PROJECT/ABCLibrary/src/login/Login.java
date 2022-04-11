package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel pMain;
	private JTextField txtfUser;
	private JPasswordField passwordUser;
	private ImageIcon iconApp;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JButton btAcept;
	private JButton btCancel;
	private GroupLayout gl_pMain;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		createWindow();
	}*/
	
	public void openWindow() {
		createWindow();
	}
	
	private void createWindow() {
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
		// Imagen de la app
		iconApp = new ImageIcon(new ImageIcon(".\\resources\\icon.png").getImage()
				.getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		
		setTitle("LIBRARY ABC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(iconApp.getImage());
	}
	
	private void createPanel() {
		pMain = new JPanel();
		
		pMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pMain.setBackground(Color.decode("#960018"));
		// Agrega el panel al marco
		setContentPane(pMain);
	}
	
	private void createLabels() {
		// Label usuario
		lblUser = new JLabel("Usuario:");
		lblUser.setForeground(Color.decode("#DACA84"));
		
		// Label contraseña
		lblPassword = new JLabel("Contraseña:");
		lblPassword.setForeground(Color.decode("#DACA84"));
		
	}
	
	private void createTextFields() {
		// Cuadro de texto usuario
		txtfUser = new JTextField();
		txtfUser.setColumns(10);
		
		// Cuadro de texto contraseña
		passwordUser = new JPasswordField();
	}
	
	private void createButtons() {
		btAcept = new JButton("ACEPTAR");
		
		btCancel = new JButton("CANCELAR");
	}
	
	private void configureLayout() {
		gl_pMain = new GroupLayout(pMain);
		
		gl_pMain.setHorizontalGroup(
			gl_pMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pMain.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_pMain.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPassword))
					.addGap(27)
					.addGroup(gl_pMain.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordUser)
						.addComponent(txtfUser, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(409, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_pMain.createSequentialGroup()
					.addContainerGap(444, Short.MAX_VALUE)
					.addComponent(btAcept)
					.addGap(38)
					.addComponent(btCancel)
					.addGap(138))
		);
		
		gl_pMain.setVerticalGroup(
			gl_pMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pMain.createSequentialGroup()
					.addGap(122)
					.addGroup(gl_pMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUser)
						.addComponent(txtfUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_pMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_pMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(btAcept)
						.addComponent(btCancel))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		// Agrega la configuración del layout al panel
		pMain.setLayout(gl_pMain);
	}
	
}
