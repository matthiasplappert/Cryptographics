package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import org.jdom2.Element;
import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Vigenere.VigenereVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.ImageView;
import edu.kit.iks.CryptographicsLib.VisualizationView;
/**
 * In this step will be shown how vigenere works.
 * @author Aydin Tekin
 */
public class FirstDemonstrationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(FirstDemonstrationView.class);
	
	/**
	 * clock image
	 */
	private ImageView clock;
	
	/**
	 * vigenere image
	 */
	private ImageView vigenere;
	
	/**
	 * text of vigenere
	 */
	private JLabel vigenereText;
	
	/**
	 * text of modulo-explanation
	 */
	private JLabel moduloText;
	
	/**
	 * link to the resource
	 */
	private Element vigenereXML;
	
	/**
	 * creates all needed GUI elements
	 * @param visualizationInfo visualization information of current step
	 */
	private void setupGUI(VigenereVisualizationInfo visualizationInfo) {
		this.vigenereXML = visualizationInfo.getResources();
		this.setLayout(null);
		// create GUI Elements
		this.vigenereText = new JLabel(i18n.tr("Vigenere bla bla... Now go to modulo:"));
		this.moduloText = new JLabel(i18n.tr("It's easy to describe the logical operation "
				+ "'modulo'; we use it everyday in our... "));
		this.vigenere= new ImageView(vigenereXML.getChild(
				"vigenereImage").getAttributeValue("path"));
		this.clock = new ImageView(vigenereXML.getChild(
				"moduloImage").getAttributeValue("path"));
		// set fonts
		this.vigenereText.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		this.moduloText.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		// add to the view
		this.add(this.vigenere);
		this.add(this.vigenereText);
		this.add(this.clock);
		this.add(this.moduloText);
	}
	
	/**
	 * customizes the created GUI elements
	 */
	private void customizeGUI() {
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
		
		// in the first step set modulo unvisible
		this.moduloText.setVisible(false);
		this.clock.setVisible(false);
		this.validate();
	}
	
	/**
	 * Constructor
	 * @param visualizationInfo visualization information of current step
	 */
	public FirstDemonstrationView(VigenereVisualizationInfo visualizationInfo) {
		super();
		setupGUI(visualizationInfo);
		customizeGUI();
	}
	
	/**
	 * returns the clock image
	 * @return clock image
	 */
	public ImageView getClock() {
		return clock;
	}
	
	/**
	 * returns the modulo label
	 * @return modulo label
	 */
	public JLabel getModuloText() {
		return this.moduloText;
	}
}
