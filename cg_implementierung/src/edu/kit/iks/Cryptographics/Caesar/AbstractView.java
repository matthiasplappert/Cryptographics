package edu.kit.iks.Cryptographics.Caesar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This view appears first when user finished understanding the animations from
 * the CFirstView. It is used in the last step of the demonstration phase, in
 * the first and second step of the experiment phase. Because of the small
 * differences between the views of those steps the view is packed in only one
 * Class.
 * 
 * The differences are: 1. When in last step of demonstration phase the
 * explanations JTextField is visible and contains needed explanations. Also the
 * JTextField for the input from the user is disabled. UserOutput is disabled
 * and invisible as well. Also the alphabet is not clickable. And UserInput
 * contains generated String from the program and no real user input.
 * 
 * 2. When in first step of the experiment phase input is enabled for user
 * input. And the explanation textfield is disabled throughout the whole
 * experiment phase. Alphabet becomes also clickable.
 * 
 * 3. UserOutput is only shown when needed.
 * 
 * This view provides elements that allow the user to encrypt his input and
 * decrypt the generated cipher.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class AbstractView {

	/**
	 * Dies Das ananas.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Explanation textfield.
	 */
	protected JLabel explanations;

	/**
	 * Textfield for user input. Used in experiment.
	 */
	protected JTextField input;

	/**
	 * Input from the user for encryption.
	 */
	protected JLabel[] userInput;

	/**
	 * Output from user interaction.
	 */
	protected JLabel[] userOutput;

	/**
	 * The alphabet.
	 */
	protected JLabel[] alphabet;

	/**
	 * Numbering of alphabet chars.
	 */
	protected JLabel[] alphabetNumbering;
	
	/**
	 *  Buttons for navigating for- and backwards in the animation.
	 */
	protected JButton nextBtn;
	protected JButton backBtn;

	/**
	 * Constructor.
	 */
	public AbstractView() {

	}

	/**
	 * Enlightens the needed JLabel.
	 */
	public void lightsOn(JLabel label) {
		// on/off
	}
	
	/** Sets the character c as the content of the JLabel label.
	 * @param label
	 * @param c
	 */
	public void setContent(JLabel label, char c) {
		
	}
	
	/**
	 * Inserts the input from the user or the generated input from the program
	 * into the JLabel Array and displays it.
	 * 
	 * @param input
	 */
	public void insertInput(String input) {

	}
	
	/**
	 * @return backBtn
	 */
	public JButton getBackBtn() {
		return backBtn;
	}

	/**
	 * @return nextBtn
	 */
	public JButton getNextBtn() {
		return nextBtn;
	}

	/**
	 * @return input
	 */
	public JTextField getInput() {
		return input;
	}

	/**
	 * @return the userInput
	 */
	public JLabel[] getUserInput() {
		return userInput;
	}

	/**
	 * @param userInput
	 *            the userInput to set
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
	 * @param userOutput
	 *            the userOutput to set
	 */
	public void setUserOutput(JLabel[] userOutput) {
		this.userOutput = userOutput;
	}

	/**
	 * @return the alphabet
	 */
	public JLabel[] getAlphabet() {
		return alphabet;
	}

	/**
	 * @param alphabet
	 *            the alphabet to set
	 */
	public void setAlphabet(JLabel[] alphabet) {
		this.alphabet = alphabet;
	}

}
