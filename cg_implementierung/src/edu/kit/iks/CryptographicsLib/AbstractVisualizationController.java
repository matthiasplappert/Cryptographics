package edu.kit.iks.CryptographicsLib;

/**
 * Abstract visualisization controller specialized for
 * the needs of a procedure to visualize its contents
 * 
 * @author Christian Dreher
 */
public abstract class AbstractVisualizationController extends AbstractController {
	
	/**
	 * {VisualizationInfo}-object holding all metadata of the procedure
	 */
	private AbstractVisualizationInfo visualizationInfo;
	
	/**
	 * Constructor initializing a new instance of AbstractVisualizationController 
	 * with given {visualizationInfo}
	 * 
	 * @param visualizationInfo {VisualizationInfo}-object holding 
	 * 		metadata of the procedure
	 */
	public AbstractVisualizationController(AbstractVisualizationInfo visualizationInfo) {
		this.visualizationInfo = visualizationInfo;
	}
	
	/**
	 * Gets the {VisualizationInfo}-object of the visualization
	 * 
	 * @return{VisualizationInfo}-object holding metadata of the procedure
	 */
	public AbstractVisualizationInfo getVisualizationInfo() {
		return this.visualizationInfo;
	}
	
	/**
	 * Gets the currently relevant help text
	 * 
	 * @return help text
	 */
	abstract public String getHelp();
}
