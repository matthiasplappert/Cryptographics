package edu.kit.iks.CryptographicsLib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Matthias Jaenicke.
 * 
 * A horizontal strip of all letters from A to Z.
 * Beneath it is matched by a corresponding strip of the numbers from 1 to 26.
 */
public class AlphabetStripView extends JPanel {
	private static JPanel strip;
	private static NumbersStripView numberStrip;
	
	public AlphabetStripView() {
		
		super();
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		FlowLayout stripLayout = new FlowLayout();
		strip = new JPanel(); //new JLabel[26];
		strip.setLayout(stripLayout);
		
		numberStrip = new NumbersStripView();

		int asciiA = 65;
		JLabel currChar;
		for (int i = asciiA; i < asciiA+26; i++) {
			currChar = new JLabel(String.valueOf((char)i));
			currChar.setVerticalAlignment(JLabel.CENTER);
			currChar.setHorizontalAlignment(JLabel.CENTER);
			strip.add(currChar);
		}
		
		this.add(strip, BorderLayout.NORTH);
		this.add(numberStrip, BorderLayout.SOUTH);
		
		Dimension d = new Dimension(20 * 26, 20);
		this.setPreferredSize(d);
	}
}
