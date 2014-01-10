package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import edu.kit.iks.Cryptographics.DiffieHellman.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class ExplainAimController extends AbstractController {
	private ExplainAimView view;
	
	public ExplainAimController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new ExplainAimView();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadView() {
		this.view = new ExplainAimView();

	}

}
