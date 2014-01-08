package edu.kit.iks.Cryptographics.Vigenere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.Caesar.CaesarCipherView;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

abstract public class AbstractController extends AbstractVisualizationController {
	protected CaesarCipherView view;

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
		this.view = new CaesarCipherView();
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
