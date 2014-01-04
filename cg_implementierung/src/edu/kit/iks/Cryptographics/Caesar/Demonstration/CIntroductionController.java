package edu.kit.iks.Cryptographics.Caesar.Demonstration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.Caesar.VisualizationInfo;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

/**
 * This class is the controller of the view CFirstView.
 * 
 * @author Wasilij Beskorovajnov.
 * 
 */
public class CIntroductionController extends AbstractVisualizationController {
	/**
	 * Contains all relevant informations about the cipher Caesar.
	 */
	private VisualizationInfo visualizationInfo;

	/**
	 * Contains all elements of the gui for the demonstration of caesar's
	 * problem.
	 */
	private CIntroductionView view;

	/**
	 * @param visualizationInfo
	 */
	public CIntroductionController(VisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		this.visualizationInfo = visualizationInfo;
		this.view = new CIntroductionView();
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

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadView() {
		// TODO Auto-generated method stub
		
	}
}