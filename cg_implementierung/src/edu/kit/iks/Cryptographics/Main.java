package edu.kit.iks.Cryptographics;

import edu.kit.iks.CryptographicsLib.Logger;

/**
 * Main Class containing the main()-method
 * 
 * @author Christian Dreher
 */
public class Main {
	
	/**
	 * Flag to define whether to enter debug mode or not.
	 * Must be set to false in production.
	 */
	private static boolean debugMode = true;
	
	/**
	 * Main method (hook for Java to start from)
	 * 
	 * @param args  Arguments
	 */
	public static void main(String[] args) {
		if (Main.debugMode) {
			Logger.setDebugMode();
		}
		Logger.d("Main", "main", "Debugger running.");
		
		MainController mainController = new MainController();
		mainController.loadView();
		mainController.presentStartAction();
	}
}
