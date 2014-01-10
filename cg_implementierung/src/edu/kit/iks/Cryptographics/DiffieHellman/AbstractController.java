package edu.kit.iks.Cryptographics.DiffieHellman;

import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

abstract public class AbstractController extends AbstractVisualizationController {
	
	private Model model;

	public AbstractController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		this.model = Model.getInstance();
	}
	
	public Model getModel() {
		return this.model;
	}
	
}
