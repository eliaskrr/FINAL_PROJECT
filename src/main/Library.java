package main;
import login.LoginWindow;
import presentation.ScreenSplash;

public class Library {

	public static void main(String[] args) throws InterruptedException {
		ScreenSplash screenSplash = new ScreenSplash();
		LoginWindow login = new LoginWindow();
		
		// Inicia el hilo
		//screenSplash.start();
		// Espera a que finalice
		screenSplash.join();
		
		// Abre la ventana del login
		login.openWindow();
	}
}
