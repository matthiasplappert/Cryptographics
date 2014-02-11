package edu.kit.iks.Cryptographics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.kit.iks.Cryptographics.Caesar.Experiment.CryptoModel;

/**
 * JUnit testcase class for testing the functionality of the model in the visualization of Caesar.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoModelTest {
	// Model to test.
	private CryptoModel modelTT;

	private final String MESSAGE_HEADER = "[JUnit] Testing the functionality of ";

	@Before
	public void setUp() throws Exception {
		this.modelTT = CryptoModel.getInstance();
	}


	@Test
	public void testArrayToString() {
		String[] testStringArr = { "Test1 ", "2 ", "3 ", "4 ", "HIGH ", "FIVE" };
		String expected = "Test1 2 3 4 HIGH FIVE";
		String actual = this.modelTT.arrayToString(testStringArr);
		assertEquals(MESSAGE_HEADER + "arrayToString()\n", expected, actual);
	}

	@Test
	public void testEncIntString() {
		String alphabet = "!!!ABcdEFghIJKlmNOPqrSTUvwXYZ!!!";
		String expected = "!!!KLmnOPqrSTUvwXYZabCDEfgHIJ!!!";
		String actual = this.modelTT.enc(10, alphabet);
		assertEquals(MESSAGE_HEADER + "enc(String)\n", expected, actual);
	}

	@Test
	public void testEncIntStringArray() {
		String alphabet = "<html>ABCD<br>efgh<br>IJKL<br>mnop<br>QRST<br>uvwxyz<br>.;!:_-";
		String expected = "<html>NOPQ<br>rstu<br>VWXY<br>zabc<br>DEFG<br>hijklm<br>.;!:_-";
		String actual = this.modelTT.enc(13, alphabet);
		assertEquals(MESSAGE_HEADER + "enc(StringArray)\n", expected,
				actual);
	}

	@Test
	public void testDecIntString() {
		String cipher = "!!!KLmnOPqrSTUvwXYZabCDEfgHIJ!!!";
		String expected = "!!!ABcdEFghIJKlmNOPqrSTUvwXYZ!!!";
		String actual = this.modelTT.dec(10, cipher);
		assertEquals(MESSAGE_HEADER + "dec(String)\n", expected, actual);
	}

//	@Test
//	public void testDecIntStringArray() {
//		String[] cipher = { "NOPQ", "rstu", "VWXY", "zabc", "DEFG", "hijklm",
//				".;!:_-" };
//		String[] expected = { "ABCD", "efgh", "IJKL", "mnop", "QRST", "uvwxyz",
//				".;!:_-" };
//		String[] actual = this.modelTT.dec(13, cipher);
//		assertArrayEquals(MESSAGE_HEADER + "dec(StringArray)\n", expected,
//				actual);
//	}

	@Test
	public void testIsKeyValid() {
		int[] validKeys = { 1, 13, 26 };
		int[] invalidKeys = {0, -25, 27 };

		for (int validKey : validKeys) {
			assertTrue(MESSAGE_HEADER + "isKeyValid()\n",
					this.modelTT.isKeyValid(validKey));
		}

		for (int invalidKey : invalidKeys) {
			assertFalse(MESSAGE_HEADER + "isKeyValid()\n",
					this.modelTT.isKeyValid(invalidKey));
		}
	}

	@Test
	public void testIsInputValid() {
		String[] validInputArr = {"A", "ABCD", "ABCDFHGRT"};
		String[] invalidInputArr = {"", "ABCDHFGRTZ", "ABDGFHRTEZSHD"};
		for (String validInput : validInputArr) {
			assertTrue(MESSAGE_HEADER + "isInputValid()\n", this.modelTT.isInputValid(validInput));
		}
		for (String invalidInput : invalidInputArr) {
			assertFalse(MESSAGE_HEADER + "isInputValid()\n", this.modelTT.isInputValid(invalidInput));
		}
	}

	@Test
	public void testGenRandomGrats() {
		assertNotNull(this.modelTT.genRandomGrats());		
	}

	@Test
	public void testGenRandomBlamings() {
		assertNotNull(this.modelTT.genRandomBlamings());		
	}

	@Test
	public void testGenRandomPlainSequence() {
		assertNotNull(this.modelTT.genRandomPlainSequence());		
	}

	@Test
	public void testGenRandomCipher() {
		assertNotNull(this.modelTT.genRandomCipher(10));		
	}

	@Test
	public void testGenRandomText() {
		assertNotNull(this.modelTT.genRandomText());		
	}

	@Test
	public void testGenerateKey() {
		int key = 0;
		for (int i = 0; i < 99; i++) {
			key = this.modelTT.generateKey();
			if (key > 0 && key < 27) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
	}

}
