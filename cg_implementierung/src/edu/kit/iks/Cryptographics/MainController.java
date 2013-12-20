package edu.kit.iks.Cryptographics;

import javax.swing.JFrame;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * An instance of this class is the main controller, delegating all performed
 * tasks to its subcontrollers like StartController (teaser) or controllers
 * visualizing a cryptographic procedure
 * 
 * @author Christian Dreher
 */
public class MainController extends AbstractController {
	
	/**
	 * A sandbox for subcontrollers to inflate their contents
	 */
	private JFrame _frame;
	
	/**
	 * An instance of the start controller, showing a teaser to draw attention
	 */
	private StartController _startController;
	
	/**
	 * An instance of a container controller, visualizing a cryptographic 
	 * procedure inside 
	 */
	private VisualizationContainerController _visualizationContainerController;
	
	/**
	 * Constructor initializing a new instance of {MainController}
	 */
	public MainController() {
		this._frame = new JFrame();
		this._startController = new StartController();
	}
	
	/**
	 * Starts the visualization of StartController
	 */
	public void presentStartAction() {
		
	}
	
	/**
	 * Starts the visualization of a procedure with given {visualizationInfo}
	 * 
	 * @param visualizationInfo Metadata of the cryptographic procedure to
	 * instantiate the controller from
	 */
	public void presentVisualizationAction(AbstractVisualizationInfo visualizationInfo) {
		
	}
	
	/**
	 * Helper method to load the {StartController}
	 */
	private void _loadStartController() {
		
	}
	
	/**
	 * Helper method to load the {VisualizationContainerController}
	 */
	private void _loadVisualizationContainerController() {
		
	}
}
