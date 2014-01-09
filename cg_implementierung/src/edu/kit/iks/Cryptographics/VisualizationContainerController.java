package edu.kit.iks.Cryptographics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * An instance of this class is a wrapper for visualization controller to
 * outsource common UI elements like navigation buttons
 * 
 * @author Christian Dreher
 */
public class VisualizationContainerController extends AbstractController {

	/**
	 * Index of the current {VisualizationController} in {childControllers}-list
	 */
	private int currentVisualizationControllerIndex;

	/**
	 * List of all visualizationControllers. Behaves like a cache and will be
	 * filled on demand
	 */
	private AbstractVisualizationController[] visualizationControllers;

	/**
	 * {VisualizationInfo}-object holding metadata of the procuedure
	 */
	private AbstractVisualizationInfo visualizationInfo;

	/**
	 * Container to display the actual visualization of a procedure
	 */
	private VisualizationContainerView view;

	/**
	 * List of all child classes
	 */
	List<Class> childClasses;

	/**
	 * Constructor initializing a new instance of
	 * {VisualizationContainerController}
	 * 
	 * @param visualizationInfo
	 *            Object of {VisualizationInfo} containing the data to
	 *            instantiate related controllers from
	 */
	public VisualizationContainerController(
			AbstractVisualizationInfo visualizationInfo) {
		this.visualizationInfo = visualizationInfo;
		this.childClasses = this.visualizationInfo.getControllerClasses();

		// Create an array that can hold all visualization controllers.
		// The controller's will be instantiated on demand (lazily).
		this.visualizationControllers = new AbstractVisualizationController[this.childClasses
				.size()];
	}

	/**
	 * Gets the {VisualizationInfo}-object of the current visualization
	 * 
	 * @return {VizualizationInfo}-object of the current visualization
	 */
	public AbstractVisualizationInfo getVisualizationInfo() {
		return this.visualizationInfo;
	}

	/**
	 * Loads the view
	 */
	@Override
	public void loadView() {
		this.view = new VisualizationContainerView();
		this.view.getHelpButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.view.getExitButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				MainController mainController = (MainController) getParentController();
				mainController.presentStartAction();
			}
		});
		this.view.getHelpButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				presentHelpPopover();

			}
		});

		// TODO: dispatch call to currentVisualizationController.getHelp()
		// TODO: present popover for help

	}

	/**
	 * Unloads the view
	 */
	@Override
	public void unloadView() {
		this.view.removeAll();
		this.view.revalidate();
		this.view = null;
	}

	/**
	 * Gets the view
	 */
	@Override
	public VisualizationContainerView getView() {
		return this.view;
	}

	/**
	 * Shows a popover displaying given help.
	 * 
	 */
	public void presentHelpPopover() {
		HelpPopoverView helpView = new HelpPopoverView(this
				.getCurrentVisualizationController().getHelp());
		this.getCurrentVisualizationController().setHelpView(helpView);
		helpView.getCloseButton().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dismissHelp();
				
			}
		});
		this.view.add(helpView);
		this.view.revalidate();
	}
	
	/**
	 * Function for unloading the helpView.
	 */
	public void dismissHelp() {
		this.view.remove(this.getCurrentVisualizationController().getHelpView());
		this.view.revalidate();
		this.getCurrentVisualizationController().setHelpView(null);
	}

	/**
	 * Sets the current visualizationController with given index
	 * 
	 * @param index
	 *            Index of the VisualizationController inside
	 *            {visualizationControllers}-array
	 */
	public void setCurrentVisualizationControllerIndex(int index) {
		AbstractVisualizationController oldController = this
				.getCurrentVisualizationController();
		if (oldController != null) {
			this.removeChildController(oldController);

			// Remove view
			this.getView().remove(oldController.getView());
			oldController.unloadView();
		}

		// Load new controller if necessary.
		AbstractVisualizationController newController = this.visualizationControllers[index];
		if (newController == null) {
			newController = this.loadVisualizationController(index);
		}

		// Set new controller
		this.currentVisualizationControllerIndex = index;
		this.addChildController(newController);

		// Load new view
		newController.loadView();
		this.getView().add(newController.getView());
		this.getView().revalidate();
	}

	/**
	 * Gets the current {VisualizationController}
	 * 
	 * @return Current {VisualizationController}
	 */
	public AbstractVisualizationController getCurrentVisualizationController() {
		return this.visualizationControllers[this.currentVisualizationControllerIndex];
	}

	/**
	 * Checks, whether this controller has a next {VisualizationController} or
	 * not
	 * 
	 * @return {true}, if this controller has a next {VisualizationController},
	 *         {false} if not
	 */
	public boolean hasNextVisualizationController() {
		return (this.currentVisualizationControllerIndex < childClasses.size() - 1);
	}

	/**
	 * Presents the next {VisualizationController}
	 */
	public void presentNextVisualizationController() {
		this.setCurrentVisualizationControllerIndex(this.currentVisualizationControllerIndex + 1);
	}

	/**
	 * Checks, whether this controller has a previous {VisualizationController}
	 * or not
	 * 
	 * @return {true}, if this controller has a previous
	 *         {VisualizationController}, {false} if not
	 */
	public boolean hasPreviousVisualizationController() {
		return (this.currentVisualizationControllerIndex > 1);
	}

	/**
	 * Presents the previous {VisualizationController}
	 */
	public void presentPreviousVisualizationController() {
		this.setCurrentVisualizationControllerIndex(this.currentVisualizationControllerIndex - 1);
	}

	/**
	 * Loads the {VisualizationController} with given {index}
	 * 
	 * @param index
	 *            Index of the {VisualizationController} inside
	 *            {visualizationControllers}-array
	 * @return The just loaded {VisualizationController}
	 */
	private AbstractVisualizationController loadVisualizationController(
			int index) {
		Constructor<AbstractVisualizationController> controllerConstructor = null;
		Class<AbstractVisualizationController> controllerClass = childClasses
				.get(index);
		AbstractVisualizationController controller = null;

		try {
			// visualizationinfo is now passed to the contructor.
			controllerConstructor = controllerClass
					.getConstructor(AbstractVisualizationInfo.class);
			controller = controllerConstructor
					.newInstance(this.visualizationInfo);
		} catch (InstantiationException | IllegalAccessException
				| NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		this.visualizationControllers[index] = controller;
		return controller;
	}

	public void presentStartController() {
		MainController mainController = (MainController) this
				.getParentController();
		mainController.presentStartAction();
	}
}
