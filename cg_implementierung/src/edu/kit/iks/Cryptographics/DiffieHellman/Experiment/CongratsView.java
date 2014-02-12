package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.Cryptographics.Configuration;

public class CongratsView extends JPanel {
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(CongratsView.class);
	
	private String help;
	
	private String congratulations = i18n.tr("Congratulations");

	private static final long serialVersionUID = 539729162359687203L;
	
	JLabel congrats = new JLabel("<html><div style=\"width:200px\">" +
			congratulations + "</div></html>");
	
	public CongratsView() {
		add(congrats);
		validate();
	}

	public String getHelp() {
		return help;
	}

}
