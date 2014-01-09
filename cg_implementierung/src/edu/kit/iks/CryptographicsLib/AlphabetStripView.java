package edu.kit.iks.CryptographicsLib;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * @author Matthias Jaenicke.
 * 
 * A horizontal strip of all letters from A to Z.
 * Beneath it is matched by a corresponding strip of the numbers from 1 to 26.
 */
public class AlphabetStripView extends JPanel {
	private static JLabel[] strip;
	
	public AlphabetStripView() {
		
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		strip = new JLabel[26];

		int asciiA = 65;
		for (int i = asciiA; i < asciiA+26; i++) {
			strip[i] = new JLabel(String.valueOf((char)i));
			strip[i].setVerticalAlignment(JLabel.CENTER);
			strip[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(strip[i]);
		}
		
		Dimension d = new Dimension(20 * strip.length, 20);
		this.setPreferredSize(d);
	}
}
