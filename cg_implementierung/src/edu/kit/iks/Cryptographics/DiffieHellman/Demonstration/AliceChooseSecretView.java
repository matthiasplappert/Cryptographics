package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class AliceChooseSecretView extends VisualizationView {

	private JLabel aliceExplain;
	/**
	 * 
	 */
	private static final long serialVersionUID = 87178534093974249L;
	
	public AliceChooseSecretView() {
		super();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.aliceExplain = new JLabel();
		this.aliceExplain.setText("Alice chooses a color");
		this.add(aliceExplain);
	}

}
