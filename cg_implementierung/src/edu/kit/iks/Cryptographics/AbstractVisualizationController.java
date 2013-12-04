package edu.kit.iks.Cryptographics;

import edu.kit.iks.CryptograhicsLib.AbstractController;

abstract public class AbstractVisualizationController extends AbstractController {
	private AbstractVisualizationInfo _visualizationInfo;
	
	public AbstractVisualizationController(AbstractVisualizationInfo visualizationInfo) {
		_visualizationInfo = visualizationInfo;
	}
	
	public AbstractVisualizationInfo getVisualizationInfo() {
		return null;
	}
}
