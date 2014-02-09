package edu.kit.iks.CryptographicsLib;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Matthias Jaenicke.
 * 
 *         A displayable keyboard for character input per mouse click or touchscreen. Contains only
 *         the basic 26 capital characters. Consists of UIKeyboardKey instances.
 */
public class KeyboardView extends JPanel implements ActionListener {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 7141126652784811369L;
	
	private JPanel firstRow;
	private JPanel secondRow;
	private JPanel thirdRow;

	private JTextField textField;

	private static JButton[] keysFirstRow;
	private static JButton[] keysSecondRow;
	private static JButton[] keysThirdRow;

	public KeyboardView(JTextField textField) {
		super();

		this.textField = textField;

		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);

		FlowLayout layoutRows = new FlowLayout();
		JPanel firstRow = new JPanel();
		firstRow.setLayout(layoutRows);
		JPanel secondRow = new JPanel();
		secondRow.setLayout(layoutRows);
		JPanel thirdRow = new JPanel();
		thirdRow.setLayout(layoutRows);

		String[] charactersFirstRow = { "Q", "W", "E", "R", "T", "Z", "U", "I",
				"O", "P", "Back" };
		String[] charactersSecondRow = { "A", "S", "D", "F", "G", "H", "J",
				"K", "L", "Enter" };
		String[] charactersThirdRow = { "Y", "X", "C", "V", "B", "N", "M" };

		keysFirstRow = new JButton[charactersFirstRow.length];
		keysSecondRow = new JButton[charactersSecondRow.length];
		keysThirdRow = new JButton[charactersThirdRow.length];

		// Dimension keySize = new Dimension(35, 25);
		Insets keyMargin = new Insets(0, 5, 0, 5);
		Font keyFont = new Font("Arial", Font.PLAIN, 14);

		for (int i = 0; i < charactersFirstRow.length; i++) {
			keysFirstRow[i] = new JButton(charactersFirstRow[i]);
			// keysFirstRow[i].setPreferredSize(keySize);
			keysFirstRow[i].setMargin(keyMargin);
			keysFirstRow[i].setFont(keyFont);
			keysFirstRow[i].addActionListener(this);
			firstRow.add(keysFirstRow[i]);

		}
		this.add(firstRow);

		for (int i = 0; i < charactersSecondRow.length; i++) {
			keysSecondRow[i] = new JButton(charactersSecondRow[i]);
			// keysSecondRow[i].setPreferredSize(keySize);
			keysSecondRow[i].setMargin(keyMargin);
			keysSecondRow[i].setFont(keyFont);
			keysSecondRow[i].addActionListener(this);
			secondRow.add(keysSecondRow[i]);
		}
		this.add(secondRow);

		for (int i = 0; i < charactersThirdRow.length; i++) {
			keysThirdRow[i] = new JButton(charactersThirdRow[i]);
			// keysThirdRow[i].setPreferredSize(keySize);
			keysThirdRow[i].setMargin(keyMargin);
			keysThirdRow[i].setFont(keyFont);
			keysThirdRow[i].addActionListener(this);
			thirdRow.add(keysThirdRow[i]);
		}
		this.add(thirdRow);

		this.setSize(firstRow.getWidth(), firstRow.getHeight() * 3);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < (keysFirstRow.length - 1); i++) {
			if (e.getSource().equals(keysFirstRow[i])) {
				textField.setText(textField.getText()
						+ keysFirstRow[i].getText());
				textField.requestFocus();
			}
		}

		for (int i = 0; i < (keysSecondRow.length - 1); i++) {
			if (e.getSource().equals(keysSecondRow[i])) {
				textField.setText(textField.getText()
						+ keysSecondRow[i].getText());
				textField.requestFocus();
			}
		}

		for (int i = 0; i < keysThirdRow.length; i++) {
			if (e.getSource().equals(keysThirdRow[i])) {
				textField.setText(textField.getText()
						+ keysThirdRow[i].getText());
				textField.requestFocus();
			}
		}
		// Listener for the Buttons Enter and Back.
		if (e.getSource().equals(keysSecondRow[keysSecondRow.length - 1])) {
			textField.getActionListeners()[0].actionPerformed(e);
			textField.requestFocus();
		} else if (e.getSource().equals(keysFirstRow[keysFirstRow.length - 1])) {
			char[] newContent = new char[textField.getText().length()];
			textField.getText().getChars(0, textField.getText().length() - 1,
					newContent, 0);
			if (newContent.length < 1) {
				textField.setText(String.copyValueOf(newContent));
				textField.requestFocus();
			} else {
				textField.setText("");
				textField.requestFocus();
			}
		}
	}
}
