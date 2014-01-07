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
	
	private JButton startButton;
	
	private JButton closeButton;
	
	private AbstractVisualizationInfo visualizationInfo;
	
	public PopoverView(AbstractVisualizationInfo vsInfo) {
		visualizationInfo = vsInfo;
		
		procedureName = new JLabel(vsInfo.getName());
		
		// TODO: map to human readable string
		difficulty = new JLabel(vsInfo.getDifficulty().toString());
		introduction = new JLabel(vsInfo.getDescription());
		startButton = new JButton();
		closeButton = new JButton();
	}
	
	public JButton getStartButton() {
		return startButton;
	}
	
	public JButton getCloseButton() {
		return closeButton;
	}
}
