package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import edu.kit.iks.Cryptographics.DiffieHellman.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class BobChooseSecretController extends AbstractController {
	private BobChooseSecretView view;
	
	public BobChooseSecretController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new BobChooseSecretView();
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
