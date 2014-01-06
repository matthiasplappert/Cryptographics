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
	 * Active child controller. Overrides {_activeChildController} from
	 * {AbstractController}
	 */
	private int currentVisualizationControllerIndex;

	private AbstractVisualizationController[] visualizationControllers;

	private AbstractVisualizationInfo visualizationInfo;

	/**
	 * Container to display the actual visualization of a procedure
	 */
	private VisualizationContainerView view;

	/**
	 * Constructor initializing a new instance of
	 * {VisualizationContainerController}
	 * 
	 * @param visualizationInfo
	 *            Object of {VisualizationInfo} containing the data to
	 *            instantiate related controllers from
	 */
	public VisualizationContainerController(
			AbstractVisualizationInfo visualizationInfo) {
		this.visualizationInfo = visualizationInfo;
		List<Class> childClasses = this.visualizationInfo
				.getControllerClasses();

		// Create an array that can hold all visualization controllers.
		// The controller's will be instantiated on demand (lazily).
		this.visualizationControllers = new AbstractVisualizationController[childClasses
				.size()];
	}

	/**
	 * Gets the {VisualizationInfo}-object of the current visualization
	 * 
	 * @return {VizualizationInfo}-object of the current visualization
	 */
	public AbstractVisualizationInfo getVisualizationInfo() {
		return this.visualizationInfo;
	}

	@Override
	public void loadView() {
		this.view = new VisualizationContainerView();
	}

	@Override
	public VisualizationContainerView getView() {
		return this.view;
	}

	public void setCurrentVisualizationControllerIndex(int index) {
		AbstractVisualizationController oldController = this
				.getCurrentVisualizationController();
		if (oldController != null) {
			this.removeChildController(oldController);

			// Remove view
			this.getView().remove(oldController.getView());
			oldController.unloadView();
		}

		// Load new controller if necessary.
		AbstractVisualizationController newController = this.visualizationControllers[index];
		if (newController == null) {
			newController = this.loadVisualizationController(index);
		}

		// Set new controller
		this.currentVisualizationControllerIndex = index;
		this.addChildController(newController);

		// Load new view
		newController.loadView();
		this.getView().add(newController.getView());
	}

	public AbstractVisualizationController getCurrentVisualizationController() {
		return this.visualizationControllers[this.currentVisualizationControllerIndex];
	}

	public AbstractVisualizationController currentVisualizationController() {
		return this.visualizationControllers[this.currentVisualizationControllerIndex];
	}

	public boolean hasNextVisualizationController() {
		return (this.currentVisualizationControllerIndex < this.visualizationInfo
				.getControllerClasses().size() - 1);
	}

	public void presentNextVisualizationController() {
		this.setCurrentVisualizationControllerIndex(this.currentVisualizationControllerIndex + 1);
	}

	public boolean hasPreviousVisualizationController() {
		return (this.currentVisualizationControllerIndex > 1);
	}

	public void presentPreviousVisualizationController() {
		this.setCurrentVisualizationControllerIndex(this.currentVisualizationControllerIndex - 1);
	}

	private AbstractVisualizationController loadVisualizationController(int index) {
		AbstractVisualizationController controller = null;
		Class<AbstractVisualizationController> controllerClass = this.visualizationInfo.getControllerClasses().get(index);
		/*try {
			// TODO: pass VisualizationInfo to the controller!
			controller = controllerClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		this.visualizationControllers[index] = controller;
		return controller;
	}
}
