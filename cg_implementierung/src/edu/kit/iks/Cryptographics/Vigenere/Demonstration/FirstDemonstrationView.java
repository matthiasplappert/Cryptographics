package edu.kit.iks.Cryptographics.Vigenere.Demonstration;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstDemonstrationView extends JPanel{
	private static final long serialVersionUID = 6294968461280032987L;
	
	private Image clock;
	private JLabel moduloText;
	private JButton buttonNext;
	private JButton buttonBack;
	
	public FirstDemonstrationView() {
       this.add(new JLabel("VIGENERE INTRODUCTION"));
	}
}