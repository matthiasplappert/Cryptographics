package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import edu.kit.iks.Cryptographics.DiffieHellman.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class ChooseSecretColorController extends AbstractController {
	
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

}
