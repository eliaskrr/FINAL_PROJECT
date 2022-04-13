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

import assistant.Images;
import assistant.Style;
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
	private JLabel lblUser;
	private JLabel lblPassword;
	private JButton btAcept;
	private JButton btSalir;
	private Style style;
	private Images image;

	public Login() {
		createWindow();
	}

	private void createWindow() {
		style = new Style();
		image = new Images();
		
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
		setIconImage(image.getIconApp().getImage());
	}

	private void createPanel() {
		pMain = new JPanel();

		pMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pMain.setBackground(style.getRedColor());
		// Agrega el panel al marco
		setContentPane(pMain);
	}

	private void createLabels() {
		// Label usuario
		lblUser = new JLabel("Usuario:");
		lblUser.setFont(new Font("Calibri", Font.BOLD, 14));
		lblUser.setForeground(style.getYellowColor());

		// Label contraseña
		lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPassword.setForeground(style.getYellowColor());

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
		btAcept.setFont(new Font("Calibri", Font.BOLD, 10));
		btAcept.setBackground(style.getYellowColor());
		
		// Acción al pulsar el botón
		tryLogging();

		// Botón aceptar
		btSalir = new JButton("SALIR");
		btSalir.setFont(new Font("Calibri", Font.BOLD, 10));
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
					//System.out.println("No existe");
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
