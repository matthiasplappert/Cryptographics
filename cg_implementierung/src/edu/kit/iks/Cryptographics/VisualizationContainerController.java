package edu.kit.iks.Cryptographics;

import java.util.List;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class VisualizationContainerController extends AbstractController {
	private VisualizationContainerView _containerView;
	
	protected AbstractVisualizationController _activeChildController;
	
	private AbstractVisualizationInfo _visualizationInfo;
	
	public VisualizationContainerController(AbstractVisualizationInfo visualizationInfo) {
		_visualizationInfo = visualizationInfo;
		
		// TODO: Example to instantiate all possible child classes
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
	
	public AbstractVisualizationInfo getVisualizationInfo() {
		return _visualizationInfo;
	}
}
