package edu.kit.iks.Cryptographics.Vigenere.State;

import javax.swing.JPanel;

import edu.kit.iks.Cryptographics.DiffieHellman.State.DHStateController;

public abstract class VStateController {
	protected JPanel view = null;

	public JPanel getView() {
		return view;
	}
	
	public VStateController nextState() {
		return null;
	}
	
	public VStateController previousState() {
		return null;
	}
}
