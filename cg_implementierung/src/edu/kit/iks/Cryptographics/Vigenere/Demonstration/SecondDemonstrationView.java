package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.VisualizationView;
import edu.kit.iks.Cryptographics.Vigenere.VigenereModel;

public class SecondDemonstrationView extends VisualizationView {
	private static final long serialVersionUID = 6294968461280032987L;

	// PLAINTEXTCHARS WITH THEIR INDEXES
	private JLabel[] indexCharPlain;
	private JTextField[] textCharPlain;

	// ENCRYPTED CHARS WITH THEIR INDEXES
	private JLabel[] indexCharEncrypted;
	private JTextField[] textCharEncrypted;

	// Visulisation of the Key
	private JLabel vigenereKeyDesc;
	private String vigenereKey = "OKAY";

	// Visualisation of calculation of the indexes
	private JLabel charFirst;
	private JLabel charSecond;
	private JLabel charFinished;
	
	private JLabel explanation;
	
	private JButton proceed;
	private AlphabetStripView alphabet;
	
	public void setCalculator(int a, int b) {
		int sum = ((a + b) % 26);
		Dimension size;
		this.charFirst.setText("Plaintext-Char: " + a);
		this.charSecond.setText("Key-Char: "+ b);
		this.charFinished.setText("Result: " + sum);
		size = this.charFirst.getPreferredSize();
		this.charFirst.setSize(size);
		size = this.charSecond.getPreferredSize();
		this.charSecond.setSize(size);
		size = this.charFinished.getPreferredSize();
		this.charFinished.setSize(size);
		this.validate();
	}

	public void setTextField(int i, String character) {
		this.textCharEncrypted[i].setText(character);
		if (character.isEmpty()) {
			this.indexCharEncrypted[i].setText("");
		} else { 
			this.indexCharEncrypted[i].setText("" + VigenereModel.characterToInt(character));
		}
		Dimension size = this.indexCharEncrypted[i].getPreferredSize();
		this.indexCharEncrypted[i].setSize(size);
		this.validate();
	}

	public AlphabetStripView getAlphabet() {
		return alphabet;
	}

	public void setEncryptedCharsVisible(boolean b) {
		for (int i = 0; i < this.indexCharEncrypted.length; i++) {
			this.indexCharEncrypted[i].setVisible(b);
			this.textCharEncrypted[i].setVisible(b);
		}
	}
	
	public void setCalculatorVisible(boolean b) {
		this.charFirst.setVisible(b);
		this.charSecond.setVisible(b);
		this.charFinished.setVisible(b);
	}
	
	public void setKeyVisible(boolean b) {
		this.vigenereKeyDesc.setVisible(b);
	}

	public void setExplanation(String explanation) {
		this.explanation.setText(explanation);
	}

	public SecondDemonstrationView() {
		this.setLayout(null);
		this.add(this.explanation = new JLabel("<html><div width=\"1200\">Now we want to encrypt 'ANNA'. First of all we add the position of evey character, as you can see in the bottom, in the alphabet under each character.</div></html>"));
		this.add(new JLabel("VIGENERE INTRODUCTION2"));
		this.vigenereKeyDesc = new JLabel("Vigenere Key: " + this.vigenereKey);
		this.proceed = new JButton("Proceed");
		
		this.alphabet = new AlphabetStripView();

		this.textCharPlain = new JTextField[4];
		this.textCharPlain[0] = new JTextField("A");
		this.textCharPlain[1] = new JTextField("N");
		this.textCharPlain[2] = new JTextField("N");
		this.textCharPlain[3] = new JTextField("E");
		for (int i = 0; i < this.textCharPlain.length; i++)
			this.add(this.textCharPlain[i]);

		this.indexCharPlain = new JLabel[4];
		this.indexCharPlain[0] = new JLabel(" 1");
		this.indexCharPlain[1] = new JLabel("14");
		this.indexCharPlain[2] = new JLabel("14");
		this.indexCharPlain[3] = new JLabel(" 5");
		for (int i = 0; i < this.indexCharPlain.length; i++)
			this.add(this.indexCharPlain[i]);

		this.textCharEncrypted = new JTextField[4];
		this.textCharEncrypted[0] = new JTextField();
		this.textCharEncrypted[1] = new JTextField();
		this.textCharEncrypted[2] = new JTextField();
		this.textCharEncrypted[3] = new JTextField();
		for (int i = 0; i < this.textCharEncrypted.length; i++)
			this.add(this.textCharEncrypted[i]);

		this.indexCharEncrypted = new JLabel[4];
		this.indexCharEncrypted[0] = new JLabel("  ");
		this.indexCharEncrypted[1] = new JLabel("  ");
		this.indexCharEncrypted[2] = new JLabel("  ");
		this.indexCharEncrypted[3] = new JLabel("  ");
		for (int i = 0; i < this.indexCharEncrypted.length; i++)
			this.add(this.indexCharEncrypted[i]);

		this.add(this.charFirst = new JLabel());
		this.add(this.charSecond = new JLabel());
		this.add(this.charFinished = new JLabel());
		this.add(this.vigenereKeyDesc);
		this.add(this.alphabet);
		this.add(this.proceed);
		
		setCalculatorVisible(false);
		setEncryptedCharsVisible(false);
		setKeyVisible(false);
		
		this.vigenereKeyDesc.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.charFirst.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.charSecond.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.charFinished.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.explanation.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		for (int i = 0; i < this.textCharPlain.length; i++)
			this.textCharPlain[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));
	
