package edu.kit.iks.CryptographicsLib;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Matthias Jaenicke.
 * 
 */
public class UINumbersStrip extends JPanel{

private static JLabel[] strip;
	
	public UINumbersStrip() {
		
		super();
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		strip = new JLabel[26];

		for (int i = 0; i < 26; i++) {
			strip[i] = new JLabel(String.valueOf(i));
			strip[i].setVerticalAlignment(JLabel.CENTER);
			strip[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(strip[i]);
		}
		
		Dimension d = new Dimension(20 * strip.length, 20);
		this.setPreferredSize(d);
	}
}
