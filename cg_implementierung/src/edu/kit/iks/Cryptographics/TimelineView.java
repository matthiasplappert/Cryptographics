package edu.kit.iks.Cryptographics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
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
		super(new GridBagLayout());
		
		this.buttons = new VisualizationButton[visualizationInfos.size()];
		AbstractVisualizationInfo vInfo;
		int j = 0;

		// Constraints for wrapper-panel
		GridBagConstraints wrapperPanelConstraints = new GridBagConstraints();
		wrapperPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
		wrapperPanelConstraints.weightx = 1.0f;
		wrapperPanelConstraints.gridx = 0;
		wrapperPanelConstraints.gridy = 0;
		
		// Constraints for button-panel
		GridBagConstraints buttonPanelConstraints = new GridBagConstraints();
		buttonPanelConstraints.anchor = GridBagConstraints.LINE_END;
		buttonPanelConstraints.gridx = 0;
		buttonPanelConstraints.gridy = 0;
		
		// Constraints for fill-panel
		GridBagConstraints fillPanelConstraints = new GridBagConstraints();
		fillPanelConstraints.gridx = 1;
		fillPanelConstraints.gridy = 0;
		
		// Explenation to the constraints:
		// The constraings force the wrappers to overlay each other. Each wrapper is
		// build up as following:
		// [[----buttonPanel----[-button-][----fillPanel----]]
		// The width of the wrapper is always full screen size, the buttonPanel's
		// width is always the percentage the timelineOffset defines. The fillPanel's
		// width is 1 - timelineOffset. The fill panel is needed as counterweight.
		
		// Initialize and place all buttons with above defined constraints
		for (Iterator<AbstractVisualizationInfo> i = visualizationInfos.iterator(); i.hasNext();) {
			vInfo = i.next();

			// Fit constraints to ensure the right position of the button
			buttonPanelConstraints.weightx = vInfo.getTimelineOffset();
			fillPanelConstraints.weightx = 1 - vInfo.getTimelineOffset();

			// Initialize button
			this.buttons[j] = new VisualizationButton(vInfo);
			
			// Initialize helping panels
			JPanel wrapperPanel = new JPanel(new GridBagLayout());
			JPanel buttonPanel = new JPanel(new GridBagLayout());
			JPanel fillPanel = new JPanel();
			
			// Populate helping panels with button
			buttonPanel.add(this.buttons[j]);
			wrapperPanel.add(buttonPanel, buttonPanelConstraints);
			wrapperPanel.add(fillPanel, fillPanelConstraints);
			
			// Make helping panels invisible
			wrapperPanel.setOpaque(false);
			buttonPanel.setOpaque(false);
			fillPanel.setOpaque(false);
			
			// Add wrapper to actual layout
			this.add(wrapperPanel, wrapperPanelConstraints);
			
			j++;
		}
		
		this.validate();
	}
}
