package edu.kit.iks.Cryptographics.Vigenere;
/**
 * @author Aydin Tekin
 * This class represents the model of vigenere; it has the methods for calculating all needed functionality in vigenere.
 */
public class VigenereModel {
	
	/**
	 * Position of 'A' in the ASCII system
	 */
	private final static int ASCII_A = ((int)'A' - 1);
	
	/**
	 * Number of characters in the alphabet
	 */
	private final static int MODULO = 26;
	
	/**
	 * rotates a specific character with the number 'key'
	 * @param key amount how often the character should be rotated with
	 * @param text character to be rotated
	 * @return result of the rotation
	 */
	static public char enc(int key, char text) {
		int offsetText = ((int) text) - ASCII_A; 
		
		return ((char) ((((offsetText + MODULO) + key) % MODULO) + ASCII_A));

	}
	
	/**
	 * does the same like enc with negative rotation
	 * @param key amount how often the character should be rotated with
	 * @param cipher character to be rotated
	 * @return result of the inverted rotation
	 */
	static public char dec(char key, char cipher) {
		return enc(-((int)key - ASCII_A), cipher);
	}
	
	/**
	 * converts ASCII number of uppercase characters to alphabetical number
	 * @param character character to be converted
	 * @return alphabetical number of character
	 */
	static public int characterToInt(String character) {
		if (character.length() == 1) {
			return (int)character.charAt(0) - ASCII_A;
		} else {
			return 0;
		}
	}
	
	/**
	 * used by the kasiski test, this method returns every n-th character of a string.
	 * @param start which position to start with
	 * @param num value of steps
	 * @param input string used for the test
	 * @return every n-th character of the input
	 */
	static public String getCharPositionated(int start, int num, String input) {
		String returnString = "";
		int x = 0;
		for (int i = start; i < input.length(); i++) {
			char c = input.charAt(i);
			int index = (int)c - ASCII_A;
			if (index >= 0 && index <= MODULO) {
				if (x > 0) {
					x = 0;
					continue;
				}
				returnString = returnString + input.charAt(i);
				x++;
			} 
		}
		return returnString;
	}
}
