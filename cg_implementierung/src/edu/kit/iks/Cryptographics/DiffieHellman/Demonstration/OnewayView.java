package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
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
		this.setBackground(Color.WHITE);
		this.onewayExplain = new JLabel();
		this.onewayExplain.setText("To achive this, we use something called one-way function");
		this.add(onewayExplain);
	}

}
