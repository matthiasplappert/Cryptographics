package edu.kit.iks.CryptographicsLib;

import javax.swing.JComponent;
import javax.swing.JPanel;

abstract public class AbstractController {
	protected JPanel view = null;
	
	protected AbstractController parentController = null;
	
	/**
	 * The child controller.
	 */
	protected AbstractController childController;

	public void setChildController(AbstractController childController) {
		// Remove old child, if it exists.
		if (this.childController != null) {
			this.view.remove(this.childController.getView());
			this.childController.parentController = null;
		}
		
		// Set new child.
		childController.parentController = this;
		this.childController = childController;
		
		// Load and configure view of child.
		if (!childController.viewIsLoaded()) {
			childController.loadView();
		}
		JComponent childView = childController.getView();
		// TODO: set to view coordinates!
		this.view.add(childView);
	}
	
	public void loadView() {
		this.view = new JPanel();
	}
	
	public void unloadView() {
		this.view = null;
	}
	
	public JComponent getView() {
		return this.view;
	}

	public AbstractController getParentController() {
		return this.parentController;
	}
	
	public AbstractController getChildController() {
		return this.childController;
	}
	
	public boolean viewIsLoaded() {
		return (this.view != null);
	}
}
