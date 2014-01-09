package edu.kit.iks.Cryptographics;

import javax.swing.JPanel;
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
	 * Loads the view
	 */
	@Override
	public void loadView() {
		this.loadFrame();
		this.view = new JPanel();
		this.frame.add(this.view);
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
			this.view.remove(this.visualizationContainerController.getView());
			this.visualizationContainerController.unloadView();
			this.removeChildController(this.visualizationContainerController);
		}
		
		this.startController = new StartController();
		this.startController.loadView();
		this.addChildController(this.startController);
		this.view.add(this.startController.getView());

		// Important to call validate, as some elements may
		// be invisible otherwise
		this.view.revalidate();
		this.view.repaint();
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
			this.view.remove(this.startController.getView());
			this.startController.unloadView();
			this.removeChildController(this.startController);
		}

		// load VisualizationContainerController
		this.visualizationContainerController = new VisualizationContainerController(
				visualizationInfo);
		// load view
		this.visualizationContainerController.loadView();
		this.addChildController(this.visualizationContainerController);
		this.view.add(this.visualizationContainerController.getView());
		this.visualizationContainerController.setCurrentVisualizationControllerIndex(0);
		
		this.view.revalidate();
		this.view.repaint();
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
