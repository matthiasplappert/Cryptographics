package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.VisualizationView;

public class DemoOneWayView extends VisualizationView {
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(DemoOneWayView.class);
	
	/* the jlanel to hold the explanation */
	private JLabel keyExchangeExplain;
	
	/* our labels */
	private JLabel easy, hard;
	
	/** our colormixes to show */
	private ColorMix cm, cm2;
	
	/* no help need here */
	private String help = i18n.tr("No help");
	
	/* explanation string */
	private String explain = i18n.tr("We use a simple analogy as the one-way function. " +
			"Mixing colors is an easy process, determining which colors were " +
			"originally used is a difficult process, thus this acts like an one-way function");

	private boolean isNextText;
	
	private static final long serialVersionUID = 7529617215150828381L;
	
	/**
	 * Construct our view and layout its subcomponents
	 */
	public DemoOneWayView() {
		super();
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		layout.setConstraints(this.getNextButton(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		layout.setConstraints(this.getBackButton(), gbc);
		
		this.keyExchangeExplain = new JLabel();
		this.keyExchangeExplain.setText("<html><div style=\"width:200px; height:100px\">" + explain + "</div></html>");
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		this.add(keyExchangeExplain, gbc);
		
		cm = new ColorMix(70, new Dimension(300, 70));
		cm2 = new ColorMix(70, new Dimension(300, 70));
		cm.setEllipColor(0, Color.RED);
		cm.setEllipColor(1, Color.YELLOW);
		cm2.setEllipColor(0, Color.RED);
		cm2.setEllipColor(1, Color.YELLOW);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		this.add(cm, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		this.add(cm2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		easy = new JLabel(i18n.tr("easy"));
		this.add(easy, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		hard = new JLabel(i18n.tr("hard"));
		this.add(hard, gbc);
		
		cm.mixColors(true, true, null);
		cm2.seperateColors(true, true);
	}

	/**
	 * help the user with an explanation
	 * @return a help string
	 */
	public String getHelp() {
		return help;
	}
	
	public void setNextText() {
		this.keyExchangeExplain.setText("<html><div style=\"width:200px; height:100px\">" + i18n.tr("To achive this, we use " +
				"something called one-way function. This function is easy to compute " +
				"in one direction, but difficult to reverse." + "</div></html>"));
		this.isNextText = true;
	}
	
	public boolean isNextText() {
		return isNextText;
	}

}
