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

	public static CryptoModel getInstance() {
		return CryptoModel.model;
	}

	// ASCII lower case a code.
	public final int ASCII_LC_A = 'a';

	// ASCII upper case A code.
	public final int ASCII_UC_A = 'A';

	// The Header of a html string.
	private final String HTML_HEADER = "<html><body>";

	// number of chars in <html><body>.
	private final int HTML_HEADER_LENGTH = 12;

	// The reach of the key interval.
	private final int MODULO = 26;

	/**
	 * Constructor.
	 */
	private CryptoModel() {

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
	 * @param key
	 * @param cipher
	 * @return
	 */
	public String dec(int key, String cipher) {
		return this.enc(-key, cipher);
	}

	/**
	 * @param key
	 * @param cipher
	 * @return
	 */
	public String[] dec(int key, String[] cipher) {
		return this.enc(-key, cipher);
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
					int offset = c - this.ASCII_UC_A;

					cipher += String
							.valueOf((char) ((((offset + this.MODULO) + key) % this.MODULO) + this.ASCII_UC_A));
				} else {
					int offset = c - this.ASCII_LC_A;

					cipher += String
							.valueOf((char) ((((offset + this.MODULO) + key) % this.MODULO) + this.ASCII_LC_A));
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
						int offset = c - this.ASCII_UC_A;

						cipher[i] += String
								.valueOf((char) ((((offset + this.MODULO) + key) % this.MODULO) + this.ASCII_UC_A));
					} else {
						int offset = c - this.ASCII_LC_A;

						cipher[i] += String
								.valueOf((char) ((((offset + this.MODULO) + key) % this.MODULO) + this.ASCII_LC_A));
					}

				} else {
					cipher[i] += c;
				}

			}
		}
		return cipher;

	}

	public int generateKey() {
		return this.generateRandomInt(1, 26);
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private int generateRandomInt(int a, int b) {
		return (int) (a + ((b - a) * Math.random()));
	}

	public String genRandomBlamings() {
		String[] blamingPool = { "Oh no. What a pity! It went wrong!",
				"No my friend. This one doesn't work!",
				"Ok, dont be frustrated. Though your action was totally wrong." };
		int index = this.generateRandomInt(0, blamingPool.length);
		return blamingPool[index];
	}

	/**
	 * @param key
	 * @return
	 */
	public String genRandomCipher(int key) {
		String plain = this.genRandomPlainSequence();
		return this.enc(key, plain);
	}

	public String genRandomGrats() {
		String[] gratulationsPool = { "Great work oh mighty Caesar.",
				"Very nice. I Like!", "Kryptochef approves!",
				"Noone could do it better!" };
		int index = this.generateRandomInt(0, gratulationsPool.length);
		return gratulationsPool[index];
	}

	/**
	 * @return
	 */
	public String genRandomPlainSequence() {
		String[] plainTextPool = { "ANNA", "HANNAH", "BANANA", "KOKOS",
				"KRYPTOCHEF", "HAMSTER", "WASILIJ", "SECRET", "EPSILON" };

		int index = this.generateRandomInt(0, plainTextPool.length);
		return plainTextPool[index];
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
	 * @param stringToFormat
	 * @return
	 */
	public String insertHtmlBreaks(String[] textLines) {
		String formattedString = this.HTML_HEADER;
		for (String textline : textLines) {
			formattedString += textline + "<br>";
		}
		return formattedString;
	}

	/**
	 * @param input
	 */
	public boolean isInputValid(String input) {
		return (input.length() < 10 && input.length() > 0);
	}

	/**
	 * @param key
	 * @return
	 */
	public boolean isKeyValid(int key) {
		return (key > 0 && key <= this.MODULO);
	}

	/**
	 * @param stringToClear
	 * @return
	 */
	public String[] removeHtmlBreaks(String stringToClear) {
		return stringToClear.substring(this.HTML_HEADER_LENGTH).split("<br>");
	}
}
