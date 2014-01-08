package edu.kit.iks.Cryptographics.Caesar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

/**
 * @author Wasilij Beskorovajnov.
 * 
 */
abstract public class AbstractController extends AbstractVisualizationController {
	/**
	 * Contains all elements of the gui for the demonstration of caesar's
	 * problem.
	 */
	protected CaesarCipherView view;

	/**
	 * @param visualizationInfo
	 */
	public AbstractController(CaesarVisualizationInfo visualizationInfo) {
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
