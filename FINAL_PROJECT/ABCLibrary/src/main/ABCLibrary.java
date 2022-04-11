package main;
import login.Login;
import presentation.ScreenSplash;

public class Library {

	public static void main(String[] args) throws InterruptedException {
		ScreenSplash screenSplash = new ScreenSplash();
		Login login = new Login();
		
		screenSplash.openWindow();
		screenSplash.join();
		
		login.openWindow();
	}
}
