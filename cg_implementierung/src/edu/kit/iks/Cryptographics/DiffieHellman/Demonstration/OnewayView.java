package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class OnewayView extends VisualizationView {
	
	private JLabel onewayExplain;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6243104730541136349L;
	
	public OnewayView() {
		super();
		this.setLayout(new GridBagLayout());
		this.onewayExplain = new JLabel();
		this.onewayExplain.setText("<html><div style=\"width:200px\">To achive this, we use " +
				"something called one-way function. This function is easy to compute" +
				"in one direction, but difficult to reverse.</div></html>");
		this.add(onewayExplain);
	}

}
