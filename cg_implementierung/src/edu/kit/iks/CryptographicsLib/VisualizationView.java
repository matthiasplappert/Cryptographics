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
	 * Constructor initializing a new instance of {VisualizationView}
	 */
	public VisualizationView() {
		nextButton = new JButton("Next");
		this.add(nextButton);
		
		backButton = new JButton("Back");
		this.add(backButton);
		this.validate();
	}
	
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

	/**
	 * @param nextButton the nextButton to set
	 */
	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}

	/**
	 * @param backButton the backButton to set
	 */
	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
	
}
