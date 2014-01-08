package edu.kit.iks.CryptographicsLib;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

abstract public class AbstractController {
	protected JComponent view = null;
	
	protected AbstractController parentController = null;
	
	/**
	 * List of all child controllers. A view controller can have many
	 * child view controllers. The view of a child view controller should
	 * always be visible, so this is not a list of possible child controllers
	 * but rather a list of all currently used child controllers!  
	 */
	protected List<AbstractController> childControllers = new ArrayList<AbstractController>();

	public void addChildController(AbstractController childController) {
		childController.parentController = this;
		childControllers.add(childController);
	}
	
	public void removeChildController(AbstractController childController) {
		
	}
	
	abstract public void loadView();
	
	public void unloadView() {
		this.view = null;
	}
	
	public JComponent getView() {
		return this.view;
	}

	public AbstractController getParentController() {
		return this.parentController;
	}
	
	public List<AbstractController> getChildControllers() {
		// TODO: return immutable copy
		return this.childControllers;
	}
	
	public boolean viewIsLoaded() {
		return (this.view != null);
	}
}
