package edu.kit.iks.Cryptographics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * An instance of this class represents the view of the welcome screen 
 * 
 * @author Christian Dreher
 */
public class WelcomeView extends JPanel {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -8871817760284013217L;

	public WelcomeView() {
		this.add(new JLabel("Welcome"));
	}
}
