package edu.kit.iks.Cryptographics.Vigenere.Explanatation;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.JImage;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/*
 * This class represents the view of the first explanatation step. In the first step the disadvantages
 * and possible weak points of the vigenere-cipher.
 */
public class FirstExplanatationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//Visulisation of the Key
	private JLabel vigenereWeakExplanatation;
	
	private JImage vigenereHistogramm;
	
	public FirstExplanatationView() {
       this.add(new JLabel("VIGENERE EXPLANATATION"));
	}
}