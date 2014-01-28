package edu.kit.iks.CryptographicsLib;

import javax.swing.JButton;

/**
 * Objects of this class are a decorator for JButton, 
 * holding data about the procedure they represent on the
 * timeline
 * 
 * @author Christian Dreher
 */
public class VisualizationButton extends JButton {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1971747371012823882L;
	
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
		// For the synth look and feel it's important to pass a
		// name to identify an object for custom styling
		this.setName("visualizationButton");
		
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
