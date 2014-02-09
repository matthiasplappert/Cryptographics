package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		this.cc.choosePublicColor(Color.BLUE);
		this.cm = new ColorMix(50, new Dimension(200, 200));
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(this.cm, gbc);
		this.cc.loadView();
		this.cc.setRepeat(false);
		this.cc.setKeepColor(true);
		this.validate();
		

		this.cc.sendPublicColor(new NextStepCallback() {
			
			@Override
			public void callback() {
				for(ActionListener al : getNextButton().getActionListeners()) {
					getNextButton().removeActionListener(al);
				}
				getNextButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						cc.chooseAlicePrivateColor(Color.GREEN);
						cc.mixAlicePrivatePublic();
						cm.setEllipColor(0, cc.getPublicColor());
						cm.setEllipColor(1, cc.getAlicePrivateColor());
						cm.mixColors(true, false, new NextStepCallback() {
							
							@Override
							public void callback() {
								for(ActionListener al : getNextButton().getActionListeners()) {
									getNextButton().removeActionListener(al);
								}
								getNextButton().addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										cc.sendAliceMixedColorToBob(new NextStepCallback() {
											
											@Override
											public void callback() {
												for(ActionListener al : getNextButton().getActionListeners()) {
													getNextButton().removeActionListener(al);
												}
												getNextButton().addActionListener(new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) {
														cc.chooseBobPrivateColor(Color.RED);
														cm.setEllipColor(1, cc.getBobPrivateColor());
														cm.mixColors(true, false, new NextStepCallback() {
															
															@Override
															public void callback() {
																for(ActionListener al : getNextButton().getActionListeners()) {
																	getNextButton().removeActionListener(al);
																}
																getNextButton().addActionListener(new ActionListener() {
																	@Override
																	public void actionPerformed(ActionEvent e) {
																		cc.setColorNextToSend(cm.getMixedColor());
																		cc.sendBobMixedColorToAlice(new NextStepCallback() {
																			
																			@Override
																			public void callback() {
																				cc.mixAliceFinalSecret(new NextStepCallback() {
																					
																					@Override
																					public void callback() {
																						cc.mixBobFinalSecret(null);
																					}
																				});
																			}
																		});
																	}
																});
															}
														});
													}
												});
											}
										});
									}
								
							});
							}
						});
					}
				});
			}
		});
	}





	public ColorChannel getColorChannel() {
		return this.cc;
	}

}
