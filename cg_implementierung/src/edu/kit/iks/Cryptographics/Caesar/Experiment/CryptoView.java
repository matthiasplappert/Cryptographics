package edu.kit.iks.Cryptographics.Caesar.Experiment;

import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.VisualizationView;

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
public class CryptoView extends VisualizationView {

	/**
	 * Dies Das ananas.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Explanation textfield.
	 */
	private JLabel explanations;

	/**
	 * Textfield for user input. Used in experiment.
	 */
	private JTextField input;

	/**
	 * Input from the user for encryption.
	 */
	private JLabel[] userInput;

	/**
	 * Output from user interaction.
	 */
	private JLabel[] userOutput;

	/**
	 * The alphabet.
	 */
	protected JLabel[] alphabet;

	/**
	 * Numbering of alphabet chars.
	 */
	protected JLabel[] alphabetNumbering;

	/**
	 * Constructor.
	 */
	public CryptoView() {
		this.add(new JLabel("CryptoView"));
		this.explanations = new JLabel("Explanations");
		this.add(explanations);
		this.input = new JTextField();
		this.add(input);
		this.validate();
	}

	/**
	 * Enlightens the needed JLabel.
	 */
	private void lightsOn(JLabel label) {
		// on/off
	}

	/**
	 * Sets the character c as the content of the JLabel label.
	 * 
	 * @param label
	 * @param c
	 */
	private void setContent(JLabel label, char c) {

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

	/**
	 * @return the explanations
	 */
	public JLabel getExplanations() {
		return explanations;
	}

	/**
	 * @param explanations
	 *            the explanations to set
	 */
	public void setExplanations(JLabel explanations) {
		this.explanations = explanations;
	}

}
