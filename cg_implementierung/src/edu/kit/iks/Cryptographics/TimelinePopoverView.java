package edu.kit.iks.Cryptographics;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class TimelinePopoverView extends PopoverView {
	
	private static final long serialVersionUID = 1L;
	
	private AbstractVisualizationInfo visualizationInfo;
	
	private JLabel nameLabel;

	private JLabel difficultyLabel;

	private JLabel descriptionLabel;

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
		this.getContentView().add(this.startButton);
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
