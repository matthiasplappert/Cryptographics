package edu.kit.iks.CryptographicsLib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
	
	public AlphabetStripView() {
		
		super();

		GridLayout layout = new GridLayout(2, 26);
		this.setLayout(layout);

		int asciiA = 65;
		JLabel currChar;
		for (int i = 0; i < 26; i++) {
			currChar = new JLabel(String.valueOf((char)(i+asciiA)));
			currChar.setVerticalAlignment(JLabel.CENTER);
			currChar.setHorizontalAlignment(JLabel.CENTER);
			this.add(currChar);
		}
		
		JLabel currNum;
		for (int i = 0; i < 26; i++) {
			currNum = new JLabel("" + (i+1));
			currNum.setVerticalAlignment(JLabel.CENTER);
			currNum.setHorizontalAlignment(JLabel.CENTER);
			this.add(currNum);
		}
		
		Dimension d = new Dimension(20 * 26, 20);
		this.setPreferredSize(d);
	}
}
