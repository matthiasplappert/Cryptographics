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

public class ChoosePublicColorView extends JPanel {

	private static final long serialVersionUID = 5764374133753732451L;
	
	private JLabel wrong;
	
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
	
	public ChoosePublicColorView() {
		super();
		gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		this.choosePublicLbl = new JLabel();
		this.choosePublicLbl.setText("<html><div style=\"width:120px\">Alice chooses a public color and sends it to Bob" +
				"Eve listens to the channel and gets a copy</div></html>");
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
				multiBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						for(ActionListener al : multiBtn.getActionListeners()) {
							multiBtn.removeActionListener(al);
						}
						mixPrivateColorStep();						
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
			cc.sendAliceMixedColorToBob(new NextStepCallback() {
				
				@Override
				public void callback() {
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
			//TODO oh you failed
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
			cc.mixAliceFinalSecret(new NextStepCallback() {
				
				@Override
				public void callback() {
					cc.mixBobFinalSecret(null);
				}
			});
		} else {
			//wrong colors
//			wrong = new JLabel("You choosed the wrong colors, try again");
//			gbc.gridx = 2;
//			gbc.gridy = 2;
//			add(wrong, gbc);
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
}
