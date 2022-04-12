package main;
import login.Login;
import presentation.ScreenSplash;

/**
 * En esta clase se iniciará el programa
 */
public class ABCLibrary {

	public static void main(String[] args) throws InterruptedException {
		// Abre la ventana de presentación de la app
		ScreenSplash screenSplash = new ScreenSplash();
		Login login;
		
		// Espera a que finalice el hilo
		screenSplash.join();
		// Abre la ventana para loguearse
		login = new Login();
		
	}
}
