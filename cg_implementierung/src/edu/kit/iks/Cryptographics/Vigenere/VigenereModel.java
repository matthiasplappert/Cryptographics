package edu.kit.iks.Cryptographics.Vigenere;

public class VigenereModel {
	
	static public char XOR(char a, char b) {
		return b;
	}
	
	static public int characterToInt(String character) {
		if (character.length() == 1) {
			return (int)character.charAt(0) - 65;
		} else {
			return 0;
		}
	}
}
