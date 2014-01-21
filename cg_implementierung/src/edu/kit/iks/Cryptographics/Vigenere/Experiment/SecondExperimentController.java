package edu.kit.iks.Cryptographics.Vigenere.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class SecondExperimentController extends AbstractVisualizationController {
	
	public SecondExperimentController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}
	
	@Override
	public SecondExperimentView getView() {
		// TODO Auto-generated method stub
		return (SecondExperimentView)this.view;
	}
	
	@Override
	public void loadView() {
		// TODO Auto-generated method stub
		this.view = new SecondExperimentView();
		this.getView().getBackButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				containerController.presentPreviousVisualizationController();
			}
		});
		this.getView().getNextButton().addActionListener(new ActionListener() {
			/*
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt
			 * .event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				VisualizationContainerController containerController = (VisualizationContainerController)getParentController();
				containerController.presentNextVisualizationController();
			}
		});
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}
}