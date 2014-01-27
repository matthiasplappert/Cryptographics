package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import edu.kit.iks.CryptographicsLib.VisualizationView;

public class MixColorView extends VisualizationView {
	
	private JLabel mixExplain;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3545699465433197429L;
	
	public MixColorView() {
		this.setLayout(new GridBagLayout());
		this.mixExplain = new JLabel();
		this.mixExplain.setText("Mix the color");
		this.add(mixExplain);
	}

}
