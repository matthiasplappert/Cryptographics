package edu.kit.iks.Cryptographics;

import edu.kit.iks.CryptograhicsLib.AbstractController;

public class VisualizationContainerController extends AbstractController {
	private VisualizationContainerView _containerView;
	
	private AbstractVisualizationInfo _visualizationInfo;
	
	public VisualizationContainerController(AbstractVisualizationInfo visualizationInfo) {
		_visualizationInfo = visualizationInfo;
		_loadVisualizationController();
	}
	
	public AbstractVisualizationInfo getVisualizationInfo() {
		return _visualizationInfo;
	}
	
	private void _loadVisualizationController() {
		
	}
}
