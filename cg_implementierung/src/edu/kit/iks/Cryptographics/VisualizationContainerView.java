package edu.kit.iks.Cryptographics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 2802070691102616667L;

	/**
	 * Name of the current visualization
	 */
	private JLabel nameLabel;
	
	/**
	 * Button to exit the current visualization
	 */
	private JButton exitButton;
	
	/**
	 * Button to access interactive help for the current step inside the
	 * visualization
	 */
	private JButton helpButton;
	
	/**
	 * The content view that contains the actual visualization 
	 */
	private JPanel contentView;
	
	/**
	 * Constructor initializing a new instance of {VisualizationContainerView}
	 */
	public VisualizationContainerView() {
		super(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		
		// Create the exit button.
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.exitButton = new JButton("Exit");
		this.add(this.exitButton, constraints);
		
		// Create the name label.
		constraints.gridx = 1;
		constraints.gridy = 0;
		this.nameLabel = new JLabel();
		this.add(this.nameLabel, constraints);
		
		// Create the help button.
		constraints.gridx = 2;
		constraints.gridy = 0;
		this.helpButton = new JButton("Help");
		this.add(this.helpButton, constraints);
		
		// Create content view.
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 3;
	    this.contentView = new JPanel();
	    this.add(this.contentView, constraints);
	    
	    this.validate();
	}

	/**
	 * @return the nameLabel
	 */
	public JLabel getNameLabel() {
		return nameLabel;
	}

	/**
	 * @return the exitButton
	 */
	public JButton getExitButton() {
		return exitButton;
	}

	/**
	 * @return the helpButton
	 */
	public JButton getHelpButton() {
		return helpButton;
	}
	
	/**
	 * @return the contentView
	 * @return
	 */
	public JPanel getContentView() {
		return contentView;
	}
}
