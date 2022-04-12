package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import programm.AlumnoWindow;
import net.miginfocom.swing.MigLayout;

public class Login extends JFrame {
	
	private JPanel pMain;
	private JTextField txtUser;
	private JPasswordField passUser;
	private ImageIcon iconApp;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JButton btAcept;
	private JButton btCancel;

	public static void main(String[] args) {
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
	}
	
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
		txtUser = new JTextField();
		txtUser.setColumns(10);
		
		// Cuadro de texto contraseña
		passUser = new JPasswordField();
	}
	
	private void createButtons() {
		// Botones
		btAcept = new JButton("ACEPTAR");
		btCancel = new JButton("CANCELAR");
		
		
		// Acción al aceptar
		btAcept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlumnoWindow alumnoWindow = new AlumnoWindow();
				Database database = new Database(txtUser.getText(), 
						String.valueOf(passUser.getPassword()));
				
				/* 
				 * Comprueba si existe usuario y abre la ventana para
				 * según el tipo de usuario logueado 
				 */
				if (database.isUser()) {
					if (database.getUserType().equals("alumno")) {
						alumnoWindow.openWindow();
						// Cierra la ventana actual
						dispose();
					}
					else if (database.getUserType().equals("profesor")){
						
					}
					else {
						
					}
				}
				else {
					System.out.println("No existe");
				}
			}
		});
		
		// Acción al cancelar
		btCancel.addActionListener(new ActionListener() {
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
		pMain.add(btCancel, "cell 3 2,alignx leading,aligny baseline");
	}
}
