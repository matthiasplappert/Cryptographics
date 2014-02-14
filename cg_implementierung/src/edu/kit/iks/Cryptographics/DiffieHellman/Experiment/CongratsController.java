package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class CongratsController extends AbstractVisualizationController {
	private CongratsView view;
	
	public CongratsController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);

	}

	@Override
	public String getHelp() {
		return view.getHelp();
	}

	@Override
	public void loadView() {
		view = new CongratsView();		
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
