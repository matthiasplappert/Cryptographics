package edu.kit.iks.Cryptographics.Vigenere.Explanatation;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.JImage;
import edu.kit.iks.CryptographicsLib.UICharacterFrequencyDiagram;

/*
 * This class represents the view of the first explanatation step. In this step a cipher will be given
 * to the user. He has the choice to create a histogramm and use an algorithm to get the length of 
 * the key. Then he has to extract the password. 
 */
public class SecondExplanatationView extends JPanel{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//encrypted text
	private JLabel cipher;
	private JLabel keylength;
	
	private JTextField key;
	
	private JButton buttonValidateKey;
	private JButton buttonGenerateHistogramm;
	private JButton buttonComputeKeyLength;
	
	private UICharacterFrequencyDiagram vigenereHistogramm;
	private UICharacterFrequencyDiagram alphabetHistogramm;
	
	//Buttons to navigate
	private JButton buttonNext;
	private JButton buttonBack;
	
	public SecondExplanatationView() {
       this.add(new JLabel("VIGENERE EXPLANATATION2"));
	}
}