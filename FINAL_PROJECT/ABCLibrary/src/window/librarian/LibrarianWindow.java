package window.librarian;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import constant.ApplicationIconImage;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
public class LibrarianWindow extends JFrame implements ActionListener {

	private JPanel pMain = new JPanel();
    private JMenuBar barra_menu;
    private JMenu inicio, tematicas, perfil, informacion;
    private JMenuItem arte, ciencia, idiomas, musica, cocina, miPerfil, cambiarCl, cerrarSesion, salir, app, desarrolladores;

	public LibrarianWindow() {
		initComponents();
	}
	
	private void initComponents() {
        createFrame();
        createMenu();
        this.setVisible(true);
	}
	
	private void createFrame() {
		this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(ApplicationIconImage.ICON.getIcon().getImage());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
	}
	
	private void createMenu() {
		barra_menu = new JMenuBar();
        setJMenuBar(barra_menu);
        
        inicio = new JMenu("Home");
        barra_menu.add(inicio);
        
        tematicas = new JMenu("Temáticas");
        barra_menu.add(tematicas);
        
        informacion = new JMenu("Información");
        barra_menu.add(informacion);
        
        perfil = new JMenu("Perfil");
        barra_menu.add(perfil);

        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        barra_menu.add(salir);
        
        arte = new JMenuItem("Arte");
        arte.addActionListener(this);
        tematicas.add(arte);
        
        ciencia = new JMenuItem("Ciencia");
        ciencia.addActionListener(this);
        tematicas.add(ciencia);
        
        idiomas = new JMenuItem("Idiomas");
        idiomas.addActionListener(this);
        tematicas.add(idiomas);
        
        musica = new JMenuItem("Música");
        musica.addActionListener(this);
        tematicas.add(musica);
        
        cocina = new JMenuItem("Cocina");
        cocina.addActionListener(this);
        tematicas.add(cocina);
        
        app = new JMenuItem("De la Aplicación");
        app.addActionListener(this);
        informacion.add(app);
        
        desarrolladores = new JMenuItem("De los Desarrolladores");
        desarrolladores.addActionListener(this);
        informacion.add(desarrolladores);
        
        miPerfil = new JMenuItem("Mi Perfil");
        miPerfil.addActionListener(this);
        perfil.add(miPerfil);
        
        cambiarCl = new JMenuItem("Cambiar Clave");
        cambiarCl.addActionListener(this);
        perfil.add(cambiarCl);
        
        cerrarSesion = new JMenuItem("Cerrar Sesion");
        cerrarSesion.addActionListener(this);
        perfil.add(cerrarSesion);
	}
	
	public void actionPerformed(ActionEvent e) {
		
        if (e.getSource() == salir) {
        	System.exit(0);
        }
        if (e.getSource() == app) {
        	
            String texto = "Esta aplicación consiste en un gestor de libros de Biblioteca.\n"
            		+ "Esta realizado por tres alumnos del grado superior de DAM\n"
            		+ "Para mas información contacte con el administrador.";
        	 JOptionPane.showMessageDialog(app, texto, "Información sobre la Aplicación", 1);
        }
        if (e.getSource() == desarrolladores) {
        	
         String texto = "Los Desarrolladores de esta aplicación son: \n"
         		+ "- Ilyasse Essadak Samaali \n- Diego \n- Jose María";
       	 JOptionPane.showMessageDialog(desarrolladores, texto, "Información sobre los Desarrolladores", 1);
        } 
    }

//	public void createFrame() {
//		this.setIconImage(ApplicationIconImage.ICON.getIcon().getImage());
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(800, 800);
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		this.setLocationRelativeTo(null);
//	}
//
//	private void createPanel() {
//		pMain = new JPanel();
//
//		pMain.setBackground(ApplicationColor.BACKGROUND_COLOR.getColor());
//		this.setContentPane(pMain);
//		pMain.setLayout(new MigLayout("", "[100%]", "[22px]"));
//		
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setBackground(Color.MAGENTA);
//		pMain.add(menuBar, "cell 0 0,growx,aligny top");
//	}
}