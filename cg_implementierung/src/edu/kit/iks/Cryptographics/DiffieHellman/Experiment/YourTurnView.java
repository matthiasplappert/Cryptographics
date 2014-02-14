package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.CryptographicsLib.Configuration;
import edu.kit.iks.CryptographicsLib.VisualizationView;

public class YourTurnView extends VisualizationView {
	
	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(YourTurnView.class);
	
	private JLabel aimExplain;

	private String help;
	
	private String explain = i18n.tr("Now it's your turn! " +
				"Now you are Alice and try to establish a shared secret " +
				"with Bob, without Eve getting the secret. Your " +
				"task will be to mix the right Colors and to send " +
				"the right Colors, just like in the Demonstration");

	private static final long serialVersionUID = -9208922057840794898L;

	public YourTurnView() {
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		
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
		
		this.aimExplain = new JLabel();
		this.aimExplain.setText("<html><div style=\"width:200px\">" + explain + "</div></html>");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		this.add(aimExplain, gbc);
	}

	public String getHelp() {
		return help ;
	}


}
