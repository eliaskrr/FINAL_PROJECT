package main;
import login.Login;
import presentation.ScreenSplash;

public class ABCLibrary {

	public static void main(String[] args) throws InterruptedException {
		ScreenSplash screenSplash = new ScreenSplash();
		Login login = new Login();
		
		// Abre la ventana de presentanción
		screenSplash.openWindow();
		// Espera a que finalice el hilo
		screenSplash.join();
		
		// Abre la ventana para loguearse
		login.openWindow();
	}
}
