package edu.kit.iks.CryptograhicsLib;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

abstract public class AbstractController {
	protected JComponent _view = null;
	
	protected AbstractController _parentController = null;
	
	protected List<AbstractController> _childControllers;
	
	public AbstractController() {
		_childControllers = new ArrayList<AbstractController>();
	}

	public void addChildController(AbstractController childController) {
		
	}
	
	public void removeChildController(AbstractController childController) {
		
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
}
