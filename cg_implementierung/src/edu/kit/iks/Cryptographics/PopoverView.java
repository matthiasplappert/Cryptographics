package edu.kit.iks.Cryptographics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * An instance of this class represents the view of a popover
 * 
 * @author Christian Dreher
 */
public class PopoverView extends JPanel {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5949014143695648861L;

	/**
	 * Label to display the name of the current procedure
	 */
	private JLabel procedureName;

	/**
	 * Label to display the current difficulty
	 */
	private JLabel difficulty;

	/**
	 * Label to display an introduction
	 */
	private JLabel introduction;

	/**
	 * Button to start the currently displayed procedure
	 */
	private VisualizationButton startButton;

	/**
	 * Button to close the popover
	 */
	private JButton closeButton;

	/**
	 * {VisualizationInfo}-object holding metadata of the current procedure
	 */
	private AbstractVisualizationInfo visualizationInfo;

	/**
	 * Constructor for the View of the Popover.
	 * 
	 * @param vsInfo
	 *            Informations about a cipher.
	 */
	public PopoverView(AbstractVisualizationInfo vsInfo) {
		visualizationInfo = vsInfo;
		this.procedureName = new JLabel(vsInfo.getName());

		// TODO: map to human readable string
		this.difficulty = new JLabel(vsInfo.getDifficulty().toString());
		this.introduction = new JLabel(vsInfo.getDescription());
		this.startButton = new VisualizationButton(vsInfo);
		this.closeButton = new JButton();
		this.add(procedureName);
		this.add(difficulty);
		this.add(introduction);
		this.add(startButton);
		this.add(closeButton);
	}

	/**
	 * Returns the StartButton.
	 * 
	 * @return the startButton button to return.
	 */
	public VisualizationButton getStartButton() {
		return startButton;
	}

	/**
	 * Returns the CloseButton.
	 * 
	 * @return the closeButton button to return.
	 */
	public JButton getCloseButton() {
		return closeButton;
	}
}
