package edu.kit.iks.Cryptographics;

import javax.swing.JButton;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * Objects of this class are a decorator for JButton, 
 * holding data about the procedure they represent on the
 * timeline
 * 
 * @author Christian Dreher
 */
public class VisualizationButton extends JButton {
	
	/**
	 * {VisualizationInfo}-object, holding metadata of the 
	 * procedure the button represents
	 */
	private AbstractVisualizationInfo visualizationInfo;
	
	/**
	 * Constructor initializing a new instance of {VisualizationButton} 
	 * with given {vInfo}
	 * 
	 * @param vInfo {VisualizationInfo}-object holding metadata for
	 * 		the button to represent
	 */
	public VisualizationButton(AbstractVisualizationInfo vInfo) {
		visualizationInfo = vInfo;
		this.setText(visualizationInfo.getName());
	}
	
	/**
	 * Gets the {VisualizationInfo}-object holding the metadata 
	 * 
	 * @return {VisualizationInfo}-object
	 */
	public AbstractVisualizationInfo getVisualizationInfo() {
		return visualizationInfo;
	}
}
