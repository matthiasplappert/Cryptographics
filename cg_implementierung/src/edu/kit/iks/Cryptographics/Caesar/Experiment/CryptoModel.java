package edu.kit.iks.Cryptographics.Caesar.Experiment;

/**
 * Model of the visualization of Caesar's cipher.
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

	//The reach of the key interval.
	private final int MODULO = 26;

	// number of chars in <html><body>.
	private final int HTML_HEADER_LENGTH = 12;

	//The Header of a html string.
	private final String HTML_HEADER = "<html><body>";

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
	 * @param textLines
	 * @return
	 */
	public String arrayToString(String[] textLines) {
		String textString = "";
		for (String textline : textLines) {
			textString += textline;
		}
		return textString;
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
		return (key > 0 && key <= MODULO);
	}

	/**
	 * @param input
	 */
	public boolean isInputValid(String input) {
		return (input.length() < 10 && input.length() > 0);
	}

	public String genRandomGrats() {
		String[] gratulationsPool = { "Great work oh mighty Caesar.",
				"Very nice. I Like!", "Kryptochef approves!",
				"Noone could do it better!" };
		int index = generateRandomInt(0, gratulationsPool.length);
		return gratulationsPool[index];
	}

	public String genRandomBlamings() {
		String[] blamingPool = {
				"Oh no. What a pity! It went wrong!",
				"No my friend. This one doesn't work!",
				"Ok, dont be frustrated. Though your action was totally wrong."
		};
		int index = generateRandomInt(0, blamingPool.length);
		return blamingPool[index];
	}
	/**
	 * @return
	 */
	public String genRandomPlainSequence() {
		String[] plainTextPool = { "ANNA", "HANNAH", "BANANA", "KOKOS",
				"KRYPTOCHEF", "HAMSTER", "WASILIJ", "SECRET", "EPSILON" };

		int index = generateRandomInt(0, plainTextPool.length);
		return plainTextPool[index];
	}

	/**
	 * @param key
	 * @return
	 */
	public String genRandomCipher(int key) {
		String plain = genRandomPlainSequence();
		return enc(key, plain);
	}

	// TODO: Not so much random at the moment.
	/**
	 * @return
	 */
	public String genRandomText() {
		String[] textPool = { "<html><body>"
				+ "The diagram you see here shows the frequency of each letter<br>"
				+ "in the text you are reading at the moment. It is called a<br>"
				+ "Histogram. If you would count all E's in this explanation<br>"
				+ "you would get the number you see in the diagram on the column<br>"
				+ "above the letter E. Now the program will encrypt this explanation<br>"
				+ "with an unknown key in a most awesome way and we will see the <br>"
				+ "histogram of the cipher. Click Proceed and see the magic!" };
		return textPool[0];
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
