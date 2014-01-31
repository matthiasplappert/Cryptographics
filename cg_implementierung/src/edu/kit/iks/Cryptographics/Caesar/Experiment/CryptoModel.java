package edu.kit.iks.Cryptographics.Caesar.Experiment;

/**
 * Model of the last step of Caesar Introduction phase and the first two steps of the experiment.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoModel {

	private final int ASCII_A = 'A';

	private final int MODULO = 26;

	private final int MAX_LINE_LENGTH = 35;

	/**
	 * Constructor.
	 */
	public CryptoModel() {

	}

	/**
	 * @param stringToFormat
	 * @return
	 */
	public String formatString(String stringToFormat) {
		String formattedString = "<html><body>";
		for (int i = 0; i < stringToFormat.length(); i++) {
			if ((i % MAX_LINE_LENGTH) == 0) {
                 formattedString += "<br>";
			} else {
				formattedString += stringToFormat.charAt(i);
			}
		}
		return formattedString;
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

				cipher += String
						.valueOf((char) ((((offset + MODULO) + key) % MODULO) + ASCII_A));
			} else {
				cipher += " ";
			}
		}
		return cipher;

	}

	/**
	 * @param key
	 * @param cipher
	 * @return
	 */
	public String dec(int key, String cipher) {
		return enc(-key, cipher);
	}

	/**
	 * @param key
	 * @return
	 */
	public boolean isKeyValid(int key) {
		return (key > 0 && key <= 26);
	}

	/**
	 * @param input
	 */
	public boolean isInputValid(String input) {
		return (input.length() < 10 && input.length() > 0);
	}

	/**
	 * @return
	 */
	public String getRandomPlainSequence() {
		String[] plainTextPool = { "ANNA", "HANNAH", "BANANA", "KOKOS",
				"KRYPTOCHEF", "HAMSTER", "WASILIJ", "SECRET", "EPSILON" };

		int index = generateRandomInt(0, plainTextPool.length);
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
	 * @param a
	 * @param b
	 * @return
	 */
	private int generateRandomInt(int a, int b) {
		return (int) (a + ((int) (b - a) * Math.random()));
	}

	public int generateKey() {
		return generateRandomInt(1, 26);
	}
}
