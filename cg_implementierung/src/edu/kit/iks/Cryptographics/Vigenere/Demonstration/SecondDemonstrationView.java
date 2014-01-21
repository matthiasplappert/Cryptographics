package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class SecondDemonstrationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//PLAINTEXTCHARS WITH THEIR INDEXES
	private JLabel[] indexCharPlain;
	private JTextField[] textCharPlain;
	
	//ENCRYPTED CHARS WITH THEIR INDEXES
	private JLabel[] indexCharEncrypted;
	private JTextField[] textCharEncrypted;
	
	//Visulisation of the Key
	private JLabel vigenereKeyDesc;
	private String vigenereKey = "OKOK";
	
	//Visualisation of calculation of the indexes
	private JLabel charFirst;
	private JLabel charSecond;
	private JLabel charFinished;
	
	public SecondDemonstrationView() {
       this.add(new JLabel("VIGENERE INTRODUCTION2"));
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
       
       this.textCharEncrypted = new JTextField[4];
       this.textCharEncrypted[0] = new JTextField();
       this.textCharEncrypted[1] = new JTextField();
       this.textCharEncrypted[2] = new JTextField();
       this.textCharEncrypted[3] = new JTextField();
       for (int i = 0; i < this.textCharEncrypted.length; i++)
    	   this.add(this.textCharEncrypted[i]);
       
       this.indexCharEncrypted = new JLabel[4];
       this.indexCharEncrypted[0] = new JLabel();
       this.indexCharEncrypted[1] = new JLabel();
       this.indexCharEncrypted[2] = new JLabel();
       this.indexCharEncrypted[3] = new JLabel();
       for (int i = 0; i < this.indexCharEncrypted.length; i++)
    	   this.add(this.indexCharEncrypted[i]);
       
       this.add(this.charFirst = new JLabel());
       this.add(this.charSecond = new JLabel());
       this.add(this.charFinished = new JLabel());
       this.add(this.vigenereKeyDesc);
	}
}