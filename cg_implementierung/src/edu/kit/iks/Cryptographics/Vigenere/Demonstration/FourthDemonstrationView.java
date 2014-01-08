package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class FourthDemonstrationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//ENCRYPTED CHARS WITH THEIR INDEXES
	private JLabel[] indexCharEncrypted;
	private JTextField[] textCharEncrypted;
	
	//DECRYPTED CHARS WITH THEIR INDEXES
	private JLabel[] indexCharDecrypted;
	private JTextField[] textCharDecrypted;
	
	//Visulisation of the Key
	private JLabel vigenereKeyDesc;
	
	//Visualisation of calculation of the indexes
	private JLabel charFirst;
	private JLabel charSecond;
	private JLabel charFinished;
	
	public FourthDemonstrationView() {
       this.add(new JLabel("VIGENERE INTRODUCTION"));
	}
}