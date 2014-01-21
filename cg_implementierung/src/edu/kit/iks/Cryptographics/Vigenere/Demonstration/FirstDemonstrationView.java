package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdom2.Element;

import edu.kit.iks.Cryptographics.Vigenere.VigenereVisualizationInfo;
import edu.kit.iks.CryptographicsLib.ImageView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

public class FirstDemonstrationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	private ImageView clock;
	private ImageView vigenere;
	private JLabel vigenereText;
	private JLabel moduloText;
	private Element vigenereXML;
	
	public ImageView getClock() {
		return clock;
	}

	public void setClock(ImageView clock) {
		this.clock = clock;
	}

	public ImageView getVigenere() {
		return vigenere;
	}

	public void setVigenere(ImageView vigenere) {
		this.vigenere = vigenere;
	}

	public FirstDemonstrationView(VigenereVisualizationInfo visualizationInfo) {
		super();
		this.vigenereXML = visualizationInfo.getResources();
		this.vigenereText = new JLabel("Vigenere bla bla... Now go to modulo:");
		this.moduloText = new JLabel("It's easy to describe the logical operation 'modulo'; we use it everyday in our... ");
		this.vigenere= new ImageView(vigenereXML.getChild(
				"vigenereImage").getAttributeValue("path"));
		this.clock = new ImageView(vigenereXML.getChild(
				"moduloImage").getAttributeValue("path"));
		
		this.add(this.vigenere);
		this.add(this.vigenereText);
		this.add(this.clock);
		this.add(this.moduloText);
		
		//in the first step set modulo unvisible
		this.moduloText.setVisible(false);
		this.clock.setVisible(false);
		this.validate();
	}

	public JLabel getModuloText() {
		return this.moduloText;
	}
	
	public ImageView clock() {
		return this.clock;
	}
}
