package edu.kit.iks.CryptographicsLib;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

abstract public class AbstractController {
	protected JComponent _view = null;
	
	protected AbstractController _parentController = null;
	
	/**
	 * List of all possible child controllers
	 */
	protected List<AbstractController> _childControllers;
	
	/**
	 * The child controller which is currently active.
	 */
	protected AbstractController _activeChildController;
	
	public AbstractController() {
		_childControllers = new ArrayList<AbstractController>();
	}

	public void addChildController(AbstractController childController) {
		
	}
	
	public void removeChildController(AbstractController childController) {
		
	}
	
	/**
	 * Sets the currently active child controller from given {phase} 
	 * 
	 * @param phase The phase of the child controller which should be set as active.
	 * 		  First controller is {phase = 0}
	 */
	public void setActiveChildController(int phase) {
		
		// TODO check phase for validity. {phase} will be passed through the clicked button
		
		this._activeChildController = this._childControllers.get(phase);
	}
	
	public void loadView() {
		
	}
	
	public void unloadView() {
		_view = null;
	}
	
	public JComponent getView() {
		return _view;
	}

	public void setView(JComponent view) {
		_view = view;
	}

	public AbstractController getParentController() {
		return _parentController;
	}
	
	public List<AbstractController> getChildControllers() {
		// TODO: return immutable copy
		return _childControllers;
	}
	
	public boolean viewIsLoaded() {
		return (_view != null);
	}
}
