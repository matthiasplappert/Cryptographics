package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import javax.swing.JLabel;
import javax.swing.JTextField;

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
	private String vigenereKey = "OKOK";
	
	//Visualisation of calculation of the indexes
	private JLabel charFirst;
	private JLabel charSecond;
	private JLabel charFinished;
	
	public ThirdDemonstrationView() {
       this.add(new JLabel("VIGENERE INTRODUCTION3"));
       this.vigenereKeyDesc = new JLabel("Vigenere Key: " + this.vigenereKey);
       
       this.textCharPlain = new JTextField[4];
       this.textCharPlain[0] = new JTextField("A");
       this.textCharPlain[1] = new JTextField("N");
       this.textCharPlain[2] = new JTextField("N");
       this.textCharPlain[3] = new JTextField("A");
       for (int i = 0; i < this.textCharPlain.length; i++)
    	   this.add(this.textCharPlain[i]);
       
       this.indexCharPlain = new JLabel[4];
       this.indexCharPlain[0] = new JLabel("1");
       this.indexCharPlain[1] = new JLabel("14");
       this.indexCharPlain[2] = new JLabel("14");
       this.indexCharPlain[3] = new JLabel("1");
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
       this.indexCharDecrypted[0] = new JLabel();
       this.indexCharDecrypted[1] = new JLabel();
       this.indexCharDecrypted[2] = new JLabel();
       this.indexCharDecrypted[3] = new JLabel();
       for (int i = 0; i < this.indexCharDecrypted.length; i++)
    	   this.add(this.indexCharDecrypted[i]);
       
       this.add(this.charFirst = new JLabel());
       this.add(this.charSecond = new JLabel());
       this.add(this.charFinished = new JLabel());
       this.add(this.vigenereKeyDesc);
	}
}