package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class DHDemoFirstController extends AbstractVisualizationController {

	public DHDemoFirstController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadView() {
		this.view = new DHDemoFirstView();

	}

}
