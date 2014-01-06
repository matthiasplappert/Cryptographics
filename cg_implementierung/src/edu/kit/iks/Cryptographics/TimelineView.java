package edu.kit.iks.Cryptographics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * An instance of this class represents the view of a timeline 
 * 
 * @author Christian Dreher
 */
public class TimelineView extends JPanel {
	
	private JButton caesar;
	
	private JButton diffieHellman;
	
	private JButton vigenere;
	
	public TimelineView() {
		this.add(new JLabel("TimeLine"));
		this.caesar = new JButton("Caesar");
		this.caesar.setVisible(true);
		this.add(caesar);
	}

	/**
	 * @return the caesar
	 */
	public JButton getCaesar() {
		return caesar;
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
