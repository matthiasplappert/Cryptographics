package edu.kit.iks.Cryptographics.DiffieHellman.Demonstration;

import java.awt.Color;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class ExplainAimController extends AbstractVisualizationController {
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
//		this.view.setBackground(Color.WHITE);

	}
	
	@Override
	public ExplainAimView getView() {
		return (ExplainAimView) this.view;
	}


}
