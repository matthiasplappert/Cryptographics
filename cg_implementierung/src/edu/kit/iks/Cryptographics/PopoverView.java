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
	
	// TODO: add Label or Button
	private JLabel procedureName;
	
	private JLabel difficulty;
	
	private JLabel introduction;
	
	private VisualizationButton startButton;
	
	private JButton closeButton;
	
	private AbstractVisualizationInfo visualizationInfo;
	
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
		this.validate();
	}
	
	public JButton getStartButton() {
		return startButton;
	}
	
	public JButton getCloseButton() {
		return closeButton;
	}
}
