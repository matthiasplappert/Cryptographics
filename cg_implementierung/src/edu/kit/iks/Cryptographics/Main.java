package edu.kit.iks.Cryptographics;

import javax.swing.SwingUtilities;

import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.Logger;

/**
 * Main Class containing the main()-method
 * 
 * @author Christian Dreher
 */
public class Main {
	/**
	 * Main method (hook for Java to start from)
	 * 
	 * @param args  Arguments
	 */
	public static void main(String[] args) {
		// Configure logger.
		if (Configuration.getInstance().isDebugModeEnabled()) {
			Logger.setDebugMode();
		}
		
		Logger.l("Cryptographics launched");
		Logger.d("Main", "main", "Debugger running.");
		
		// Run app on the AWT event queue.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainController mainController = new MainController();
				mainController.loadView();
				mainController.presentStartAction();
			}
		});
	}
}
