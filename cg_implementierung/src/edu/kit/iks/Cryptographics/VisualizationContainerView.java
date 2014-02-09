package edu.kit.iks.Cryptographics;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.xnap.commons.i18n.I18n;

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
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(VisualizationContainerView.class);
	
	/**
	 * Constructor initializing a new instance of {VisualizationContainerView}
	 */
	public VisualizationContainerView() {
		super(new GridBagLayout());
		
		// Create the exit button.
		GridBagConstraints exitConstraints = new GridBagConstraints();
		exitConstraints.weightx = 1.0;
		exitConstraints.weighty = 0.1;
		exitConstraints.gridx = 0;
		exitConstraints.gridy = 0;
		this.exitButton = new JButton(i18n.tr("Exit"));
		this.add(this.exitButton, exitConstraints);
		
		// Create the name label.
		GridBagConstraints nameConstraints = new GridBagConstraints();
		nameConstraints.weightx = 1.0;
		nameConstraints.weighty = 0.1;
		nameConstraints.gridx = 1;
		nameConstraints.gridy = 0;
		this.nameLabel = new JLabel();
		this.add(this.nameLabel, nameConstraints);
		
		// Create the help button.
		GridBagConstraints helpConstraints = new GridBagConstraints();
		helpConstraints.weightx = 1.0;
		helpConstraints.weighty = 0.1;
		helpConstraints.gridx = 2;
		helpConstraints.gridy = 0;
		this.helpButton = new JButton(i18n.tr("Help"));
		this.add(this.helpButton, helpConstraints);
		
		// Create content view.
		GridBagConstraints contentConstraints = new GridBagConstraints();
		contentConstraints.weightx = 1.0;
		contentConstraints.weighty = 0.9;
		contentConstraints.gridx = 0;
		contentConstraints.gridy = 1;
		contentConstraints.fill = GridBagConstraints.BOTH;
		contentConstraints.gridwidth = 3;
	    this.contentView = new JPanel(new BorderLayout());
	    this.contentView.setName("visualizationContainerContent");
	    this.add(this.contentView, contentConstraints);
	    
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
