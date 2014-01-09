package edu.kit.iks.Cryptographics;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.PopoverView;
import edu.kit.iks.CryptographicsLib.VisualizationButton;

/**
 * Objects of this class represent the popover when
 * the user clicks on a button in the timeline
 * 
 * @author Christian Dreher
 */
public class TimelinePopoverView extends PopoverView {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1914359780570867605L;

	/**
     * {VisualizationInfo}-object holding metadata of the current visualization
     */
	private AbstractVisualizationInfo visualizationInfo;
	
	/**
     * Label to display the name of the current visualization
     */
	private JLabel nameLabel;

	/**
     * Label to display the current difficulty
     */
	private JLabel difficultyLabel;

	/**
     * Label to display a description
     */
	private JLabel descriptionLabel;

	/**
     * Button to start the currently displayed visualization
     */
	private VisualizationButton startButton;
	
	/**
	 * Constructor of the timeline popover.
	 * 
	 * @param visualizationInfo Informations about a cipher.
	 */
	public TimelinePopoverView(AbstractVisualizationInfo visualizationInfo) {
		super();
		
		this.visualizationInfo = visualizationInfo;
		
		this.nameLabel = new JLabel(visualizationInfo.getName());
		this.getContentView().add(this.nameLabel);
		
		// TODO: map to human readable string
		this.difficultyLabel = new JLabel(visualizationInfo.getDifficulty().toString());
		this.getContentView().add(this.difficultyLabel);
		
		this.descriptionLabel = new JLabel(visualizationInfo.getDescription());
		this.getContentView().add(this.descriptionLabel);
		
		this.startButton = new VisualizationButton(visualizationInfo);
		this.startButton.setText("Start");
		this.getContentView().add(this.startButton);
		
		this.getContentView().validate();
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
	 * Returns the visualization info.
	 * 
	 * @return the visualization info.
	 */
	public AbstractVisualizationInfo getVisualizationInfo() {
		return visualizationInfo;
	}
}
