package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
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
		
		
		this.setLayout(null);
		
		
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
		this.vigenereText.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.moduloText.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		Dimension size = this.vigenereText.getPreferredSize();
		this.vigenereText.setBounds(180, 5,
	             size.width, size.height);
		
		size = this.vigenere.getPreferredSize();
		this.vigenere.setBounds(30, 5,
	             size.width, size.height);
		
		size = this.moduloText.getPreferredSize();
		this.moduloText.setBounds(180, 160,
	             size.width, size.height);
		
		size = this.clock.getPreferredSize();
		this.clock.setBounds(500, 400,
	             size.width, size.height);
		
		size = this.getBackButton().getPreferredSize();
		this.getBackButton().setBounds(30, 600,
	             size.width, size.height);
		
		size = this.getNextButton().getPreferredSize();
		this.getNextButton().setBounds(1100, 600,
	             size.width, size.height);
		
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
