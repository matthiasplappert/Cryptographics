package edu.kit.iks.CryptographicsLib;

import javax.swing.JButton;

/**
 * 
 * @author Matthias Jaenicke
 * 
 * The single keys for UIKeyboard.
 */
public class KeyboardButton extends JButton{

	private char keyValue;
	
	public KeyboardButton(char keyValue) {
		super();
		
		setKeyValue(keyValue);
	}

	public char getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(char keyValue) {
		this.keyValue = keyValue;
	}
}
