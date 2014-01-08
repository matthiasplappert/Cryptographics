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

	private JLabel procedureName;

	private JLabel difficulty;

	private JLabel introduction;

	private VisualizationButton startButton;

	private JButton closeButton;

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
