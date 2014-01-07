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
	
	private JLabel procedureName;
	private JLabel difficulty;
	private JLabel introduction;
	private JButton startProcedure;
	
	public PopoverView(AbstractVisualizationInfo vsInfo) {
		procedureName = new JLabel(vsInfo.getName());
		difficulty = new JLabel(vsInfo.getDifficulty().toString());
		introduction = new JLabel(vsInfo.getDescription());
		//STARTPROCEDURE
	}
}
