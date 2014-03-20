package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelExplanation extends JPanel {
	
	private String p = "p - The base color";
	
	private String sA = "sA - Alice's secret color";
	
	private String sB = "sB - Bob's secret color";
	
	private String AM = "AM - Mixture of sA and p";
	
	private String BM = "BM - Mixture of sB and p";
	
	public LabelExplanation() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		this
		this.add(new JLabel(p));
		this.add(new JLabel(sA));
		this.add(new JLabel(sB));
		this.add(new JLabel(AM));
		this.add(new JLabel(BM));
	}
}
