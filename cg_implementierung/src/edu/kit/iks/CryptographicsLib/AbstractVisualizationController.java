package edu.kit.iks.CryptographicsLib;


abstract public class AbstractVisualizationController extends AbstractController {
	private AbstractVisualizationInfo _visualizationInfo;
	
	public AbstractVisualizationController(AbstractVisualizationInfo visualizationInfo) {
		_visualizationInfo = visualizationInfo;
	}
	
	public AbstractVisualizationInfo getVisualizationInfo() {
		return _visualizationInfo;
	}
	
	
}
