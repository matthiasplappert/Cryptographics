/**
 * 
 */
package edu.kit.iks.Cryptographics.Caesar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

/**
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CAbstractState extends AbstractVisualizationController {
	/**
	 * Contains all relevant informations about the cipher Caesar.
	 */
	protected VisualizationInfo visualizationInfo;

	/**
	 * Contains all elements of the gui for the demonstration of caesar's
	 * problem.
	 */
	protected CaesarUpperView view;

	/**
	 * @param visualizationInfo
	 */
	public CAbstractState(VisualizationInfo visualizationInfo) {
		super();
		this.visualizationInfo = visualizationInfo;
		this.view = new CaesarUpperView();
		this.view.getBackBtn().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				// step back
			}
		});
		this.view.getNextBtn().addActionListener(new ActionListener() {
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
