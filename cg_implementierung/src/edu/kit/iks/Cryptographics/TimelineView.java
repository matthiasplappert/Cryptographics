package edu.kit.iks.Cryptographics;

import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
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

	private JButton[] buttons;
	
	public JButton[] getButtons() {
		return buttons;
	}

	private JButton caesar;
	
	private JButton diffieHellman;
	
	private JButton vigenere;
	
	public TimelineView(List<AbstractVisualizationInfo> visualizationInfos) {
		this.buttons = new JButton[visualizationInfos.size()];
		AbstractVisualizationInfo tmpVI;
		this.visualizationInfos = visualizationInfos;
		this.add(new JLabel("TimeLine"));
		int j=0;
		for( Iterator<AbstractVisualizationInfo> i = visualizationInfos.iterator(); i.hasNext();) {
			tmpVI = i.next();
			this.buttons[j] = new JButton(tmpVI.getName());
			this.add(buttons[j]);
		}
		this.validate();
	}

	/**
	 * @return the caesar
	 */
	public JButton getCaesar() {
		return this.caesar;
	}

	/**
	 * @return the diffieHellman
	 */
	public JButton getDiffieHellman() {
		return diffieHellman;
	}

	/**
	 * @return the vigenere
	 */
	public JButton getVigenere() {
		return vigenere;
	}
}

