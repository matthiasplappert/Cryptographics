/**
 * 
 */
package edu.kit.iks.Cryptographics.Caesar.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.Caesar.VisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

/**
 * Controller for the last step of the experiment phase. User can try to break
 * the caesar cipher. CFifthView is being controlled here.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CFifthState extends AbstractVisualizationController {

	/**
	 * Contains all relevant informations about the cipher Caesar.
	 */
	private VisualizationInfo visualizationInfo;

	/**
	 * Contains all elements of the gui for the demonstration of caesar's
	 * disadvantages.
	 */
	private CFifthView view;

	/**
	 * Constructor
	 * 
	 * @param visualizationInfo
	 */
	public CFifthState(VisualizationInfo visualizationInfo) {
		this.visualizationInfo = visualizationInfo;
		this.view = new CFifthView();
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
		this.view.getIncrement().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				// step back
			}
		});
		this.view.getDecrement().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				// step back
			}
		});
	}

}
