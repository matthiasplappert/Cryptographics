package edu.kit.iks.Cryptographics.Caesar;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;


/**
 * @author Wasilij Beskorovajnov.
 *
 */
public class CaesarView extends AbstractView {

	/**
	 * Dies Das ananas.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Input from the user for encryption.
	 */
	private JLabel[] userInput;
	
	/**
	 * Output from user interaction.
	 */
	private JLabel[] userOutput;
	
	/**
	 * The Alphabet.
	 */
	private ClickableLabel[] alphabet;
	
	/**
	 * Constructor.
	 */
	public CaesarView() {
		
	}
	
	/**
	 * @param l
	 */
	public void addBackBtnListener(ActionListener l) {
		this.backBtn.addActionListener(l);
	}
	
	/**
	 * @param l
	 */
	public void addNextBtnListener(ActionListener l) {
		this.nextBtn.addActionListener(l);
	}

	/** Action handler for user's input.
	 * @param l
	 */
	public void addInputPerformed(ActionListener l) {
		this.input.addActionListener(l);
	}
	/**
	 * @return the userInput
	 */
	public JLabel[] getUserInput() {
		return userInput;
	}

	/**
	 * @param userInput the userInput to set
	 */
	public void setUserInput(JLabel[] userInput) {
		this.userInput = userInput;
	}

	/**
	 * @return the userOutput
	 */
	public JLabel[] getUserOutput() {
		return userOutput;
	}

	/**
	 * @param userOutput the userOutput to set
	 */
	public void setUserOutput(JLabel[] userOutput) {
		this.userOutput = userOutput;
	}

	/**
	 * @return the alphabet
	 */
	public ClickableLabel[] getAlphabet() {
		return alphabet;
	}

	/**
	 * @param alphabet the alphabet to set
	 */
	public void setAlphabet(ClickableLabel[] alphabet) {
		this.alphabet = alphabet;
	}

}
