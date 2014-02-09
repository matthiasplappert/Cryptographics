package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.ColorChannel;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.ColorChooser;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.ColorMix;
import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.NextStepCallback;

public class ChoosePublicColorView extends JPanel {

	private static final long serialVersionUID = 5764374133753732451L;
	
	private JLabel choosePublicLbl;
	
	private JButton multiBtn;

	private ColorChannel cc;

	private ColorMix cm;
	
	private ColorChooser chooser;
	
	private Color[] toChooseFrom = {Color.BLUE, Color.CYAN,
			Color.DARK_GRAY, Color.GREEN, Color.MAGENTA,
			Color.ORANGE, Color.PINK, Color.RED,
			Color.YELLOW
	};
	
	public ChoosePublicColorView() {
		super();
		GridBagConstraints gbc = new GridBagConstraints();
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
	}
	
	private void sendPublicColor() {
		this.cc.setRepeat(false);
		this.cc.setKeepColor(true);
		this.cc.choosePublicColor(this.chooser.getCurrentColor());
		this.cc.sendPublicColor(new NextStepCallback() {
			
			@Override
			public void callback() {
				mixPrivateColorStep();
			}
		});
	}

	private void mixPrivateColorStep() {
		
	}
}
