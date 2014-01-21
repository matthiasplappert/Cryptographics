package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class MixColorController extends AbstractVisualizationController {
	private MixColorView view;
	
	public MixColorController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new MixColorView();
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
