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
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		layout.setConstraints(this.getNextButton(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		layout.setConstraints(this.getBackButton(), gbc);
		
		this.aliceExplain = new JLabel();
		this.aliceExplain.setText("<html><div style=\"width:120px\">Alice chooses a public color and sends it to Bob" +
				"Eve listens to the channel and gets a copy</div></html>");
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(aliceExplain, gbc);
		this.cc = new ColorChannel(new Dimension(700, 200), 50);
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(this.cc, gbc);

		this.cm = new ColorMix(Color.BLUE, Color.GREEN, 50, new Dimension(200, 200));
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(this.cm, gbc);
		this.cc.loadView();
		this.cc.setRepeat(false);
		this.cc.setKeepColor(true);
		this.cc.setColorNextToSend(Color.BLUE);
		this.validate();
		
		this.cc.sendToBob(new NextStepCallback() {
			
			@Override
			public void callback() {
				cc.chooseColorToKeep(Color.GREEN, 0);
				cm.mixColors(true, false, new NextStepCallback() {
					
					@Override
					public void callback() {
						cc.setColorNextToSend(cm.getMixedColor());
						cc.sendToBob(new NextStepCallback() {
							
							@Override
							public void callback() {
								cm.setEllipColor(2, Color.RED);
								cc.chooseColorToKeep(Color.RED, 1);
								cm.mixColors(true, false, new NextStepCallback() {
									
									@Override
									public void callback() {
										cc.setColorNextToSend(cm.getMixedColor());
										cc.sendToAlice(null, 2, true);										
									}
								});
							}
						}, true);
					}
				});			
			}
		}, true);
	}





	public ColorChannel getColorChannel() {
		return this.cc;
	}

}
