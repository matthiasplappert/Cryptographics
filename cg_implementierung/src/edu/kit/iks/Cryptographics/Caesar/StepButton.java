package edu.kit.iks.Cryptographics.Caesar;

import java.awt.event.ActionListener;

import javax.swing.JButton;

/**Possible Solution:
 * Needed for avoiding redudancy when implementing Buttons that perform step
 * action.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class StepButton extends JButton {

	/**
	 * @param l
	 */
	public void addStepListener(ActionListener l) {
		this.addActionListener(l);
	}
}
