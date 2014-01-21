package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class ExplainKeyExchangeView extends VisualizationView {
	private JLabel keyExchangeExplain;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7529617215150828381L;
	
	public ExplainKeyExchangeView() {
		super();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.keyExchangeExplain = new JLabel();
		this.keyExchangeExplain.setText("Our aim is to exchange a secret key on a public channel");
		this.add(keyExchangeExplain);
	}

}
