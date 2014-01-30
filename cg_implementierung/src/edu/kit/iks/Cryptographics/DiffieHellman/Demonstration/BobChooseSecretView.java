package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class BobChooseSecretView extends VisualizationView{
	private JLabel bobExplain;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3546422466717280715L;
	
	public BobChooseSecretView() {
		super();
		this.setLayout(new GridBagLayout());
		this.bobExplain = new JLabel();
		this.bobExplain.setText("Bob chooses a color");
		this.add(bobExplain);
	}

}
