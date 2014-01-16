package edu.kit.iks.Cryptographics.Vigenere.Explanation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.Cryptographics.Vigenere.*;
import edu.kit.iks.Cryptographics.Vigenere.Demonstration.SecondDemonstrationView;
import edu.kit.iks.Cryptographics.Vigenere.Experiment.FirstExperimentView;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class SecondExplanationController extends AbstractVisualizationController {
	
	public SecondExplanationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}
	
	@Override
	public SecondExplanationView getView() {
		// TODO Auto-generated method stub
		return (SecondExplanationView)this.view;
	}
	
	@Override
	public void loadView() {
		// TODO Auto-generated method stub
		this.view = new SecondExplanationView();
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
