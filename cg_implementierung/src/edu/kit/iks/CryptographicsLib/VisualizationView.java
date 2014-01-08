package edu.kit.iks.CryptographicsLib;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * View for UI elements which all visualizations have in common
 * 
 * @author Christian Dreher
 */
public class VisualizationView extends JPanel {
	
	/**
	 * Serial Version UID 
	 */
	private static final long serialVersionUID = -988624050394454370L;

	/**
	 * Next button
	 */
	private JButton nextButton;
	
	/**
	 * Back button
	 */
	private JButton backButton;
	
	/**
	 * Gets the next button
	 * 
	 * @return The next button
	 */
	public JButton getNextButton() {
		return nextButton;
	}
	
	/**
	 * Gets the back button
	 * 
	 * @return The back button
	 */
	public JButton getBackButton() {
		return backButton;
	}
}
