package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kit.iks.Cryptographics.VisualizationContainerController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * Holds the dhexperimentview
 * 
 * @author kai
 *
 */

public class DHExperimentController extends AbstractVisualizationController {
	
	/** the corresponding dhexperimentview */
	private DHExperimentView view;
	
	/** simple constructor */
	public DHExperimentController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractVisualizationController#getHelp()
	 */
	@Override
	public String getHelp() {
		return view.getHelp();
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#loadView()
	 */
	@Override
	public void loadView() {
		view = new DHExperimentView();
		view.setRemember(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).presentNextVisualizationController();
			}
		});
		
		this.getView().getSkipButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).setCurrentVisualizationControllerIndex(5);
			}
		});
		
		this.getView().getReturnButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((VisualizationContainerController) getParentController()).setCurrentVisualizationControllerIndex(2);
			}
		});
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#getView()
	 */
	@Override
	public DHExperimentView getView() {
		return (DHExperimentView) this.view;
	}
}
