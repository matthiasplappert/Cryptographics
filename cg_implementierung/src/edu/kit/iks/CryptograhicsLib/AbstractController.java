package edu.kit.iks.CryptograhicsLib;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

public class AbstractController {
	public JComponent view = null;
	
	public AbstractController parentController = null;
	
	public List<AbstractController> childControllers;
	
	public AbstractController() {
		this.childControllers = new ArrayList<AbstractController>();
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
}
