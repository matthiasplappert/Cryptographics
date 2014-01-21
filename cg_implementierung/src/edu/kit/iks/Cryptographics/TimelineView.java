package edu.kit.iks.Cryptographics;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Logger;
import edu.kit.iks.CryptographicsLib.VisualizationButton;

/**
 * An instance of this class represents the view of a timeline 
 * 
 * @author Christian Dreher
 */
public class TimelineView extends JPanel {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -4974243564527826198L;

	/**
	 * List of all {VisualizationInfo}-objects containing the metadata 
	 * to display on the timeline
	 */
	private List<AbstractVisualizationInfo> visualizationInfos;

	/**
	 * Buttons to open the popover of a specific procedure to eventually 
	 * start their visualization
	 */
	private VisualizationButton[] buttons;
	
	/**
	 * Gets the buttons symbolizing a procedure displayed on the timeline 
	 * 
	 * @return Array of all timeline-buttons
	 */
	public VisualizationButton[] getButtons() {
		return buttons;
	}
	
	/**
	 * Constructor initializing a new instance of {TimelineView} with 
	 * given {visualizationInfos}
	 * 
	 * @param visualizationInfos List of all {VisualizationInfo}-instances
	 */
	public TimelineView(List<AbstractVisualizationInfo> visualizationInfos) {
		this.setBackground(Color.red);
		this.buttons = new VisualizationButton[visualizationInfos.size()];
		AbstractVisualizationInfo tmpVI;
		this.visualizationInfos = visualizationInfos;
		
		int j = 0;
		
		for (Iterator<AbstractVisualizationInfo> i = visualizationInfos.iterator(); i.hasNext();) {
			tmpVI = i.next();
			this.buttons[j] = new VisualizationButton(tmpVI);
			this.add(this.buttons[j]);
			j++;
		}
		
		this.validate();
	}
}
