package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThirdDemonstrationView extends JPanel{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//PLAINTEXTCHARS WITH THEIR INDEXES
	private JLabel[] indexCharPlain;
	private JTextField[] textCharPlain;
	
	//ENCRYPTED CHARS WITH THEIR INDEXES
	private JLabel[] indexCharEncrypted;
	private JTextField[] textCharEncrypted;
	
	//Visulisation of the Key
	private JLabel vigenereKeyDesc;
	
	//Visualisation of calculation of the indexes
	private JLabel charFirst;
	private JLabel charSecond;
	private JLabel charFinished;
	
	//Buttons to navigate
	private JButton buttonNext;
	private JButton buttonBack;
	
	public ThirdDemonstrationView() {
       this.add(new JLabel("VIGENERE INTRODUCTION"));
	}
}