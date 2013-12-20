package edu.kit.iks.Cryptographics.Caesar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class AbstractView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Buttons.
	 */
	protected JButton nextBtn;
	protected JButton backBtn;

	/**
	 *  Explanation textfield.
	 */
	protected JLabel explanations;
	
	/**
	 * Textfield for user input. 
	 * Used in experiment.
	 */
	protected JTextField input;
	
}