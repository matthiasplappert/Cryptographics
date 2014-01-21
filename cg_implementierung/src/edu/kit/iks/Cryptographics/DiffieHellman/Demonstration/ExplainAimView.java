package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class ExplainAimView extends VisualizationView {
	
	private JLabel aimExplain;
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 5986978581223106407L;

	public ExplainAimView() {
		super();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.aimExplain = new JLabel();
		this.aimExplain.setText("Our aim is to exchange a secret key on a public channel");
		this.add(aimExplain);
	}

}
