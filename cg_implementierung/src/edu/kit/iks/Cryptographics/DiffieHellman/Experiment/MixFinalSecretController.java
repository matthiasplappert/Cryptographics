package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.BobChooseSecretView;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class MixFinalSecretController extends AbstractVisualizationController {
	
	private MixFinalSecretView view;
	
	public MixFinalSecretController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new MixFinalSecretView();
		
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
	public MixFinalSecretView getView() {
		return (MixFinalSecretView) this.view;
	}

}
