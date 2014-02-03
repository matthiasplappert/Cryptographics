package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import edu.kit.iks.Cryptographics.DiffieHellman.Demonstration.BobChooseSecretView;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class ChooseSecretColorController extends AbstractVisualizationController {
	
	private ChooseSecretColorView view;
	
	public ChooseSecretColorController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new ChooseSecretColorView();
		
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
	public ChooseSecretColorView getView() {
		return (ChooseSecretColorView) this.view;
	}

}
