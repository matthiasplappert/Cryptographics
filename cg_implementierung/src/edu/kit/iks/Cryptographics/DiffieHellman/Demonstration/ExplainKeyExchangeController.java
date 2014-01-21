package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class ExplainKeyExchangeController extends AbstractVisualizationController {
	
	private ExplainKeyExchangeView view;
	
	public ExplainKeyExchangeController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new ExplainKeyExchangeView();
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
	
	@Override
	public ExplainKeyExchangeView getView() {
		return (ExplainKeyExchangeView) this.view;
	}

}
