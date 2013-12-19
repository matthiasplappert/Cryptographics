package edu.kit.iks.Cryptographics;

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
		MainController mainController = new MainController();
		mainController.loadView();
		mainController.presentStartAction();
		
		// TODO: start run loop and kick things off.
	}
}
