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
	 * Function for decrypting and encrypting.
	 * 
	 * @param key
	 * @param text
	 * @return
	 */
	public String enc(int key, String text, boolean encryption) {

		String plain = "";
		if (!encryption) {
			key = -1 * key;
		}
		for (int i = 0; i < text.length(); i++) {
			// if ((int) text.charAt(i) < 65 || (int) text.charAt(i) > 90) {
			// continue;
			// }
        if (text.charAt(i) != ' ') {
			int offset = ((int) text.charAt(i)) - 64;

			// Overflow when decrypting.
			if ((offset + key) < 0) {
				offset = offset + 26;
			}
			int sign = (offset + key) % 26;
			if (sign == 0) {
				sign++;
			}
        
			plain += String.valueOf((char) (sign + 64));
        } else {
        	plain += " ";
        }
		}
		return plain;

	}

	/**
	 * Check if the character was encrypted valid.
	 * 
	 * @param input
	 */
	public boolean checkValidChar(int key, String plain, String enc,
			boolean encryption) {
		// plain is the character to encrypt and enc is the corresponding cipher.
		int offset = ((int) plain.charAt(0)) - 65;
		if (!encryption) {
			key = -1 * key;
		}
		if ((Math.abs((offset + key) % 26)) + 65 == ((int) enc.charAt(0))) {
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
		if (input.length() < 10 && input.length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 */
	public String getRandomPlainSequence() {
		// TODO: Generate a random name!
		String[] plainTextPool = { "ANNA", "HANNAH", "BANANA", "KOKOS",
				"KRYPTOCHEF", "HAMSTER", "WASILIJ", "SECRET", "EPSILON" };
		int index = (int) ((Math.random() * 1000) % plainTextPool.length);
		return plainTextPool[index];
	}

	/**
	 * @param key
	 * @return
	 */
	public String getRandomCipher(int key) {
		String plain = getRandomPlainSequence();
		return enc(key, plain, true);
	}

	// TODO: Not so much random at the moment.
	/**
	 * @return
	 */
	public String getRandomText() {
		String[] textPool = { "This bar diagram has a vertical beam for each character "
				+ "with the beam for the most used character being at maximum height of the diagram. "
				+ "Each other beam has a corresponding fraction of this height The equivalent "
				+ "characters are displayed beneath each beam The number of occurrences of each "
				+ "character is displayed within or above each beam" };
		return textPool[0].toUpperCase();
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

	public int generateKey() {
		int key = 0;
		do {
			key = (int) (Math.random() * 1000) % 26;
		} while (key == 0);
		return key;
	}
}
