package edu.kit.iks.Cryptographics.Caesar.Experiment;

/**
 * Model of the last step of Caesar Introduction phase and the first two steps of the experiment.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoModel {

	/**
	 * Indicates whether input from the user is needed or not.
	 */
	private boolean inputStep = false;

	/**
	 * Constructor.
	 */
	public CryptoModel() {

	}

	/**
	 * Check if the character was encrypted valid.
	 * 
	 * @param input
	 */
	public boolean checkValidChar(int key, String plain, String enc) {
		// plain is the character to encrypt and enc is the corresponding cipher.
		if ((((int) plain.charAt(0) + key) % (26 + 65)) == ((int) enc.charAt(0))) {
			return true;
		}
		return false;
	}

	/**
	 * @param input
	 */
	public boolean handleInput(String input) {
		// TODO: something intelligent with the input.
		if (input.length() < 10 /* && input.matches("A-Z,a-z") */) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 */
	public char[] generatePlainText() {
		// TODO: Generate a random name!
		char[] string = { 'A', 'N', 'N', 'A' };
		return string;
	}
	
	/**
	 * @return
	 */
	public char[] generateCipher() {
		//TODO: generate a random cipher.
		char[] cipher = {'D', 'Q', 'Q', 'D'};
		return cipher;
		
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
