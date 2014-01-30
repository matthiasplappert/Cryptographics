package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.kit.iks.Cryptographics.Vigenere.VigenereModel;
import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

public class ThirdDemonstrationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//PLAINTEXTCHARS WITH THEIR INDEXES
	private JLabel[] indexCharPlain;
	private JTextField[] textCharPlain;
	
	//ENCRYPTED CHARS WITH THEIR INDEXES
	private JLabel[] indexCharDecrypted;
	private JTextField[] textCharDecrypted;
	
	//Visulisation of the Key
	private JLabel vigenereKeyDesc;
	private String vigenereKey = "KISS";
	
	//Visualisation of calculation of the indexes
	private JLabel charFirst;
	private JLabel charSecond;
	private JLabel charFinished;
	
	private JLabel explanation;
	private AlphabetStripView alphabet;
	
	public void setCalculator(int a, int b) {
		int temp = (a - b);
		if (temp < 0)
			temp = 26 + temp;
		Dimension size;
		this.charFirst.setText("Plaintext-Char: " + a);
		this.charSecond.setText("Key-Char: "+ b);
		this.charFinished.setText("Result: " + temp);
		size = this.charFirst.getPreferredSize();
		this.charFirst.setSize(size);
		size = this.charSecond.getPreferredSize();
		this.charSecond.setSize(size);
		size = this.charFinished.getPreferredSize();
		this.charFinished.setSize(size);
		this.validate();
	}
	
	public AlphabetStripView getAlphabet() {
		return alphabet;
	}
	
	public void setTextField(int i, String character) {
		this.textCharDecrypted[i].setText(character);
		if (character.isEmpty()) {
			this.indexCharDecrypted[i].setText("");
		} else { 
			this.indexCharDecrypted[i].setText("" + VigenereModel.characterToInt(character));
		}
		Dimension size = this.indexCharDecrypted[i].getPreferredSize();
		this.indexCharDecrypted[i].setSize(size);
		this.validate();
	}
	
	public void setCalculatorVisible(boolean b) {
		this.charFirst.setVisible(b);
		this.charSecond.setVisible(b);
		this.charFinished.setVisible(b);
	}
	
	public void setExplanation(String explanation) {
		this.explanation.setText(explanation);
		Dimension size = this.explanation.getPreferredSize();
		this.explanation.setSize(size.width, size.height);
		this.validate();
	}
	
	public ThirdDemonstrationView() {
		this.setLayout(null);
		this.add(this.explanation = new JLabel("<html><div width=\"1200\">Now we want to decrypt 'DMPL'. Insteading adding up, we use substraction to decrypt it! So lets go...</div></html>"));
		this.add(new JLabel("VIGENERE INTRODUCTION3"));
		this.vigenereKeyDesc = new JLabel("Vigenere Key: " + this.vigenereKey);
		this.alphabet = new AlphabetStripView();
		
		this.textCharPlain = new JTextField[4];
		this.textCharPlain[0] = new JTextField("E");
		this.textCharPlain[1] = new JTextField("N");
		this.textCharPlain[2] = new JTextField("Q");
		this.textCharPlain[3] = new JTextField("M");
		for (int i = 0; i < this.textCharPlain.length; i++)
			this.add(this.textCharPlain[i]);

		this.indexCharPlain = new JLabel[4];
		this.indexCharPlain[0] = new JLabel(" 5");
		this.indexCharPlain[1] = new JLabel("14");
		this.indexCharPlain[2] = new JLabel("17");
		this.indexCharPlain[3] = new JLabel("13");
		for (int i = 0; i < this.indexCharPlain.length; i++)
			this.add(this.indexCharPlain[i]);

		this.textCharDecrypted = new JTextField[4];
		this.textCharDecrypted[0] = new JTextField();
		this.textCharDecrypted[1] = new JTextField();
		this.textCharDecrypted[2] = new JTextField();
		this.textCharDecrypted[3] = new JTextField();
		for (int i = 0; i < this.textCharDecrypted.length; i++)
			this.add(this.textCharDecrypted[i]);

		this.indexCharDecrypted = new JLabel[4];
		this.indexCharDecrypted[0] = new JLabel("  ");
		this.indexCharDecrypted[1] = new JLabel("  ");
		this.indexCharDecrypted[2] = new JLabel("  ");
		this.indexCharDecrypted[3] = new JLabel("  ");
		for (int i = 0; i < this.indexCharDecrypted.length; i++)
			this.add(this.indexCharDecrypted[i]);
		
       
		this.add(this.charFirst = new JLabel());
		this.add(this.charSecond = new JLabel());
		this.add(this.charFinished = new JLabel());
		this.add(this.vigenereKeyDesc);
		this.add(this.alphabet);

		this.vigenereKeyDesc.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.charFirst.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.charSecond.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.charFinished.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.explanation.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		for (int i = 0; i < this.textCharPlain.length; i++)
			this.textCharPlain[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));
	
		for (int i = 0; i < this.indexCharPlain.length; i++)
			this.indexCharPlain[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		for (int i = 0; i < this.textCharDecrypted.length; i++)
			this.textCharDecrypted[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));
	
		for (int i = 0; i < this.indexCharDecrypted.length; i++)
			this.indexCharDecrypted[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));

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
		this.textCharDecrypted[0].setBounds(500, 250,
	             size.width, size.height);
		
		this.textCharDecrypted[1].setBounds(550, 250,
	             size.width, size.height);
		
		this.textCharDecrypted[2].setBounds(600, 250,
	             size.width, size.height);

		this.textCharDecrypted[3].setBounds(650, 250,
	             size.width, size.height);
		
		//TROLOLO 3
		
		size = this.indexCharDecrypted[0].getPreferredSize();
		this.indexCharDecrypted[0].setBounds(500, 310,
	             size.width, size.height);
		
		size = this.indexCharDecrypted[1].getPreferredSize();
		this.indexCharDecrypted[1].setBounds(550, 310,
	             size.width, size.height);
		
		size = this.indexCharDecrypted[2].getPreferredSize();
		this.indexCharDecrypted[2].setBounds(600, 310,
	             size.width, size.height);

		size = this.indexCharDecrypted[3].getPreferredSize();
		this.indexCharDecrypted[3].setBounds(650, 310,
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