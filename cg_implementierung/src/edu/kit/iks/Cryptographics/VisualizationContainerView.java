package edu.kit.iks.Cryptographics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * An instance of this class represents the view of container controller
 * beside the actual visualization
 * 
 * @author Christian Dreher
 */
public class VisualizationContainerView extends JPanel {
	
	/**
	 * Name of the current visualization
	 */
	private JLabel _nameLabel;
	
	/**
	 * Button to exit the current visualization
	 */
	private JButton _exitButton;
	
	/**
	 * Button to access interactive help for the current step inside the
	 * visualization
	 */
	private JButton _helpButton;
}
