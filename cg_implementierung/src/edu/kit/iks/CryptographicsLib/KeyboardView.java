package edu.kit.iks.CryptographicsLib;

import javax.swing.JPanel;

/**
 * @author Matthias Jaenicke.
 * 
 * A displayable keyboard for character input per mouse click or touchscreen.
 * Contains only the basic 26 capital characters.
 * Consists of UIKeyboardKey instances.
 */
public class KeyboardView extends JPanel{

	private static KeyboardButton[] keysFirstRow;
	private static KeyboardButton[] keysSecondRow;
	private static KeyboardButton[] keysThirdRow;
	
	public KeyboardView() {
		super();
		
		char[] charactersFirstRow = {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'P'};
		char[] charactersSecondRow = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
		char[] charactersThirdRow = {'Y', 'X', 'C', 'V', 'B', 'N', 'M'};
		keysFirstRow = new KeyboardButton[charactersFirstRow.length];
		keysSecondRow = new KeyboardButton[charactersSecondRow.length];
		keysThirdRow = new KeyboardButton[charactersThirdRow.length];
		
		for (int i = 0; i < charactersFirstRow.length; i++) {
			keysFirstRow[i] = new KeyboardButton(charactersFirstRow[i]);
		}
		for (int i = 0; i < charactersSecondRow.length; i++) {
			keysSecondRow[i] = new KeyboardButton(charactersSecondRow[i]);
		}
		for (int i = 0; i < charactersThirdRow.length; i++) {
			keysThirdRow[i] = new KeyboardButton(charactersThirdRow[i]);
		}
		
	}
}
