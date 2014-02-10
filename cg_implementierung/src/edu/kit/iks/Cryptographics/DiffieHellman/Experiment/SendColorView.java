package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SendColorView extends JPanel {

	private static final long serialVersionUID = 539729162359687203L;
	
	JLabel congrats = new JLabel("<html><div style=\"width:200px\">" +
			"Congratulations</div></html>");
	
	public SendColorView() {
		add(congrats);
		validate();
	}

}
