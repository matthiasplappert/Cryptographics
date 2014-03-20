package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Navigation extends JPanel {

	JButton back, forward;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8585689448627282057L;
	
	public Navigation(String forward) {
		this.forward = new JButton(forward);
		this.setLayout(new BorderLayout());
		this.add(this.forward, BorderLayout.EAST);
	}
	
	public Navigation(String back, String forward) {
		this.forward = new JButton(forward);
		this.back = new JButton(back);
		this.setLayout(new BorderLayout());
		this.add(this.back, BorderLayout.WEST);
		this.add(this.forward, BorderLayout.EAST);
	}
	
	public JButton getBack() {
		return this.back;
	}
	
	public JButton getForward() {
		return this.forward;
	}

}
