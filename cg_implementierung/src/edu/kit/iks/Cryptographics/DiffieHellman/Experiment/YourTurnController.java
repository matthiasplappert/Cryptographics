package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class YourTurnController extends AbstractVisualizationController {
	
	private YourTurnView view;

	public YourTurnController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new YourTurnView();
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
