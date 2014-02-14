package edu.kit.iks.Cryptographics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.xnap.commons.i18n.I18n;

import edu.kit.iks.CryptographicsLib.Configuration;

/**
 * An instance of this class represents the view of the welcome screen 
 * 
 * @author Christian Dreher
 */
public class WelcomeView extends JPanel {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -8871817760284013217L;

	/**
	 * Localization instance
	 */
	private static I18n i18n = Configuration.getInstance().getI18n(WelcomeView.class);
	
	public WelcomeView() {
		this.add(new JLabel(i18n.tr("Welcome")));
	}
}
