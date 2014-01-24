package edu.kit.iks.CryptographicsLib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
	
	/**
	 * Generates the alphabet strip with default dimension
	 * which is (26 * 30) x (2 * 25)
	 */
	public AlphabetStripView() {
		super();
		generateStrip(30, 25);
	}
	
	/**
	 * Generates the alphabet strip with given parameters
	 * (26 * width) x (2 * height)
	 * @param width Width of single cell
	 * @param height Height of single cell
	 */
	public AlphabetStripView(int width, int height) {
		super();
		generateStrip(width, height);
	}


	private void generateStrip(int width, int height) {

		// A layout with 2 rows and 26 columns. The desired form is simply 
		// achieved by first putting the alphabet and then the numbers in. 
		GridLayout layout = new GridLayout(2, 26);
		this.setLayout(layout);
		
		// Puts the 26 characters of the alphabet in the first row
		int asciiA = 65;
		JLabel currChar;
		for (int i = 0; i < 26; i++) {
			currChar = new JLabel(String.valueOf((char)(i+asciiA)));
			currChar.setBorder(BorderFactory.createLineBorder(Color.black));
			currChar.setVerticalAlignment(JLabel.CENTER);
			currChar.setHorizontalAlignment(JLabel.CENTER);
			this.add(currChar);
		}
		
		// Puts the numbers from 1 to 26 in the second row
		JLabel currNum;
		for (int i = 0; i < 26; i++) {
			currNum = new JLabel("" + (i+1));
			currNum.setBorder(BorderFactory.createLineBorder(Color.black));
			currNum.setVerticalAlignment(JLabel.CENTER);
			currNum.setHorizontalAlignment(JLabel.CENTER);
			this.add(currNum);
		}
		
		Dimension d = new Dimension(width * 26, height * 2);
		this.setPreferredSize(d);
	}
}
