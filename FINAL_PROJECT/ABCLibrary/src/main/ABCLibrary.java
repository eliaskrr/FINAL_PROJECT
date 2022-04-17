package main;
import login.Login;
import presentation.ScreenSplash;

/**
 * En esta clase se iniciar� el programa.
 * @author Ilyasse Essadak Samaali
 */
public class ABCLibrary {

	public static void main(String[] args) throws InterruptedException {
		ScreenSplash screenSplash;
		Login login;
		
		// Inicia la ventana de presentaci�n (hilo)
		screenSplash = new ScreenSplash();
		// Espera a que finalice el hilo
		screenSplash.join();
		
		// Abre la ventana para loguearse
		login = new Login();
	}
		
}
