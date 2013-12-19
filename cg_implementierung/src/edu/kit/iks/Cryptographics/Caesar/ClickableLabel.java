package edu.kit.iks.Cryptographics.Caesar;

import java.awt.event.MouseListener;

import javax.swing.JLabel;

/**
 * Needed to avoid redundant code with arrays of JLabels, that are going to
 * implement ActionHandler.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class ClickableLabel extends JLabel {

	/**
	 * @param m
	 */
	public void addClickListener(MouseListener m) {
		this.addMouseListener(m);
	}

}
