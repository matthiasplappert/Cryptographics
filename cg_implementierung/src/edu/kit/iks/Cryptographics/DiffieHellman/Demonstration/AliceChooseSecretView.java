package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class AliceChooseSecretView extends VisualizationView {

	private JLabel aliceExplain;
	
	private ColorChannel cc;
	
	private ColorMix cm;
	/**
	 * 
	 */
	private static final long serialVersionUID = 87178534093974249L;
	
	
	
	public AliceChooseSecretView() {
		super();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.aliceExplain = new JLabel();
		this.aliceExplain.setText("<html><div style=\"width:120px\"Alice chooses a public color and sends it to Bob" +
				"Eve listens to the channel and gets a copy</div></html>");
		gbc.weightx = 0.5;
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(aliceExplain, gbc);
		this.cc = new ColorChannel(100, 500, 150, 60);
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(this.cc, gbc);

		this.cm = new ColorMix(Color.BLUE, Color.GREEN, 50);
		
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(this.cm, gbc);
		this.cc.loadView();
		System.out.println(this.cc.getSize());
		this.cc.setRepeat(false);
		this.cc.setKeepColor(true);
		this.cc.setColor(Color.BLUE);
		this.cc.sendToBob(new NextStepCallback() {
			
			@Override
			public void callback() {
				cm.mixColors(true, false, new NextStepCallback() {
					
					@Override
					public void callback() {
						cc.setColor(cm.getMixedColor());
						cc.sendToBob(new NextStepCallback() {
							
							@Override
							public void callback() {
								cm.setEllipColor(2, Color.RED);
								cm.mixColors(true, false, new NextStepCallback() {
									
									@Override
									public void callback() {
										cc.setColor(cm.getMixedColor());
										cc.sendToAlice(null, 2, true);										
									}
								}, 1);
							}
						}, 1, true);
					}
				}, 0);			
			}
		}, 0, true);
	}





	public ColorChannel getColorChannel() {
		return this.cc;
	}

}
