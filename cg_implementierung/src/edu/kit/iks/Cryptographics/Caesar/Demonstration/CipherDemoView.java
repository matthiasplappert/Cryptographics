package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.kit.iks.CryptographicsLib.AlphabetStripView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/**
 * Performs animations for demonstrating Caesar's idea.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CipherDemoView extends VisualizationView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6762667303208572310L;
	
	
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
	private JLabel userInput;

	/**
	 * Output from user interaction.
	 */
	private JLabel userOutput;

	/**
	 * The alphabet.
	 */
	private AlphabetStripView alphabet;
	
	/**
	 * Button needed for proceeding the stepwise animations.
	 */
	private JButton proceed;
	
	/**
	 * Constructor.
	 */
	public CipherDemoView() {
		super();
	}

	/**
	 * @return the proceed
	 */
	public JButton getProceed() {
		return proceed;
	}

	/**
	 * @return the explanations
	 */
	public JLabel getExplanations() {
		return explanations;
	}

	/**
	 * @return the input
	 */
	public JTextField getInput() {
		return input;
	}

	/**
	 * @return the userInput
	 */
	public JLabel getUserInput() {
		return userInput;
	}

	/**
	 * @return the userOutput
	 */
	public JLabel getUserOutput() {
		return userOutput;
	}

	/**
	 * @return the alphabet
	 */
	public AlphabetStripView getAlphabet() {
		return alphabet;
	}

	/**
	 * @param explanations the explanations to set
	 */
	public void setExplanations(JLabel explanations) {
		this.explanations = explanations;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(JTextField input) {
		this.input = input;
	}

	/**
	 * @param userInput the userInput to set
	 */
	public void setUserInput(JLabel userInput) {
		this.userInput = userInput;
	}

	/**
	 * @param userOutput the userOutput to set
	 */
	public void setUserOutput(JLabel userOutput) {
		this.userOutput = userOutput;
	}

	/**
	 * @param alphabet the alphabet to set
	 */
	public void setAlphabet(AlphabetStripView alphabet) {
		this.alphabet = alphabet;
	}

	/**
	 * @param proceed the proceed to set
	 */
	public void setProceed(JButton proceed) {
		this.proceed = proceed;
	}

}
