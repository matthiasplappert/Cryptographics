package edu.kit.iks.CryptographicsLib;

public abstract class AbstractVisualizationController extends AbstractController {
	private AbstractVisualizationInfo visualizationInfo;
	
	public AbstractVisualizationController(AbstractVisualizationInfo visualizationInfo) {
		this.visualizationInfo = visualizationInfo;
	}
	
	public AbstractVisualizationInfo getVisualizationInfo() {
		return this.visualizationInfo;
	}
	
	abstract public String getHelp();
}
