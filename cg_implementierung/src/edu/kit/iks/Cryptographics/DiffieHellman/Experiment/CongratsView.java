package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.CryptographicsLib.Configuration;

/**
 * 
 * @author kai
 *
 */
public class CongratsView extends JPanel {
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(CongratsView.class);
	
	/** help string  not need here */
	private String help = "";
	
	/* congrats string */
	private String congratulations = i18n.tr("Congratulations");

	private static final long serialVersionUID = 539729162359687203L;
	
	/** label to hold the congrats string */
	JLabel congrats = new JLabel("<html><div style=\"width:200px\">" +
			congratulations + "</div></html>");

	private JButton next;
	
	/** simple constructor */
	public CongratsView() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(congrats, gbc);
		
		
		this.next = new JButton(i18n.tr("Next"));
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(next, gbc);
		
		validate();
	}

	/** return help */
	public String getHelp() {
		return help;
	}

	public JButton getNextBtn() {
		return this.next;
	}

}
