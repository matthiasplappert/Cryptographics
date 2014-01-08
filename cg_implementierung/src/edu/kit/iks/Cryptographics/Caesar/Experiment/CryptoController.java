package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.kit.iks.Cryptographics.Caesar.GeneralCryptoController;
import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;

/**
 * Controller for the first and second step of the experiment phase. When user has to
 * put input and encrypt it and in the second step to decrypt a given cipher. Controls the needed elements from CaesarUpperView,
 * !!see CGeneralView for more details!!.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CryptoController extends GeneralCryptoController {

	/** Constructor.
	 * @param visualizationInfo
	 */
	public CryptoController(CaesarVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		this.view.getInput().addActionListener(new ActionListener() {

			/*
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

}
