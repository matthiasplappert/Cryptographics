package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CongratsView extends JPanel {
	
	private String help;
	
	private String congratulations = "Congratulations";

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
