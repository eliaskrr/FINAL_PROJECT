package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import teacher_window.TeacherWindow;

/**
 * En esta clase se realizará el logueo del usuario (alumno, profesor o admin)
 * que podrá acceder a su ventana en concreto.
 * @author Ilyasse Essadak Samaali
 */
public class Login extends JFrame {
	private JPanel pMain;
	private JTextField txtUser;
	private JPasswordField passUser;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JButton btCancel;
	private JButton btAcept;
	private JLabel lblIconApp;
	private JLabel lblLogin;
	private JLabel lblErrorMessage;

	public Login() {
		initComponents();
	}

	public void initComponents() {
		createFrame();
		createPanel();
		createLabels();
		createTextFields();
		createButtons();
		configureLayout();
		// Agrega evento de teclado al frame
		addKeyListener(getKeyListener());
		// Muestra el frame
		setVisible(true);
		
	}
	
	private void createFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setIconImage(ApplicationIconImage.ICON.getIcon().getImage());
	}

	private void createPanel() {
		pMain = new JPanel();
		pMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pMain.setBackground(ApplicationColor.BACKGROUND_COLOR.getColor());
		// Agrega el panel al marco
		setContentPane(pMain);
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
		lblUser = new JLabel("Usuario:");
		lblUser.setFont(new Font("Calibri", Font.BOLD, 16));
		lblUser.setForeground(ApplicationColor.TEXT_COLOR.getColor());
		
		// Texto contraseña
		lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPassword.setForeground(ApplicationColor.TEXT_COLOR.getColor());
		
		// Mensaje error
		lblErrorMessage = new JLabel();
		lblErrorMessage.setFont(new Font("Arial", Font.BOLD, 16));
		lblErrorMessage.setForeground(ApplicationColor.ERROR_MESSAGE_COLOR.getColor());
		
		setFocusable(true);
		requestFocus();

	}

	private void createTextFields() {
		// Cuadro de texto usuario
		txtUser = new JTextField();
		txtUser.setFocusable(true);
		txtUser.setFont(new Font("Calibri", Font.PLAIN, 14));
		// Agrega evento de teclado
		txtUser.addKeyListener(getKeyListener());

		// Cuadro de texto contraseña
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
			 * Usamos los dos primeros métodos para darle sensación
			 * de botón al label
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

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
				// Acción al pulsar la tecla ENTER
				if (e.getKeyCode() == KeyEvent.VK_ENTER) checkUserExists();
				// Acción al pulsar la tecla ESC
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
		LoginDatabase database = new LoginDatabase(txtUser.getText(), String.valueOf(passUser.getPassword()));
		TeacherWindow teacher;
		
		// Comprueba que no hayan espacios en blanco
		if (!txtUser.getText().isBlank() && !String.valueOf(passUser.getPassword()).isBlank()) {
			// Checkea si existe usuario y se loguea
			if (database.isUser()) {
				// Cierra la ventana y se loguea como usuario
				if (database.getUserType().equals("alumno")) {
					
					dispose();
				}
				else if (database.getUserType().equals("profesor")) {
					teacher = new TeacherWindow();
					dispose();
				}
				else {
					
					dispose();
				}
			} else lblErrorMessage.setText("¡Error en el usuario o contraseña!");
			
		}
		else lblErrorMessage.setText("¡Error al dejar campos vacíos!");
	}

	private void createCancelButton() {
		btCancel = new JButton("Cancelar");
		btCancel.setBackground(ApplicationColor.BUTTON_BACKGROUND_COLOR.getColor());
		btCancel.setForeground(ApplicationColor.BUTTON_TEXT_COLOR.getColor());

		btCancel.addMouseListener(new MouseAdapter() {
			/*
			 * Usamos los dos primeros métodos para darle sensación
			 * de botón al label
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// Cierra el programa
				System.exit(0);
			}
		});
	}
	

	private void configureLayout() {
		pMain.setLayout(new MigLayout("", "[18.75%][49.13%][19.63%][16.50%]", "[115.00][17.50%][18.25%][74.00][31.50%]"));
		pMain.add(lblIconApp, "cell 0 0,alignx center,aligny bottom");
		pMain.add(lblLogin, "cell 1 0,alignx left,aligny bottom");
		pMain.add(lblUser, "cell 0 1,alignx center,aligny bottom");
		pMain.add(lblPassword, "cell 0 2,alignx center,aligny bottom");
		pMain.add(passUser, "cell 1 2,growx,aligny bottom");
		pMain.add(txtUser, "cell 1 1,growx,aligny bottom");
		pMain.add(lblErrorMessage, "cell 1 3,alignx left,aligny center");
		pMain.add(btAcept, "cell 2 4,alignx center,aligny center");
		pMain.add(btCancel, "cell 3 4,alignx center,aligny center");
	}

}
