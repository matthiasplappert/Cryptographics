package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
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
		this.setLayout(new GridBagLayout());
		this.aliceExplain = new JLabel();
		this.aliceExplain.setText("<html><div style=\"width:120px\"Alice chooses a public color and sends it to Bob" +
				"Eve listens to the channel and gets a copy</div></html>");
		this.add(aliceExplain);
		this.cc = new ColorChannel(100, 500, 150, 60);
		this.cc.setPreferredSize(new Dimension(700, 700));
		this.add(this.cc);
		this.cm = new ColorMix(Color.BLUE, Color.GREEN, 50);
		this.cm.setPreferredSize(new Dimension(300, 300));
		this.add(this.cm);
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
										cc.sendToAlice(null, 2);										
									}
								}, 1);
							}
						}, 1);
					}
				}, 0);			
			}
		}, 0);
	}

}
