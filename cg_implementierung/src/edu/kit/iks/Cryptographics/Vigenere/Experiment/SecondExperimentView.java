package edu.kit.iks.Cryptographics.Vigenere.Experiment;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.VisualizationView;

/*
 * This class represents the view of the second experimentation step. In the second step cryptographics
 * chooses a string and a passphrase, then the user is asked to do the decryption.
 */
public class SecondExperimentView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//ENCRYPTED CHARS WITH THEIR INDEXES
	private JLabel[] indexCharEncrypted;
	private JTextField[] textCharEncrypted;
	
	//DECRYPTED CHARS WITH THEIR INDEXES
	private JLabel[] indexCharDecrypt;
	private JTextField[] textCharDecrypt;
	
	//Visulisation of the Key
	private JLabel vigenereKeyDesc;
	
	//Visualisation of calculation of the indexes
	private JLabel charFirst;
	private JLabel charSecond;
	private JLabel charFinished;
	
	public SecondExperimentView() {
       this.add(new JLabel("VIGENERE EXPERIMENT2"));
	}
}