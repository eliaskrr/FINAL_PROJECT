package window.login;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import constant.ApplicationColor;
import constant.ApplicationDesign;
import constant.ApplicationIconImage;
import net.miginfocom.swing.MigLayout;
import window.librarian.LibrarianDatabase;
import window.librarian.LibrarianWindow;

/**
 * En esta clase se realizar? el logueo del usuario (alumno, profesor o admin)
 * que podr? acceder a su ventana en concreto.
 * @author Ilyasse Essadak Samaali
 */
public class Login extends JFrame {
	private JPanel pMain;
	private JTextField txtUsername;
	private JPasswordField passUser;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btCancel;
	private JButton btAcept;
	private JLabel lblIconApp;
	private JLabel lblLogin;
	private JLabel lblErrorMessage;
	private JComboBox cbTypeUser;

	public Login() {
		initComponents();
	}

	public void initComponents() {
		createFrame();
		createPanel();
		createLabels();
		createComboBox();
		createTextFields();
		createButtons();
		configureLayout();
		// Agrega evento de teclado al frame
		addKeyListener(getKeyListener());
		// Muestra el frame
		setVisible(true);
		// Establece foco en el componente al abrir la ventana
		txtUsername.requestFocusInWindow();
	}
	
	private void createFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 400);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setIconImage(ApplicationIconImage.ICON.getIcon().getImage());
	}

	private void createPanel() {
		pMain = new JPanel();
		pMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pMain.setBackground(ApplicationColor.BACKGROUND_COLOR.getColor());
		// Agrega el panel al marco
		this.setContentPane(pMain);
	}

	private void createLabels() {
		ImageIcon iconApp = new ImageIcon(ApplicationIconImage.ICON.getIcon().getImage()
				.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		
		// Icono
		lblIconApp = new JLabel(iconApp);
		
		// Texto login
		lblLogin = new JLabel("INICIAR SESI\u00D3N");
		lblLogin.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblLogin.setForeground(ApplicationColor.TEXT_COLOR.getColor());
		
		// Texto usuario
		lblUsername = new JLabel("Usuario:");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 16));
		lblUsername.setForeground(ApplicationColor.TEXT_COLOR.getColor());
		
		// Texto contrase?a
		lblPassword = new JLabel("Contrase?a:");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPassword.setForeground(ApplicationColor.TEXT_COLOR.getColor());
		
		// Mensaje error
		lblErrorMessage = new JLabel();
		lblErrorMessage.setFont(new Font("Arial", Font.BOLD, 16));
		lblErrorMessage.setForeground(ApplicationColor.ERROR_MESSAGE_COLOR.getColor());
	}

	private void createTextFields() {
		// Cuadro de texto usuario
		txtUsername = new JTextField();
		txtUsername.setFocusable(true);
		txtUsername.setFont(new Font("Calibri", Font.PLAIN, 14));
		// Agrega evento de teclado
		txtUsername.addKeyListener(getKeyListener());

		// Cuadro de texto contrase?a
		passUser = new JPasswordField();
		passUser.setFont(new Font("Calibri", Font.PLAIN, 14));
		// Agrega evento de teclado
		passUser.addKeyListener(getKeyListener());
	}

	private void createButtons() {
		createAceptButton();
		createCancelButton();
	}

	public void createAceptButton() {
		btAcept = new JButton("Aceptar");
		btAcept.setBackground(ApplicationColor.BUTTON_BACKGROUND_COLOR.getColor());
		btAcept.setForeground(ApplicationColor.BUTTON_TEXT_COLOR.getColor());
		
		btAcept.addMouseListener(new MouseAdapter() {
			/*
			 * Usamos los dos primeros m?todos para darle sensaci?n
			 * de bot?n al label
			 */

			@Override
			public void mouseClicked(MouseEvent e) {
				checkUserExists();
			}
		});
	}
	
	private KeyListener getKeyListener() {
		KeyListener listener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Acci?n al pulsar la tecla ENTER
				if (e.getKeyCode() == KeyEvent.VK_ENTER) checkUserExists();
				// Acci?n al pulsar la tecla ESC
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);;
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
		};
		return listener;
	}
	
	private void checkUserExists() {
		String selectedItemComboBox = String.valueOf(cbTypeUser.getSelectedItem());
		String usarnameText = txtUsername.getText();
		String passwordText = String.valueOf(passUser.getPassword());
		LibrarianWindow librarianWindow;
		LibrarianDatabase librarianDatabase;
		
		// Comprueba que no hayan campos vac?os
		if (!usarnameText.isBlank() && !passwordText.isBlank()) {
			/*
			 * Seg?n el tipo de usuario elegido en el combo box, comprobar? 
			 * si existe en su respectiva BBDD
			 */
			if (cbTypeUser.getItemAt(1).equals(selectedItemComboBox)) {
				librarianDatabase = new LibrarianDatabase(usarnameText, passwordText);

				// Si existe el usuario introducido abre la ventana del bibliotecario
				if (librarianDatabase.exists()) {
					librarianWindow = new LibrarianWindow();
					dispose();
				}
				else lblErrorMessage.setText("?Error, no existe ning?n profesor con ese usuario!");
			}
			else {
				// AGREGAR AQU? EL ADMINISTRADOR
				dispose();
			}
			
		}
		else lblErrorMessage.setText("?Error al dejar campos vac?os!");
	}

	private void createCancelButton() {
		btCancel = new JButton("Cancelar");
		btCancel.setBackground(ApplicationColor.BUTTON_BACKGROUND_COLOR.getColor());
		btCancel.setForeground(ApplicationColor.BUTTON_TEXT_COLOR.getColor());

		btCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cierra el programa
				System.exit(0);
			}
		});
	}
	

	private void createComboBox() {
		String[] typesUser = {"Bibliotecario", "Administrador"};
		cbTypeUser = new JComboBox(typesUser);
		cbTypeUser.setFont(new Font("Calibri", Font.BOLD, 12));
		ApplicationDesign.changeSelectedTextBackgroundColor(cbTypeUser, 
				ApplicationColor.BACKGROUND_COLOR.getColor());
	}
	
	private void configureLayout() {
		pMain.setLayout(new MigLayout("", "[18.75%,grow][49.13%][19.63%][16.50%]", "[115.00][17.50%][18.25%][74.00][31.50%]"));
		pMain.add(lblIconApp, "cell 0 0,alignx center,aligny bottom");
		pMain.add(lblLogin, "cell 1 0,alignx left,aligny bottom");
		pMain.add(lblUsername, "cell 0 1,alignx center,aligny bottom");
		pMain.add(lblPassword, "cell 0 2,alignx center,aligny bottom");
		pMain.add(passUser, "cell 1 2,growx,aligny bottom");
		pMain.add(txtUsername, "cell 1 1,growx,aligny bottom");
		pMain.add(cbTypeUser, "cell 0 3,alignx center,aligny bottom");
		pMain.add(lblErrorMessage, "cell 1 3,alignx left,aligny center");
		pMain.add(btAcept, "cell 2 4,alignx center,aligny center");
		pMain.add(btCancel, "cell 3 4,alignx center,aligny center");
	}

}
