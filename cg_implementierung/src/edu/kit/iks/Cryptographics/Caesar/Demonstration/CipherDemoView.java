package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.kit.iks.Cryptographics.Caesar.Experiment.CryptoView;
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
	private JLabel[] userInput;

	/**
	 * Output from user interaction.
	 */
	private JLabel[] userOutput;

	/**
	 * The alphabet.
	 */
	private JLabel[] alphabet;

	/**
	 * Numbering of alphabet chars.
	 */
	private JLabel[] alphabetNumbering;	
	
	/**
	 * Button needed for proceeding the stepwise animations.
	 */
	private JButton proceed;
	
	/**
	 * Constructor.
	 */
	public CipherDemoView() {
		super();
		this.add(new JLabel("DemoView"));
		this.explanations = new JLabel("Explanations");
		this.add(this.explanations);
		this.proceed = new JButton("proceed");
		this.add(proceed);
		this.validate();
	}

	/**
	 * Function for performing the needed animations. After each step the
	 * animation stops and continues when user wishes.
	 * 
	 * @param c
	 */
	public void animationStart() {
		// perform first animation and show explanations.
		step1();
		// stop.
		// perform second animation and show explanations.
		step2();
		// stop.
		// ...
		step3();
		// stop.
		// perform last animation and show explanations.
		step4();
		// done.

	}

	/**
	 * Explain the elements on the screen. Only explanations are shown.
	 */
	private void step1() {

	}

	/**
	 * Describe how each character is encrypted.
	 */
	private void step2() {

	}

	/**
	 * Describe the general Caesar cipher. (The key can vary from 0-25.)
	 */
	private void step3() {

	}

	/**
	 * Describe that decryption is the same way as encryption.
	 */
	private void step4() {

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
	public JLabel[] getUserInput() {
		return userInput;
	}

	/**
	 * @return the userOutput
	 */
	public JLabel[] getUserOutput() {
		return userOutput;
	}

	/**
	 * @return the alphabet
	 */
	public JLabel[] getAlphabet() {
		return alphabet;
	}

	/**
	 * @return the alphabetNumbering
	 */
	public JLabel[] getAlphabetNumbering() {
		return alphabetNumbering;
	}

}
