package login;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame {

	private JPanel pLogin;
	private JLabel lbUser;
	private JLabel lbPassword;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private Button btOk;
	private GridBagConstraints gbc;
	private ImageIcon iconApp;
	private Font fntGeneral = new Font("Times New Roman", Font.PLAIN, 18); 
	
	public void openWindow() {
		pLogin = new JPanel();
		lbUser = new JLabel("Usuario/Email:");		
		lbPassword = new JLabel("Contraseña:");
		txtUser = new JTextField();
		txtPassword = new JPasswordField();
		btOk = new Button();
		gbc = new GridBagConstraints();
		// Imagen escalada
		iconApp = new ImageIcon(new ImageIcon("./resources/app_icon.png")
				.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		
		// Crea el marco
		createFrame();
	}
	
	private void createFrame() {
		setSize(1000, 700);
		// Centraliza la ventana
		setLocationRelativeTo(null);
		// Máximiza la ventana por defecto
		setExtendedState(MAXIMIZED_BOTH);
		// Agrega icono
		setIconImage(iconApp.getImage());
		// Cierre por defecto
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Crea el panel
		createPanel();
		
		// Muestra la ventana
		setVisible(true);
	}
	
	private void createPanel() {
		// Tipo de layout
		pLogin.setLayout(new GridBagLayout());
		// Color de fondo
		pLogin.setBackground(Color.decode("#960018"));
		
		// Agrega lo elementos al panel
		addElementsToPanel();
		
		// Agrega el panel al marco
		getContentPane().add(pLogin);
	}
	
	private void addElementsToPanel() {
		createUserTextBox();
		createPasswordTextBox();
	}
	
	private void createUserTextBox() {
		lbUser.setFont(fntGeneral);
		lbUser.setForeground(Color.decode("#DACA84"));
		
		// Posicionamiento
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		pLogin.add(lbUser, gbc);
	}
	
	private void createPasswordTextBox() {
		lbPassword.setFont(fntGeneral);
		lbPassword.setForeground(Color.decode("#DACA84"));
		
		// Posicionamiento
		gbc.gridy = 1;
		
		pLogin.add(lbPassword, gbc);
		
	}
	
}
