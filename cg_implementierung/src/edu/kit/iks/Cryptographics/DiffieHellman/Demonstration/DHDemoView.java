package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.VisualizationView;

public class DHDemoView extends VisualizationView {
	
	private String explanation1 = "Now to our Diffie-Hellman Key-Exchange Analogy. Here " +
			"is how the protocol in principle works. " +
			"Alice chooses a public color and sends it to Bob. " +
				"As Eve listens to the channel she gets a copy.";
	
	private String explanation2 = "Next, Alice chooses a private Color, that she keeps " +
			"for herself, she does not send it. Then she mixes her private Color with " +
			"the previously send public Color and sends the mixture to Bob. " +
			"Note that because we use the mixing of colors as a one-way function, " +
			"Eve cannot compute which private color Alice used to get the mixture. " +
			"Keep this in mind, as this is critical to understand why this" +
			"protocol works. " +
			"As previous Bob and Eve have the send color, that means the mixture of Alice.";
	
	private String explanation3 = "Now Bob does the exact same thing like Alice did" +
			"in the previous step. " +
			"He chooses a private color. Mixes it with the public Color, " +
			"and sends the mixture to Alice. Eve gets a copy, but can't compute " +
			"the private color of Bob, because of the one-way function property";
	
	private String explanation4 = "Now comes the last step. Here we will " +
			"produce the secret that Alice and Bob know, but Eve doesn't. " +
			"Alice will mix her private color to the mixture of Bob " +
			"and Bob will mix his private color to the mixture of Alice. " +
			"That means we mix three colors, the public color, the private color " +
			"of Alice, and the private Color of Bob. " +
			"The trick lies in the combination of the private Colors, that " +
			"are kept private, through the use of the one-way function and " +
			"that it doesn't matter in which order we mix the colors. So " +
			"mixing first the public color with Alices private color and then Bobs private color " +
			"yields the same color as mixing first the public color with Bobs private color " +
			"and then Alices private color. In the real world, we need a mathematical operation " +
			"that does this and color mixing isn't used of course, but the basic principles " +
			"are the same. ";
	
	private JLabel aliceExplain;
	
	private ColorChannel cc;
	
	private ColorMix cm;
	
	private ActionListener remember;
	/**
	 * 
	 */
	private static final long serialVersionUID = 87178534093974249L;
	
	
	
	public DHDemoView() {
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
		this.aliceExplain.setText("<html><div style=\"width:300px\">" + explanation1 + "</div></html>");
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
		//TODO remove loadView?
		this.cc.loadView();
		this.cc.setRepeat(false);
		this.cc.setKeepColor(true);
		//TODO remove validate()?
		this.validate();
		
	}





	public ColorChannel getColorChannel() {
		return this.cc;
	}
	
	public void startDemo() {
		
		//TODO i know, i know, this is horrible, will refactor to look like choosepubliccoorview
		this.cc.sendPublicColor(new NextStepCallback() {
			
			@Override
			public void callback() {
				for(ActionListener al : getNextButton().getActionListeners()) {
					getNextButton().removeActionListener(al);
				}
				getNextButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						for(ActionListener al : getNextButton().getActionListeners()) {
							getNextButton().removeActionListener(al);
						}
						secondStep();
					}
				});
			}
		});
	}


	private void secondStep() {
		aliceExplain.setText("<html><div style=\"width:350px\">" + explanation2 + "</div></html>");
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
						for(ActionListener al : getNextButton().getActionListeners()) {
							getNextButton().removeActionListener(al);
						}
						thirdStep();
					}
				});
			}
		});
	}
	
	private void thirdStep() {
		aliceExplain.setText("<html><div style=\"width:350px\">" + explanation2 + "</div></html>");
		cc.sendAliceMixedColorToBob(new NextStepCallback() {
			
			@Override
			public void callback() {
				getNextButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for(ActionListener al : getNextButton().getActionListeners()) {
							getNextButton().removeActionListener(al);
						}
						fourthStep();
					}
				});
			}
		});
	}
	
	private void fourthStep() {
		aliceExplain.setText("<html><div style=\"width:350px\">" + explanation3 + "</div></html>");
		cc.chooseBobPrivateColor(Color.RED);
		cm.setEllipColor(1, cc.getBobPrivateColor());
		cm.mixColors(true, false, new NextStepCallback() {
			
			@Override
			public void callback() {
				getNextButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for(ActionListener al : getNextButton().getActionListeners()) {
							getNextButton().removeActionListener(al);
						}
						fifthStep();
					}
				});
			}
		});
	}
	
	private void fifthStep() {
		aliceExplain.setText("<html><div style=\"width:350px\">" + explanation3 + "</div></html>");
		cc.setColorNextToSend(cm.getMixedColor());
		cc.sendBobMixedColorToAlice(new NextStepCallback() {
			
			@Override
			public void callback() {
				getNextButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for(ActionListener al : getNextButton().getActionListeners()) {
							getNextButton().removeActionListener(al);
						}
						sixthStep();
					}
				});
			}
		});
	}
	
	private void sixthStep() {
		aliceExplain.setText("<html><div style=\"width:350px\">" + explanation4 + "</div></html>");
		getNextButton().addActionListener(remember);
		cc.mixAliceFinalSecret(new NextStepCallback() {
			
			@Override
			public void callback() {
				cc.mixBobFinalSecret(null);
			}
		});
	}

	public void setRemember(ActionListener remember) {
		this.remember = remember;
	}

}