		for (int i = 0; i < this.indexCharPlain.length; i++)
			this.indexCharPlain[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		for (int i = 0; i < this.textCharEncrypted.length; i++)
			this.textCharEncrypted[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));
	
		for (int i = 0; i < this.indexCharEncrypted.length; i++)
			this.indexCharEncrypted[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));

		Dimension size = this.vigenereKeyDesc.getPreferredSize();
		this.vigenereKeyDesc.setBounds(90, 250, size.width, size.height);
		
		size = this.textCharPlain[0].getPreferredSize();
		this.textCharPlain[0].setBounds(500, 100,
	             size.width, size.height);
		
		size = this.textCharPlain[1].getPreferredSize();
		this.textCharPlain[1].setBounds(550, 100,
	             size.width, size.height);
		
		size = this.textCharPlain[2].getPreferredSize();
		this.textCharPlain[2].setBounds(600, 100,
	             size.width, size.height);

		size = this.textCharPlain[3].getPreferredSize();
		this.textCharPlain[3].setBounds(650, 100,
	             size.width, size.height);
		
		//TROLOLO
		
		size = this.indexCharPlain[0].getPreferredSize();
		this.indexCharPlain[0].setBounds(500, 160,
	             size.width, size.height);
		
		size = this.indexCharPlain[1].getPreferredSize();
		this.indexCharPlain[1].setBounds(550, 160,
	             size.width, size.height);
		
		size = this.indexCharPlain[2].getPreferredSize();
		this.indexCharPlain[2].setBounds(600, 160,
	             size.width, size.height);

		size = this.indexCharPlain[3].getPreferredSize();
		this.indexCharPlain[3].setBounds(650, 160,
	             size.width, size.height);
		
		//TROLOLOLO 2
		size.width = 24;
		size.height = 44;
		this.textCharEncrypted[0].setBounds(500, 250,
	             size.width, size.height);
		
		this.textCharEncrypted[1].setBounds(550, 250,
	             size.width, size.height);
		
		this.textCharEncrypted[2].setBounds(600, 250,
	             size.width, size.height);

		this.textCharEncrypted[3].setBounds(650, 250,
	             size.width, size.height);
		
		//TROLOLO 3
		
		size = this.indexCharEncrypted[0].getPreferredSize();
		this.indexCharEncrypted[0].setBounds(500, 310,
	             size.width, size.height);
		
		size = this.indexCharEncrypted[1].getPreferredSize();
		this.indexCharEncrypted[1].setBounds(550, 310,
	             size.width, size.height);
		
		size = this.indexCharEncrypted[2].getPreferredSize();
		this.indexCharEncrypted[2].setBounds(600, 310,
	             size.width, size.height);

		size = this.indexCharEncrypted[3].getPreferredSize();
		this.indexCharEncrypted[3].setBounds(650, 310,
	             size.width, size.height);
		
		size = this.alphabet.getPreferredSize();
		this.alphabet.setBounds(100, 520,
	             size.width, size.height);
		
		size = this.charFirst.getPreferredSize();
		this.charFirst.setBounds(900, 160,
	             size.width, size.height);
		
		size = this.charSecond.getPreferredSize();
		this.charSecond.setBounds(900, 210,
	             size.width, size.height);
		
		size = this.charFinished.getPreferredSize();
		this.charFinished.setBounds(900, 260,
	             size.width, size.height);
		
		size = this.explanation.getPreferredSize();
		this.explanation.setBounds(10, 10,
	             size.width, size.height);
		
		size = this.getBackButton().getPreferredSize();
		this.getBackButton().setBounds(30, 600,
	             size.width, size.height);
		
		
		size = this.getNextButton().getPreferredSize();
		this.getNextButton().setBounds(1100, 600,
	             size.width, size.height);
	}
}