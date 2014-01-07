package edu.kit.iks.Cryptographics;

import javax.swing.JButton;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class TimelineViewButton extends JButton {
	private AbstractVisualizationInfo visualizationInfo;
	
	public TimelineViewButton(AbstractVisualizationInfo vInfo) {
		visualizationInfo = vInfo;
	}
	
	public AbstractVisualizationInfo getVisualizationInfo() {
		return visualizationInfo;
	}
}
