package main;
import presentation.ScreenSplash;

public class Library {

	public static void main(String[] args) throws InterruptedException {
		ScreenSplash screenSplash = new ScreenSplash();
		
		// Inicia el hilo
		screenSplash.start();
		// Espera a que finalice
		screenSplash.join();
	}
}
