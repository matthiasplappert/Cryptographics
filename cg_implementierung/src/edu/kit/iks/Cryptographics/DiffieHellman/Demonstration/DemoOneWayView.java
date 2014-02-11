package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import edu.kit.iks.CryptographicsLib.VisualizationView;

public class DemoOneWayView extends VisualizationView {
	private JLabel keyExchangeExplain;
	
	private ColorMix cm, cm2;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7529617215150828381L;
	
	public DemoOneWayView() {
		super();
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		layout.setConstraints(this.getNextButton(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		layout.setConstraints(this.getBackButton(), gbc);
		
		this.keyExchangeExplain = new JLabel();
		this.keyExchangeExplain.setText("<html><div style=\"width:200px;\">We use a simple analogy as the one-way function." +
				"Mixing colors is an easy process, determining which colors were" +
				"originally used is a difficult process, thus this acts like an one-way function</div></html>");
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		this.add(keyExchangeExplain, gbc);
		
		cm = new ColorMix(70, new Dimension(400, 400));
		cm2 = new ColorMix(70, new Dimension(400, 400));
		cm.setEllipColor(0, Color.RED);
		cm.setEllipColor(1, Color.YELLOW);
		cm2.setEllipColor(0, Color.RED);
		cm2.setEllipColor(1, Color.YELLOW);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		this.add(cm, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(cm2, gbc);
		
		cm.mixColors(true, true, null);
		cm2.seperateColors(true, true);
	}

}
