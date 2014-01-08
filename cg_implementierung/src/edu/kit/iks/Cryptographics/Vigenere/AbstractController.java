package edu.kit.iks.Cryptographics.Vigenere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

abstract public class AbstractController extends
		AbstractVisualizationController {

	/**
	 * @param visualizationInfo
	 */
	public AbstractController(VigenereVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadView() {
	}
}
