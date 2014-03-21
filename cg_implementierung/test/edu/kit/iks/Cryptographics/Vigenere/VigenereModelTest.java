package edu.kit.iks.Cryptographics.Vigenere;

import org.junit.Test;

import edu.kit.iks.Cryptographics.Vigenere.VigenereModel;
import junit.framework.TestCase;

public class VigenereModelTest extends TestCase {
	@Test
	public void testEnc() {
		char test = VigenereModel.enc(1, 'B');
		assertEquals('C',test);
	}
	
	@Test
	public void testDec() {
		char test = VigenereModel.dec('B', 'A');
		assertEquals('Y',test);
	}
	
	@Test
	public void testCharacterToInt() {
		for (int i = 0; i < 26; i++) {
			char c = (char)('A' + i);
			String str = "" + c;
			int result = VigenereModel.characterToInt(str);
			assertEquals(i + 1, result);
		}
	}

	@Test
	public void testInvalidCharacterToInt() {
		int result = VigenereModel.characterToInt("AY");
		assertEquals(0, result);
		
		result = VigenereModel.characterToInt("$");
		assertEquals(0, result);
		
		result = VigenereModel.characterToInt("}");
		assertEquals(0, result);
	}
	
	@Test
	public void testGetCharPositionated() {
		String temp = VigenereModel.getCharPositionated(0, 2, "HAALLLLOO");
		assertEquals("HALLO", temp);
	}

}
