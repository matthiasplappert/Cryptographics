package edu.kit.iks.Cryptographics.Caesar;

/**
 * TODO:!!!!!!!!!!!!!Temporary class. We'll see where to put it in. Not used at the
 * moment. !!!!!!!!!!
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CaesarModel {

	/**
	 * Indicates whether input from the user is needed or not.
	 */
	private boolean inputStep = false;

	/**
	 * @param input
	 */
	public void handleInput(String input) {
		// do something intelligent with the input.
	}

	// Step 1, Encryption.

	/**
	 * Check if the character was encrypted valid.
	 * 
	 * @param c
	 */
	public void checkValidChar(char c) {
		// ch ch ch check :D
	}

	/**
	 * @param cipher
	 * @param plaintext
	 */
	public void decryptAndCheck(String cipher, String plaintext) {
		// something intelligent und fully uncreative.
	}

	/**
	 * 
	 */
	public void updateView() {
		// The name is selfexplanatory.
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

}
