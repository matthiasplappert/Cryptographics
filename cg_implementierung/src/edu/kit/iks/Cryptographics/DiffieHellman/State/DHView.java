package edu.kit.iks.Cryptographics.DiffieHellman.State;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class DHView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	void addNextStateListener(ActionListener nextStateListener) {
		return;
	}
	
	void addPrevStateListener(ActionListener prevStateListener) {
		return;
	}
}
