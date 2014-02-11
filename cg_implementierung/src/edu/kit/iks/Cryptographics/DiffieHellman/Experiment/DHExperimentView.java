package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.ColorChannel;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.ColorChooser;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.ColorMix;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.NextStepCallback;

public class DHExperimentView extends JPanel {

	private static final long serialVersionUID = 5764374133753732451L;
	
	private String explanation1 = "Now it is your turn! Choose a public color, which " +
			"will be the basis for the coming operations. If you are finished choosing, " +
			"click the 'send color' button to send it to Bob.";
	
	private String explanation2 = "Now you can choose a private color which you can mix with the " +
			"public color you previously send to Bob. If you have choosen the color you liked, click " +
			"the 'Mix with public color' button";
	
	private String explanation3 = "The next step is to send the right color to Bob, as " +
			"shown in the demonstration. You have three possible colors to send and " +
			"one is the right color. If you need help click the 'help' button";
	
	private String wrongPrivate = "Oh no. You choosed the private color. This color " +
			"is meant to be private. If you had send this color, Eve would be able " +
			"to get the secret too, afterwards. " +
			"Please try again, by choosing another color and clicking" +
			" the 'send color' button";
	
	private String wrongPublic = "Oh no. You choosed the public color. While Eve " +
			"won't be able to get the secret shared color, you still didn't follow " +
			"the protocol instructions. Try again by choosing another color. ";
	
	private String rightColor = "Good. You choosed to send your mixture to Bob. This is " +
			"the right choice.";
	
	private String bobsTurn = "Now it is Bobs turn. Click the continue button, so that" +
			" Bob will choose his private color and send you his mixture. ";
	
	private String finalSecret = "This is the last step in the protocol. " +
			"Choose the right colors to produce the final secret, just like " +
			"how it was explained at the demonstration. ";
	
	private String congrats = "Congratulations, you choosed the right colors to mix, " +
			"you and Bob established a shared secret that Eve doesn not know";
	
	/*
	 * the current help String
	 */
	private String help;
	
	private String help1 = "You have to choose a public color, " +
			"to choose a different color you have to click the '->' or " +
			"'<-' Button. You can't do much wrong. When you are ready " +
			"click the 'send color' button";
	
	private String help2 = "You have to choose a private color, which " +
			"is not the same as the public color. To choose a color, " +
			"you have to click the '->' or the '<-' Button. You can't do " +
			"much wrong. When you are ready, click the 'mix colors' button";
	
	private String help3 = "";
	
	private String help4 = "";
	
	private String help5 = "";
	
	private JLabel choosePublicLbl;
	
	private JButton multiBtn;

	private ColorChannel cc;

	private ColorMix cm;
	
	private ColorChooser chooser, chooser2;
	
	private GridBagConstraints gbc;
	
	private Color[] toChooseFrom = {Color.BLUE, Color.CYAN,
			Color.DARK_GRAY, Color.GREEN, Color.MAGENTA,
			Color.ORANGE, Color.PINK, Color.RED,
			Color.YELLOW
	};
	
	private Color[] rememberColors = toChooseFrom;

	private ActionListener remember;

	
	
