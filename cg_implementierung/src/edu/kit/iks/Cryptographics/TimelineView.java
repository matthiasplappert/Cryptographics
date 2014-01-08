package edu.kit.iks.Cryptographics;

import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * An instance of this class represents the view of a timeline 
 * 
 * @author Christian Dreher
 */
public class TimelineView extends JPanel {
	
	private List<AbstractVisualizationInfo> visualizationInfos;

	private VisualizationButton[] buttons;
	
	public VisualizationButton[] getButtons() {
		return buttons;
	}
	
	public TimelineView(List<AbstractVisualizationInfo> visualizationInfos) {
		this.buttons = new VisualizationButton[visualizationInfos.size()];
		AbstractVisualizationInfo tmpVI;
		this.visualizationInfos = visualizationInfos;
		this.add(new JLabel("TimeLine"));
		int j=0;
		for( Iterator<AbstractVisualizationInfo> i = visualizationInfos.iterator(); i.hasNext();) {
			tmpVI = i.next();
			this.buttons[j] = new VisualizationButton(tmpVI);
			this.add(this.buttons[j]);
			j++;
		}
		this.validate();
	}
}
