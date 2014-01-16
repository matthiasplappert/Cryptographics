package edu.kit.iks.Cryptographics;

import java.awt.BorderLayout;

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
	private JFrame frame;

	/**
	 * An instance of the start controller, showing a teaser to draw attention
	 */
	private StartController startController;

	/**
	 * An instance of a container controller, visualizing a cryptographic
	 * procedure inside
	 */
	private VisualizationContainerController visualizationContainerController;

	/**
	 * Just loads the frame. This controller is specially since it does not load a view.
	 */
	@Override
	public void loadView() {
		this.loadFrame();
	}

	/**
	 * Loads the JFrame
	 */
	private void loadFrame() {
		this.frame = new JFrame("Cryptographics");
		this.frame.setSize(1366, 768); // Basic size for testing. Needs to be
										// fullscreen in the end
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Starts the visualization of StartController
	 */
	public void presentStartAction() {
		if (this.visualizationContainerController != null) {
			if (this.visualizationContainerController.getHelpPopoverView() != null) {
				this.visualizationContainerController.dismissHelpPopover();
			}
			this.frame.getContentPane().remove(this.visualizationContainerController.getView());
			this.visualizationContainerController.unloadView();
			this.removeChildController(this.visualizationContainerController);
		}
		
		this.startController = new StartController();
		this.startController.loadView();
		this.addChildController(this.startController);
		this.frame.getContentPane().add(this.startController.getView(), BorderLayout.CENTER);

		// Important to call validate, as some elements may
		// be invisible otherwise
		this.frame.getContentPane().revalidate();
		this.frame.getContentPane().repaint();
		this.frame.validate();
	}

	/**
	 * Starts the visualization of a procedure with given {visualizationInfo}
	 * 
	 * @param visualizationInfo
	 *            Metadata of the cryptographic procedure to instantiate the
	 *            controller from
	 */
	public void presentVisualizationAction(
			AbstractVisualizationInfo visualizationInfo) {
		// TODO: figure out if we need to unload the view/controller
		if (this.startController != null) {
			this.frame.getContentPane().remove(this.startController.getView());
			this.startController.unloadView();
			this.removeChildController(this.startController);
		}

		// load VisualizationContainerController
		this.visualizationContainerController = new VisualizationContainerController(
				visualizationInfo);
		// load view
		this.visualizationContainerController.loadView();
		this.addChildController(this.visualizationContainerController);
		this.frame.getContentPane().add(this.visualizationContainerController.getView(), BorderLayout.CENTER);
		this.visualizationContainerController.setCurrentVisualizationControllerIndex(0);
		
		this.frame.getContentPane().revalidate();
		this.frame.getContentPane().repaint();
		this.frame.revalidate();
	}

	/**
	 * Helper method to load the {StartController}
	 */
	private void loadStartController() {
		this.startController = new StartController();
	}

	/**
	 * Helper method to load the {VisualizationContainerController}
	 */
	private void loadVisualizationContainerController() {

	}
}
