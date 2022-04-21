package main;
import javax.swing.UIManager;

import window.login.Login;
import window.login.ScreenSplash;

/**
 * En esta clase se iniciará el programa.
 * @author Ilyasse Essadak Samaali
 */
public class ABCLibrary {

	public static void main(String[] args) throws InterruptedException, Exception {
		ScreenSplash screenSplash;
		Login login;
		
		// Agregamos un tema a la app
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		
		// Inicia la ventana de presentación (hilo)
//		screenSplash = new ScreenSplash();
		// Espera a que finalice el hilo
//		screenSplash.join();
		
		// Abre la ventana para loguearse
		login = new Login();
	}
		
}
