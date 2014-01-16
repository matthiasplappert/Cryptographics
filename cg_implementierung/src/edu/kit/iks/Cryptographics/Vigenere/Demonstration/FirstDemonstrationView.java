package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.kit.iks.CryptographicsLib.ImageView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

public class FirstDemonstrationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	private ImageView clock;
	private JLabel moduloText;
	
	public FirstDemonstrationView() {
		super();
       this.add(new JLabel("VIGENERE INTRODUCTION1"));
       this.validate();
	}
}
