package edu.kit.iks.CryptographicsLib;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Matthias Jaenicke.
 * 
 * A displayable keyboard for character input per mouse click or touchscreen.
 * Contains only the basic 26 capital characters.
 * Consists of UIKeyboardKey instances.
 */
public class KeyboardView extends JPanel implements ActionListener{

	private JPanel firstRow;
	private JPanel secondRow;
	private JPanel thirdRow;
	
	private static JButton[] keysFirstRow;
	private static JButton[] keysSecondRow;
	private static JButton[] keysThirdRow;
	
	public KeyboardView() {
		super();
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		
		FlowLayout layoutRows = new FlowLayout();
		JPanel firstRow = new JPanel();
		firstRow.setLayout(layoutRows);
		JPanel secondRow = new JPanel();
		secondRow.setLayout(layoutRows);
		JPanel thirdRow = new JPanel();
		thirdRow.setLayout(layoutRows);
		
		String[] charactersFirstRow = {"Q", "W", "E", "R", "T", "Z", "U", "I", "O", "P", "Back"};
		String[] charactersSecondRow = {"A", "S", "D", "F", "G", "H", "J", "K", "L", "Enter"};
		String[] charactersThirdRow = {"Y", "X", "C", "V", "B", "N", "M"};
//		Dimension keySize = new Dimension(47, 25);
		keysFirstRow = new JButton[charactersFirstRow.length];
		keysSecondRow = new JButton[charactersSecondRow.length];
		keysThirdRow = new JButton[charactersThirdRow.length];
		
		for (int i = 0; i < charactersFirstRow.length; i++) {
			keysFirstRow[i] = new JButton(charactersFirstRow[i]);
//			keysFirstRow[i].setPreferredSize(keySize);
			keysFirstRow[i].addActionListener(this);
			firstRow.add(keysFirstRow[i]);
			
		}
		this.add(firstRow);
		
		for (int i = 0; i < charactersSecondRow.length; i++) {
			keysSecondRow[i] = new JButton(charactersSecondRow[i]);
//			keysSecondRow[i].setPreferredSize(keySize);
			keysSecondRow[i].addActionListener(this);
			secondRow.add(keysSecondRow[i]);
		}
		this.add(secondRow);
		
		for (int i = 0; i < charactersThirdRow.length; i++) {
			keysThirdRow[i] = new JButton(charactersThirdRow[i]);
//			keysThirdRow[i].setPreferredSize(keySize);
			keysThirdRow[i].addActionListener(this);
			thirdRow.add(keysThirdRow[i]);
		}
		this.add(thirdRow);
		
		this.setSize(firstRow.getWidth(), firstRow.getHeight() * 3);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
