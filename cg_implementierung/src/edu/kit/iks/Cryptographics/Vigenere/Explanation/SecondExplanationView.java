package edu.kit.iks.Cryptographics.Vigenere.Explanation;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.CharacterFrequencyDiagramView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/*
 * This class represents the view of the first explanatation step. In this step a cipher will be given
 * to the user. He has the choice to create a histogramm and use an algorithm to get the length of 
 * the key. Then he has to extract the password. 
 */
public class SecondExplanationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//encrypted text
	private JLabel cipher;
	private JLabel keylength;
	
	private JTextField key;
	
	private JButton buttonValidateKey;
	private JButton buttonGenerateHistogramm;
	private JButton buttonComputeKeyLength;
	
	private CharacterFrequencyDiagramView vigenereHistogramm;
	private CharacterFrequencyDiagramView alphabetHistogramm;
	
	public SecondExplanationView() {
		this.setLayout(null);
		
       
	}
}