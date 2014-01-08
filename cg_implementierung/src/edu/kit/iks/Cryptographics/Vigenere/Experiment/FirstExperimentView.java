package edu.kit.iks.Cryptographics.Vigenere.Experiment;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.VisualizationView;

/*
 * This class represents the view of the first experimentation step. In the first step the user
 * chooses a string and a passphrase, then he is asked to do the encryption. When the encryption
 * is succesfull, cryptographics will decrypt it.
 */
public class FirstExperimentView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//PLAIN CHARS WITH THEIR INDEXES
	private JLabel[] indexCharPlain;
	private JTextField[] textCharPlan;
	
	//ENCRYPTED CHARS WITH THEIR INDEXES
	private JLabel[] indexCharEncrypted;
	private JTextField[] textCharEncrypted;
	
	//Visulisation of the Key
	private JLabel vigenereKeyDesc;
	
	//Visualisation of calculation of the indexes
	private JLabel charFirst;
	private JLabel charSecond;
	private JLabel charFinished;
	
	public FirstExperimentView() {
       this.add(new JLabel("VIGENERE EXPERIMENT"));
	}
}