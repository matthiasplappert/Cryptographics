package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import edu.kit.iks.CryptographicsLib.VisualizationView;

public class MixColorView extends VisualizationView {
	
	private JLabel mixExplain;
	private ColorMix cm;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3545699465433197429L;
	
	public MixColorView() {
		this.setLayout(new GridBagLayout());
		this.mixExplain = new JLabel();
		this.mixExplain.setText("Mix the color");
		this.add(mixExplain);
		this.cm = new ColorMix(50, new Dimension(300, 300));
		this.cm.setEllipColor(0, Color.RED);
		this.cm.setEllipColor(1, Color.YELLOW);
		this.cm.setPreferredSize(new Dimension(900, 700));
		this.add(this.cm);
		this.cm.mixColors(true, false, null);
	}

}
