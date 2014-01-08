package edu.kit.iks.Cryptographics.Caesar.Demonstration;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.Caesar.GeneralCryptoController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;

/**
 * Controller for the last step of demonstration phase. Controls the needed
 * elements from CaesarUpperView, !!see CaesarUpperView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CipherDemoController extends GeneralCryptoController {

	/**
	 * @param visualizationInfo
	 */
	public CipherDemoController(CaesarVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	    this.view.getBackButton().addActionListener(new ActionListener() {
				/*
				 * @see java.awt.event.ActionListener#actionPerformed(java.awt
				 * .event.ActionEvent)
				 */
				public void actionPerformed(ActionEvent event) {
					// step back
				}
			});
			this.view.getNextButton().addActionListener(new ActionListener() {
				/*
				 * @see java.awt.event.ActionListener#actionPerformed(java.awt
				 * .event.ActionEvent)
				 */
				public void actionPerformed(ActionEvent event) {
					// step forward.
				}
			});
	}
}
