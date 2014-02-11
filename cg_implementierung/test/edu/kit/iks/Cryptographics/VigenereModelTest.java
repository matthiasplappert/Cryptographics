package edu.kit.iks.Cryptographics;

import edu.kit.iks.Cryptographics.Vigenere.VigenereModel;
import junit.framework.TestCase;

public class VigenereModelTest extends TestCase {

	public void testEnc() {
		char test = VigenereModel.enc(1, 'B');
		assertEquals('C',test);
	}

	public void testDec() {
		char test = VigenereModel.dec('B', 'A');
		assertEquals('Y',test);
	}

	public void testCharacterToInt() {
		int temp = VigenereModel.characterToInt("AY");
		assertEquals(0, temp);
	}

	public void testGetCharPositionated() {
		String temp = VigenereModel.getCharPositionated(0, 2, "HAALLLLOO");
		assertEquals("HALLO", temp);
	}

}
