package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class OnewayController extends AbstractVisualizationController {
	private OnewayView view;
	
	public OnewayController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		view = new OnewayView();
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
	public OnewayView getView() {
		return (OnewayView) this.view;
	}
}
