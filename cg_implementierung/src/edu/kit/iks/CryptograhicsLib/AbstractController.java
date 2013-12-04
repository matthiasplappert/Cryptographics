package edu.kit.iks.CryptograhicsLib;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

abstract public class AbstractController {
	protected JComponent view = null;
	
	protected AbstractController parentController = null;
	
	protected List<AbstractController> childControllers;
	
	public AbstractController() {
		childControllers = new ArrayList<AbstractController>();
	}

	public void addChildController(AbstractController childController) {
		
	}
	
	public void removeChildController(AbstractController childController) {
		
	}
	
	public void loadView() {
		
	}
	
	public void unloadView() {
		this.view = null;
	}
	
	public JComponent getView() {
		return view;
	}

	public void setView(JComponent view) {
		this.view = view;
	}

	public AbstractController getParentController() {
		return parentController;
	}
	
	public List<AbstractController> getChildControllers() {
		// TODO: return immutable copy
		return childControllers;
	}
}
