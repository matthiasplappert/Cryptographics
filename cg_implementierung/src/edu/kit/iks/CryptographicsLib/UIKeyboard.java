package edu.kit.iks.CryptographicsLib;

import javax.swing.JPanel;

/**
 * @author Matthias Jaenicke.
 * 
 */
public class UIKeyboard extends JPanel{

	private static UIKeyboardKey[] keysFirstRow;
	private static UIKeyboardKey[] keysSecondRow;
	private static UIKeyboardKey[] keysThirdRow;
	
	public UIKeyboard() {
		super();
		
		char[] charactersFirstRow = {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'P'};
		char[] charactersSecondRow = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
		char[] charactersThirdRow = {'Y', 'X', 'C', 'V', 'B', 'N', 'M'};
		keysFirstRow = new UIKeyboardKey[charactersFirstRow.length];
		keysSecondRow = new UIKeyboardKey[charactersSecondRow.length];
		keysThirdRow = new UIKeyboardKey[charactersThirdRow.length];
		
		for (int i = 0; i < charactersFirstRow.length; i++) {
			keysFirstRow[i] = new UIKeyboardKey(charactersFirstRow[i]);
		}
		for (int i = 0; i < charactersSecondRow.length; i++) {
			keysSecondRow[i] = new UIKeyboardKey(charactersSecondRow[i]);
		}
		for (int i = 0; i < charactersThirdRow.length; i++) {
			keysThirdRow[i] = new UIKeyboardKey(charactersThirdRow[i]);
		}
		
	}
}
