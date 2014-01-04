package edu.kit.iks.Cryptographics.Caesar.Experiment;

import edu.kit.iks.Cryptographics.Caesar.CGeneralExperimentModel;

/**
 * TODO:!!!!!!!!!!!!!Temporary class. We'll see where to put it in. Not used at
 * the moment. !!!!!!!!!!
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CThirdModel extends CGeneralExperimentModel {

	/**
	 * Indicates whether input from the user is needed or not.
	 */
	private boolean inputStep = false;

	/**
	 * Constructor.
	 */
	public CThirdModel() {

	}

	/**
	 * @param input
	 */
	public String handleInput(String input) {
		// do something intelligent with the input.
		return input;
	}

	/**
	 * @return the inputStep
	 */
	public boolean isInputStep() {
		return inputStep;
	}

	/**
	 * @param inputStep
	 *            the inputStep to set
	 */
	public void setInputStep(boolean inputStep) {
		this.inputStep = inputStep;
	}

	/**
	 * @param cipher
	 * @param plaintext
	 */
	public boolean decryptAndCheck(String cipher, String plaintext) {
		// something intelligent and fully uncreative.
		return true;
	}
}
