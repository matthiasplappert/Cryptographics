package edu.kit.iks.CryptographicsLib;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

abstract public class AbstractController {
	protected JComponent view = null;
	
	protected AbstractController parentController = null;
	
	/**
	 * List of all child controllers
	 */
	protected List<AbstractController> childControllers = new ArrayList<AbstractController>();

	public void addChildController(AbstractController childController) {
		
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
