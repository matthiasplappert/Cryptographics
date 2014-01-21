package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class AliceChooseSecretController extends AbstractVisualizationController {
	private AliceChooseSecretView view;
	
	public AliceChooseSecretController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new AliceChooseSecretView();
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
