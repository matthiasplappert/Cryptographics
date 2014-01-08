package edu.kit.iks.CryptographicsLib;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VisualizationView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -988624050394454370L;

	private JButton nextButton;
	
	private JButton backButton;
	
	public VisualizationView() {
		nextButton = new JButton("Next");
		this.add(nextButton);
		
		backButton = new JButton("Back");
		this.add(backButton);
		this.validate();
	}
	
	public JButton getNextButton() {
		return nextButton;
	}

	public JButton getBackButton() {
		return backButton;
	}
}