	public DHExperimentView() {
		super();
		gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		this.choosePublicLbl = new JLabel();
		this.choosePublicLbl.setText("<html><div style=\"width:300px\">" + explanation1 + "</div></html>");
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(choosePublicLbl, gbc);
		this.cc = new ColorChannel(new Dimension(700, 200), 50);
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(this.cc, gbc);
		
		this.cm = new ColorMix(50, new Dimension(200, 200));
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(this.cm, gbc);
		
		this.chooser = new ColorChooser(new Dimension(50, 50), Color.BLUE, toChooseFrom);
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.gridx = 3;
		gbc.gridy = 1;
		this.add(this.chooser, gbc);
		
		this.multiBtn = new JButton("Send Color");
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		this.add(this.multiBtn, gbc);
		this.multiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(ActionListener al : multiBtn.getActionListeners()) {
					multiBtn.removeActionListener(al);
				}
				sendPublicColor();
			}
		});
		validate();
	}
	
	private void sendPublicColor() {
		this.cc.setRepeat(false);
		this.cc.setKeepColor(true);
		this.cc.choosePublicColor(this.chooser.getCurrentColor());
		this.cc.sendPublicColor(new NextStepCallback() {
			
			@Override
			public void callback() {
				choosePublicLbl.setText("<html><div style=\"width:300px\">" + explanation2 + "</div></html>");
				multiBtn.setText("Mix with public color");
				multiBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!chooser.getCurrentColor().equals(cc.getPublicColor())) {
							for(ActionListener al : multiBtn.getActionListeners()) {
								multiBtn.removeActionListener(al);
							}
							mixPrivateColorStep();
							
						} else {
							choosePublicLbl.setText("The private color can't be the same" +
									" as the public color");
						}
					}
				});
			}
		});
	}

	private void mixPrivateColorStep() {
		cc.chooseAlicePrivateColor(chooser.getCurrentColor());
		cc.mixAlicePrivatePublic();
		cm.setEllipColor(0, cc.getPublicColor());
		cm.setEllipColor(1, cc.getAlicePrivateColor());
		cm.setComputeFinalMix(false);
		cm.mixColors(true, false, new NextStepCallback() {
			
			@Override
			public void callback() {
				chooser.setToChooseFrom(new Color[]{cc.getPublicColor(), cc.getAlicePrivateColor(),
						cm.getMixedColor()
				});
				toChooseFrom = chooser.getToChooseFrom();
				choosePublicLbl.setText("<html><div style=\"width:300px\">" + explanation3 + "</div></html>");
				multiBtn.setText("Send color");
				multiBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						sendMixedColor();						
					}
				});
			}
		});
	}
	
	private void sendMixedColor() {
		if(chooser.getCurrentColor().equals(cc.getAliceMixedColor())) {
			for(ActionListener al : multiBtn.getActionListeners()) {
				multiBtn.removeActionListener(al);
			}
			choosePublicLbl.setText("<html><div style=\"width:300px\">" + rightColor + "</div></html>");
			cc.sendAliceMixedColorToBob(new NextStepCallback() {
				
				@Override
				public void callback() {
					choosePublicLbl.setText("<html><div style=\"width:300px\">" + bobsTurn + "</div></html>");
					multiBtn.setText("Continue");
					multiBtn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							for(ActionListener al : multiBtn.getActionListeners()) {
								multiBtn.removeActionListener(al);
							}
							sendBobMixedColor();
						}
					});
				}
			});
		} else {
			if(chooser.getCurrentColor().equals(cc.getAlicePrivateColor())) {
				choosePublicLbl.setText("<html><div style=\"width:300px\">" + wrongPrivate + "</div></html>");
			} else {
				choosePublicLbl.setText("<html><div style=\"width:300px\">" + wrongPublic + "</div></html>");
			}
		}
	}
	
	private void sendBobMixedColor() {
		cc.chooseBobPrivateColor(randomColor());
		cm.setEllipColor(1, cc.getBobPrivateColor());
		cm.mixColors(true, false, new NextStepCallback() {
			
			@Override
			public void callback() {
				cc.sendBobMixedColorToAlice(new NextStepCallback() {
					
					@Override
					public void callback() {
						Color[] param = new Color[]{cc.getPublicColor(),
								cc.getAlicePrivateColor(), cc.getAliceMixedColor(),
								cc.getBobMixedColor()};
						chooser2 = new ColorChooser(new Dimension(50, 50), param[0], param);
						gbc.gridx = 3;
						gbc.gridy = 0;
						add(chooser2, gbc);
						chooser.setToChooseFrom(param);
						choosePublicLbl.setText("<html><div style=\"width:300px\">" + finalSecret + "</div></html>");
						multiBtn.setText("Mix colors to final secret");
						validate();
						multiBtn.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								mixFinalColors();
							}
						});
					}
				});
			}
		});
	}
	
	private void mixFinalColors() {
		if((chooser.getCurrentColor().equals(cc.getAlicePrivateColor())
				&& chooser2.getCurrentColor().equals(cc.getBobMixedColor()))
				|| (chooser.getCurrentColor().equals(cc.getBobMixedColor())
						&& chooser2.getCurrentColor().equals(cc.getAlicePrivateColor()))) {
			//choosed the right colors
			for(ActionListener al : multiBtn.getActionListeners()) {
				multiBtn.removeActionListener(al);
			}
			choosePublicLbl.setText("<html><div style=\"width:300px\">" + congrats + "</div></html>");
			cc.mixAliceFinalSecret(new NextStepCallback() {
				
				@Override
				public void callback() {
					cc.mixBobFinalSecret(new NextStepCallback() {
						
						@Override
						public void callback() {
							multiBtn.setText("Continue");
							multiBtn.addActionListener(remember);
						}
					});
				}
			});
		} else {
			choosePublicLbl.setText("<html><div style=\"width:120px\">" +
					"You choosed the wrong colors, try again</div></html>");
			
			validate();
		}
	}
		
	/*
	 * randomColor from remember - toChooseFrom
	 */
	private Color randomColor() {
		Color randColor = rememberColors[randInt(0, rememberColors.length-1)];
		while(in(randColor, toChooseFrom)) {
			randColor = rememberColors[randInt(0, rememberColors.length-1)];
		}
		return randColor;
	}
	
	private boolean in(Color rand, Color[] colors) {
		for(int i=0; i < colors.length; i++) {
			if(rand.equals(colors[i])) {
				return true;
			}
		}
		return false;
	}
	
	private int randInt(int min, int max) {
		Random rand = new Random();
		
		int randNum = rand.nextInt((max-min) + 1) + min;
		
		return randNum;
	}
	
	public void setRemember(ActionListener remember) {
		this.remember = remember;
	}

	public String getHelp() {
		return help;
	}
}
