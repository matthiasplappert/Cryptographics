package edu.kit.iks.Cryptographics.Caesar;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;


/**
 * @author wasilij
 *
 */
public class CaesarState extends AbstractState {

	/*
	 * Dies Das ananas.
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Input from the user for encryption.
	 */
	private JLabel[] userInput;
	
	/*
	 * Output from user interaction.
	 */
	private JLabel[] userOutput;
	
	/*
	 * The Alphabet.
	 */
	private JLabel[] alphabet;
	
	/**
	 * Constructor.
	 */
	CaesarState() {
		
	}
	
	/**
	 * @param l
	 */
	public void addBackListener(ActionListener l) {
		this.backBtn.addActionListener(l);
	}
	
	/**
	 * @param l
	 */
	public void addNextListener(ActionListener l) {
		this.nextBtn.addActionListener(l);
	}

}
