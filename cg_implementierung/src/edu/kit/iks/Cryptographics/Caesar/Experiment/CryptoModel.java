package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.util.regex.Pattern;

/**
 * Model of the last step of Caesar Introduction phase and the first two steps of the experiment.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoModel {

	private final int ASCII_A = 'A';

	private final int MODULO = 26;

	// The format for a formatted String.
	private final int MAX_LINE_LENGTH = 60;

	// The line length of a formatted String must be 35 < lineLength < 45.
	private final int MAX_LINE_VARIATION = 5;

	// number of chars in <html><body>.
	private final int HTML_HEADER_LENGTH = 12;

	// number of chars in <br>.
	private final int LINEBREAK_LENGTH = 4;

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
		for (int i = 1; i < stringToFormat.length(); i++) {
			if ((i % MAX_LINE_LENGTH) == 0) {
				formattedString += "<br>";
			} else {
				formattedString += stringToFormat.charAt(i);
			}
		}
		return formattedString;
	}

	/**
	 * @param stringToClear
	 * @return
	 */
	public String clearString(String stringToClear) {
		String clearedString = "";
		for (int i = HTML_HEADER_LENGTH; i < stringToClear.length(); i++) {
			// remove all linebreaks.
			if ((i + LINEBREAK_LENGTH) < stringToClear.length()
					&& Pattern.matches("<br>",
							stringToClear.subSequence(i, i + LINEBREAK_LENGTH))) {
				clearedString += " ";
				i += LINEBREAK_LENGTH;
			} else {
				clearedString += stringToClear.charAt(i);
			}
		}
		return clearedString;
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
		String[] textPool = { "<html><body>"
				+ "The diagram you see here shows the frequency of each letter in the text you are<br>"
				+ "reading at the moment. It is called a Histogram. If you would count all E's in <br>"
				+ "this explanation you would get the number you see in the diagram on the column above<br>"
				+ "the letter E. Let's assume that this explanation is a normal english text and that in<br>"
				+ "all english texts E is the most frequent letter! Now the program will encrypt this<br>"
				+ "explanationwith an unknown key in a most awesome way and we will see the histogram of<br>"
				+ "the cipher. Click Proceed and see the magic!" };
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
