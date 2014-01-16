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
	private ImageView vigenere;
	private JLabel vigenereText;
	private JLabel moduloText;
	
	public FirstDemonstrationView() {
		super();
		this.vigenereText = new JLabel("Vigenere bla bla... Now go to modulo:");
		this.moduloText = new JLabel("It's easy to describe the logical operation 'modulo'; we use it everyday in our... ");
		
		this.add(this.moduloText);
		this.add(this.vigenereText);
		//in the first step set modulo unvisible
		this.moduloText.setVisible(false);
		
		this.validate();
	}

	public JLabel getModuloText() {
		return this.moduloText;
	}
	
	public ImageView clock() {
		return this.clock;
	}
}
