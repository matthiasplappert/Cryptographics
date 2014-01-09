package edu.kit.iks.CryptographicsLib;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Matthias Jaenicke.
 * 
 * A horizontal strip of the numbers from 1 to 26.
 * Used for UIAlphabetStrip.
 */
public class NumbersStripView extends JPanel{

private static JLabel[] strip;
	
	public NumbersStripView() {
		
		super();
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		strip = new JLabel[26];

		for (int i = 1; i < 27; i++) {
			strip[i] = new JLabel(String.valueOf(i));
			strip[i].setVerticalAlignment(JLabel.CENTER);
			strip[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(strip[i]);
		}
		
		Dimension d = new Dimension(20 * strip.length, 20);
		this.setPreferredSize(d);
	}
}
