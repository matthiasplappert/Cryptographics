package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class OnewayView extends VisualizationView {
	
	private JLabel onewayExplain;

	private String help = "No help";
	
	private String explain = "To achive this, we use " +
				"something called one-way function. This function is easy to compute" +
				"in one direction, but difficult to reverse.";
	
	private static final long serialVersionUID = 6243104730541136349L;
	
	public OnewayView() {
		super();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
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
		this.onewayExplain = new JLabel();
		this.onewayExplain.setText("<html><div style=\"width:200px\">" + explain + "</div></html>");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		this.add(onewayExplain, gbc);
		
	}

	public String getHelp() {
		return help ;
	}

}
