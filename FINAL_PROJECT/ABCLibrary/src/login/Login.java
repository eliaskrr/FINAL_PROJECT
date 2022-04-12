package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import components.StyleButtonUI;
import net.miginfocom.swing.MigLayout;
import users_windows.AlumnoWindow;

/**
 * En esta clase se realizará el logueo del usuario (alumno, profesor o admin)
 * que podrá acceder a su ventana en concreto
 */
public class Login extends JFrame {

	private JPanel pMain;
	private JTextField txtUser;
	private JPasswordField passUser;
	private ImageIcon iconApp;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JButton btAcept;
	private JButton btSalir;

	public Login() {
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
		iconApp = new ImageIcon(
				new ImageIcon(".\\res\\icon.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

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
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUser.setForeground(Color.decode("#DACA84"));

		// Label contraseña
		lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setForeground(Color.decode("#DACA84"));

	}

	private void createTextFields() {
		// Cuadro de texto usuario
		txtUser = new JTextField();

		// Cuadro de texto contraseña
		passUser = new JPasswordField();
	}

	private void createButtons() {
		// Botón salir
		btAcept = new JButton("ACEPTAR");
		btAcept.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btAcept.setUI(new StyleButtonUI());
		// Acción al pulsar el botón
		tryLogging();

		// Botón aceptar
		btSalir = new JButton("SALIR");
		btSalir.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btSalir.setUI(new StyleButtonUI());		
		// Acción al pulsar el botón
		exitApplication();
	}

	public void tryLogging() {
		btAcept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlumnoWindow alumnoWindow;
				Database database = new Database(txtUser.getText(), String.valueOf(passUser.getPassword()));

				// Comprueba si existe el usuario y abre su ventna
				if (database.isUser()) {
					if (database.getUserType().equals("alumno")) {
						// Abre la ventana del alumno
						alumnoWindow = new AlumnoWindow();
						// Cierra la ventana del login
						dispose();
					} else if (database.getUserType().equals("profesor")) {

					} else {

					}
				} else {
					System.out.println("No existe");
				}
			}
		});
	}
	
	private void exitApplication() {
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cierra la ventana
				dispose();
			}
		});
	}

	private void configureLayout() {
		pMain.setLayout(new MigLayout("", "[25%][25%][25%][25%]", "[33%][33%][33%]"));
		pMain.add(lblUser, "cell 0 0,alignx center,aligny bottom");
		pMain.add(lblPassword, "cell 0 1,alignx center,aligny center");
		pMain.add(passUser, "cell 1 1,growx,aligny center");
		pMain.add(txtUser, "cell 1 0,growx,aligny bottom");
		pMain.add(btAcept, "cell 2 2,alignx center,aligny center");
		pMain.add(btSalir, "cell 3 2,alignx leading,aligny baseline");
	}
}
