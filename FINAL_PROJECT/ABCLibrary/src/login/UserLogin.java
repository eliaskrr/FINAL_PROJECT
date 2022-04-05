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

public class UserLogin extends JFrame {

	private JPanel pMain;
	private JTextField txtfUser;
	private JPasswordField passwordUser;
	private ImageIcon iconApp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLogin() {
		iconApp = new ImageIcon(new ImageIcon(".\\resources\\icon.png").getImage()
				.getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		
		setTitle("LIBRARY ABC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(iconApp.getImage());
		pMain = new JPanel();
		pMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pMain.setBackground(Color.decode("#960018"));
		setContentPane(pMain);
		
		JLabel lblUser = new JLabel("Usuario:");
		lblUser.setForeground(Color.decode("#DACA84"));
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setForeground(Color.decode("#DACA84"));
		
		txtfUser = new JTextField();
		txtfUser.setColumns(10);
		
		passwordUser = new JPasswordField();
		
		JButton btAcept = new JButton("ACEPTAR");
		JButton btCancel = new JButton("CANCELAR");
		
		GroupLayout gl_pMain = new GroupLayout(pMain);
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
		pMain.setLayout(gl_pMain);
	}
	
}
