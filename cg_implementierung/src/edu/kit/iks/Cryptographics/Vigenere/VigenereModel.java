package edu.kit.iks.Cryptographics.Vigenere;

public class VigenereModel {
	private final static int ASCII_A = ((int)'A' - 1);
	private final static int MODULO = 26;
	
	static public char enc(int key, char text) {
		int offsetText = ((int) text) - ASCII_A; 
		
		return ((char) ((((offsetText + MODULO) + key) % MODULO) + ASCII_A));

	}

	static public char dec(char key, char cipher) {
		return enc(-((int)key - ASCII_A), cipher);
	}
	
	static public int characterToInt(String character) {
		if (character.length() == 1) {
			return (int)character.charAt(0) - 64;
		} else {
			return 0;
		}
	}
}
