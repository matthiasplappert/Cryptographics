package edu.kit.iks.CryptographicsLib;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;

abstract public class AbstractController {
	protected JPanel _view = null;
	
	protected AbstractController _parentController = null;
	
	/**
	 * List of all possible child controllers
	 */
	protected List<AbstractController> _childControllers;
	
	/**
	 * The child controller which is currently active.
	 */
	protected AbstractController activeChildController;
	
	public AbstractController() {
		_childControllers = new ArrayList<AbstractController>();
	}

	public void addChildController(AbstractController childController) {
		
	}
	
	public void removeChildController(AbstractController childController) {
		
	}
	
	/**
	 * Sets the currently active child controller from given {index} 
	 * (The index is the same as the list-index of {_childControllers} or
	 * may be defined through enums)
	 * 
	 * @param index The index of the child controller which should be set as active.
	 */
	public void setActiveChildController(int index) {
		
		// TODO: check phase for validity. {phase} will be passed through the clicked button
		
		this._activeChildController = this._childControllers.get(index);
	}
	
	public void loadView() {
		
	}
	
	public void unloadView() {
		_view = null;
	}
	
	public JComponent getView() {
		return _view;
	}

	public void setView(JPanel view) {
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
