package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class CongratsController extends AbstractVisualizationController {
	private CongratsView view;
	
	public CongratsController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new CongratsView();
		// TODO Auto-generated constructor stub
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

	/*
	 * (non-Javadoc)
	 * @see edu.kit.iks.CryptographicsLib.AbstractController#unloadView()
	 */
	@Override
	public void unloadView() {
		this.view = null;
	}
	
	@Override
	public CongratsView getView() {
		return (CongratsView) this.view;
	}
}
