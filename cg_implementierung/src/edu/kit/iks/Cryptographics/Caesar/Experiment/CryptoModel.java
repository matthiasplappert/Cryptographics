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

	public static CryptoModel getInstance() {
		return CryptoModel.model;
	}

	/**
	 * Constructor.
	 */
	private CryptoModel() {

	}

	/**
	 * @param key
	 * @param cipher
	 * @return
	 */
	public String dec(int key, String cipher) {
		return this.enc(-key, cipher);
	}

	private char shift(int key, char charToShift) {
		int offset = charToShift - this.ASCII_UC_A;
		if (Character.isLowerCase(charToShift)) {
			offset = charToShift - this.ASCII_LC_A;
			return (char) ((((offset + this.MODULO) + key) % this.MODULO) + this.ASCII_LC_A);
		}
		return (char) ((((offset + this.MODULO) + key) % this.MODULO) + this.ASCII_UC_A);
	}

	/**
	 * Function for decrypting and encrypting of all sort of String.<br>
	 * CAREFUL:  If you want to encrypt html Strings, make sure all tags are closed!!!!<br>
	 * 
	 * @param key
	 * @param text
	 * @return
	 */
	public String enc(int key, String text) {
		//TODO: Check if the String has valid HTML!
		String cipher = "";
		for (int i = 0; i < text.length(); i++) {
			Character c = text.charAt(i);

			if (Character.isLetter(c)) {

				cipher += String.valueOf(shift(key, c));

			} else {
				if (c != '<') {
					cipher += c;
				} else {
					cipher += c;
					while (c != '>') {
						i++;
						c = text.charAt(i);
						cipher += c;
					}
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

}
