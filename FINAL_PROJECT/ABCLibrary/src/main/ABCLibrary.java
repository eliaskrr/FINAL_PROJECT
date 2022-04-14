package main;
import login.Login;
import presentation.ScreenSplash;

/**
 * En esta clase se iniciar� el programa
 */
public class ABCLibrary {

	public static void main(String[] args) throws InterruptedException {
		ScreenSplash screenSplash = new ScreenSplash();
		Login login = new Login();
		
		// Inicia la ventana de presentaci�n (hilo)
		screenSplash.start();
		// Espera a que finalice el hilo
		screenSplash.join();
		
		// Abre la ventana para loguearse
		login.openWindow();
	}
		
}
