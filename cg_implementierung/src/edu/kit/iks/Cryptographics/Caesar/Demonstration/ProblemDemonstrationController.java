package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.Caesar.CaesarVisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

/**
 * @author Wasilij Beskorovajnov.
 * 
 */
public class ProblemDemonstrationController extends
		AbstractVisualizationController {
	/**
	 * Contains all relevant informations about the cipher Caesar.
	 */
	private CaesarVisualizationInfo visualizationInfo;

	/**
	 * Contains all elements of the gui for the demonstration of caesar's
	 * problem.
	 */
	private CaesarProblemDemoView view;

	/**
	 * @param visualizationInfo
	 */
	public ProblemDemonstrationController(
			CaesarVisualizationInfo visualizationInfo) {
		super();
		this.visualizationInfo = visualizationInfo;
		this.view = new CaesarProblemDemoView();
		this.view.addBackBtnListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				// step back
			}
		});
		this.view.addNextBtnListener(new ActionListener() {
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