package edu.kit.iks.Cryptographics;

import java.util.List;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * An instance of this class is a wrapper for visualization controller to
 * outsource common UI elements like navigation buttons
 * 
 * @author Christian Dreher
 */
public class VisualizationContainerController extends AbstractController {
	
	/**
	 * Active child controller. 
	 * Overrides {_activeChildController} from {AbstractController}
	 */
	protected AbstractVisualizationController _activeChildController;
	
	/**
	 * Container to display the actual visualization of a procedure 
	 */
	private VisualizationContainerView _containerView;
	
	/**
	 * An object containing all metadata of the visualization being displayed 
	 */
	private AbstractVisualizationInfo _visualizationInfo;
	
	/**
	 * Constructor initializing a new instance of {VisualizationContainerController}
	 * 
	 * @param visualizationInfo Object of {VisualizationInfo} containing the
	 * data to instantiate related controllers from
	 */
	public VisualizationContainerController(AbstractVisualizationInfo visualizationInfo) {
		_visualizationInfo = visualizationInfo;
		
		/*// TODO: Example to instantiate all possible child classes
		List<Class> childClasses = this._visualizationInfo.getControllerClasses();
		
		for (Class<AbstractVisualizationController> childClass : childClasses) {
			
			AbstractVisualizationController controller = null;
			
			try {
				controller = childClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this._childControllers.add(controller);
		}
		
		this.setActiveChildController(0);
	}
	
	/**
	 * Gets the {VisualizationInfo}-object of the current visualization 
	 * 
	 * @return {VizualizationInfo}-object of the current visualization
	 */
	public AbstractVisualizationInfo getVisualizationInfo() {
		return _visualizationInfo;
	}
}
