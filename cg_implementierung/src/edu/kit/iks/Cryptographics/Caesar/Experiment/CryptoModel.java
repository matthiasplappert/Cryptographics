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
	 * @param key
	 * @param cipher
	 * @return
	 */
	public String decrypt(int key, String cipher) {

		String plain = "";

		for (int i = 0; i < cipher.length(); i++) {
			if ((int) cipher.charAt(i) < 65 || (int) cipher.charAt(i) > 90) {
				continue;
			}
			int offset = (int) cipher.charAt(i);
			if (((int) cipher.charAt(i) - key) < 65) {
				offset = offset + 25;
			}
			plain += String.valueOf((char) (offset - key));
		}
		return plain;

	}

	/**
	 * Check if the character was encrypted valid.
	 * 
	 * @param input
	 */
	public boolean checkValidChar(int key, String plain, String enc, boolean encryption) {
		// plain is the character to encrypt and enc is the corresponding cipher.
		int offset = (int) plain.charAt(0);
		if (((int) plain.charAt(0) + key) < 65) {
			offset = offset + 25;
		}
		if ((offset + key) % (65+25) == ((int) enc.charAt(0))) {
			return true;
		}
		return false;
	}

	/**
	 * @param key
	 * @return
	 */
	public boolean handleKeyInput(int key) {
		if (key > 0 && key < 26) {
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
		// TODO: generate a random cipher.
		char[] cipher = { 'D', 'Q', 'Q', 'D' };
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

	public int generateKey() {
		// TODO: Need a random key generator.
		return 3;
	}
}
