package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.util.regex.Pattern;

/**
 * Model of the last step of Caesar Introduction phase and the first two steps of the experiment.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoModel {

	// makes sure only one instance is being generated.
	private static final CryptoModel model = new CryptoModel();

	// ASCII upper case A code.
	public final int ASCII_UC_A = 'A';

	// ASCII lower case a code.
	public final int ASCII_LC_A = 'a';

	private final int MODULO = 26;

	// The format for a formatted String.
	private final int MAX_LINE_LENGTH = 60;

	// The line length of a formatted String must be 35 < lineLength < 45.
	private final int MAX_LINE_VARIATION = 5;

	// number of chars in <html><body>.
	private final int HTML_HEADER_LENGTH = 12;

	private final String HTML_HEADER = "<html><body>";

	// number of chars in <br>.
	private final int LINEBREAK_LENGTH = 4;

	/**
	 * Constructor.
	 */
	private CryptoModel() {

	}

	public static CryptoModel getInstance() {
		return model;
	}

	/**
	 * @param stringToFormat
	 * @return
	 */
	public String insertHtmlBreaks(String[] textLines) {
		String formattedString = HTML_HEADER;
		for (String textline : textLines) {
			formattedString += textline + "<br>";
		}
		return formattedString;
	}

	/**
	 * @param stringToClear
	 * @return
	 */
	public String[] removeHtmlBreaks(String stringToClear) {
		return stringToClear.substring(HTML_HEADER_LENGTH).split("<br>");
	}

	/**
	 * Function for decrypting and encrypting of small strings.
	 * 
	 * @param key
	 * @param text
	 * @return
	 */
	public String enc(int key, String text) {

		String cipher = "";
		for (int i = 0; i < text.length(); i++) {
			Character c = text.charAt(i);

			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					int offset = c - ASCII_UC_A;

					cipher += String
							.valueOf((char) ((((offset + MODULO) + key) % MODULO) + ASCII_UC_A));
				} else {
					int offset = c - ASCII_LC_A;

					cipher += String
							.valueOf((char) ((((offset + MODULO) + key) % MODULO) + ASCII_LC_A));
				}

			} else {
				cipher += c;
			}

		}
		return cipher;

	}

	/**
	 * Function for encrypting bigger texts.
	 * 
	 * @param key
	 * @param plainTextLines
	 * @return
	 */
	public String[] enc(int key, String[] plainTextLines) {

		String[] cipher = new String[plainTextLines.length];

		for (int i = 0; i < plainTextLines.length; i++) {
			cipher[i] = "";
			for (int j = 0; j < plainTextLines[i].length(); j++) {
				Character c = plainTextLines[i].charAt(j);

				if (Character.isLetter(c)) {
					if (Character.isUpperCase(c)) {
						int offset = c - ASCII_UC_A;

						cipher[i] += String
								.valueOf((char) ((((offset + MODULO) + key) % MODULO) + ASCII_UC_A));
					} else {
						int offset = c - ASCII_LC_A;

						cipher[i] += String
								.valueOf((char) ((((offset + MODULO) + key) % MODULO) + ASCII_LC_A));
					}

				} else {
					cipher[i] += c;
				}

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
	 * @param cipher
	 * @return
	 */
	public String[] dec(int key, String[] cipher) {
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
