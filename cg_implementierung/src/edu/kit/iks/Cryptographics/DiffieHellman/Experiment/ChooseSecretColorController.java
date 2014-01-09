package edu.kit.iks.Cryptographics.DiffieHellman.Experiment;

import edu.kit.iks.Cryptographics.DiffieHellman.Model;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class ChooseSecretColorController extends AbstractVisualizationController {
	
	private Model dhModel;
	private ChooseSecretColorView view;
	
	public ChooseSecretColorController(
			AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		dhModel = Model.getInstance();
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
