package login;

import java.awt.Color;
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

public class Login extends JFrame {
	
	private JPanel pMain;
	private JTextField txtUser;
	private JPasswordField passUser;
	private ImageIcon iconApp;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JButton btAcept;
	private JButton btCancel;
	private GroupLayout gl_pMain;

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
				
				// Comprueba si existe usuario
				if (database.isUser()) {
					// Abre la ventana para usuario
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
		gl_pMain = new GroupLayout(pMain);
		gl_pMain.setHorizontalGroup(
			gl_pMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pMain.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_pMain.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPassword))
					.addGap(27)
					.addGroup(gl_pMain.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passUser)
						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(409, Short.MAX_VALUE))
				.addGroup(gl_pMain.createSequentialGroup()
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
						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_pMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_pMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(btAcept)
						.addComponent(btCancel))
					.addContainerGap())
		);
		// Agrega la configuración del layout al panel
		pMain.setLayout(gl_pMain);
	}
}
