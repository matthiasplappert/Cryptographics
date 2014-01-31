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

	private final int ASCII_A = 'A';

	private final int MODULO = 26;

	/**
	 * Constructor.
	 */
	public CryptoModel() {

	}

	public String dec(int key, String cipher) {

		return enc(-key, cipher);
	}

	/**
	 * Function for decrypting and encrypting.
	 * 
	 * @param key
	 * @param text
	 * @return
	 */
	public String enc(int key, String text) {

		String cipher = "";
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != ' ') {
				int offset = ((int) text.charAt(i)) - ASCII_A;
				int character = ((offset + MODULO) + key) % MODULO;

				cipher += String.valueOf((char) (character + ASCII_A));
			} else {
				cipher += " ";
			}
		}
		return cipher;

	}

	/**
	 * @param key
	 * @return
	 */
	public boolean isKeyValid(int key) {
		if (key > 0 && key <= 26) {
			return true;
		}
		return false;
	}

	/**
	 * @param input
	 */
	public boolean isInputValid(String input) {
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
		return enc(key, plain);
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
