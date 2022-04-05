package main;
import login.UserLogin;
import presentation.ScreenSplash;

public class Library {

	public static void main(String[] args) throws InterruptedException {
		ScreenSplash screenSplash = new ScreenSplash();
		UserLogin login = new UserLogin();
		
		screenSplash.openWindow();
	}
}
