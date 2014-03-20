package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.CryptographicsLib.Configuration;

public class LabelExplanation extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8305176927157942920L;
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(LabelExplanation.class);

	private String p = i18n.tr("p - The base color");
	
	private String sA = i18n.tr("sA - Alice's secret color");
	
	private String sB = i18n.tr("sB - Bob's secret color");
	
	private String AM = i18n.tr("AM - Mixture of sA and p");
	
	private String BM = i18n.tr("BM - Mixture of sB and p");
	
	public LabelExplanation() {
		super();
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel(p));
		this.add(new JLabel(sA));
		this.add(new JLabel(sB));
		this.add(new JLabel(AM));
		this.add(new JLabel(BM));
	}
}
