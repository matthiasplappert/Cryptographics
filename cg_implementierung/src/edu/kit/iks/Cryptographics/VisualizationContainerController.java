package edu.kit.iks.Cryptographics;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
	 * The timer used to detect an idle user. This is used to figure out when to
	 * present the idle popover, so it's step 1.
	 */
	private Timer idleDetectionTimer;
	
	/**
	 * The timer used to reset the state. This is step two of the idle detection.
	 */
	private Timer resetTimer;
	
	/**
	 * The global event listener used for detecting an idle user.
	 */
	private AWTEventListener idleDetectionListener;
	
	/**
	 * The popover presented to warn the user before going back to the main screen.
	 */
	private IdlePopoverView idlePopoverView;

	/**
	 * List of all child classes
	 */
	List<Class> childClasses;
	
	/**
	 * View of the popover wich shows help for the user.
	 */
	private HelpPopoverView helpPopoverView;

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
		this.idleDetectionListener = new AWTEventListener() {
			@Override
			public void eventDispatched(AWTEvent e) {
				cancelIdleDetectionTimer();
				if (idlePopoverView == null) {
					startIdleDetectionTimer();
				}
			}
		};
		this.startIdleDetectionTimer();

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
		// Observe global mouse events.
		Toolkit.getDefaultToolkit().addAWTEventListener(this.idleDetectionListener, AWTEvent.MOUSE_MOTION_EVENT_MASK);
		
		this.view = new VisualizationContainerView();
		this.view.getNameLabel().setText(this.getVisualizationInfo().getName());
		
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
	}

	/**
	 * Unloads the view
	 */
	@Override
	public void unloadView() {
		// Remove observer.
		Toolkit.getDefaultToolkit().removeAWTEventListener(this.idleDetectionListener);
		
		// Cancel timers.
		this.cancelIdleDetectionTimer();
		this.cancelResetTimer();
		
		if (this.helpPopoverView != null) {
			this.dismissHelpPopover();
		}
		
		if (this.idlePopoverView != null) {
			this.dismissIdlePopover();
		}
		
		this.view.removeAll();
		this.view.revalidate();
		
		this.helpPopoverView = null;
		this.idlePopoverView = null;
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
	 * Creates and presents a new idle popover. The idle popover is presented
	 * after the program things that the user is idle. It displays a count-down
	 * after which it resets itself.  
	 */
	public void presentIdlePopover() {
		if (this.helpPopoverView != null) {
			this.dismissHelpPopover();
		}
		if (this.idlePopoverView != null) {
			this.dismissIdlePopover();
		}
		
		// Create popover.
		this.idlePopoverView = new IdlePopoverView(Configuration.getInstance().getResetTimeout());
		this.idlePopoverView.present(this.getView().getExitButton());
		
		// Create mouse listeners for buttons.
		MouseListener listener = new MouseListener() {
			
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
				dismissIdlePopover();
				startIdleDetectionTimer();
			}
		};
		this.idlePopoverView.getCloseButton().addMouseListener(listener);
		this.idlePopoverView.getContinueButton().addMouseListener(listener);
		
		this.startResetTimer();
	}
	
	/**
	 * Dismisses the active idle popover.
	 */
	public void dismissIdlePopover() {
		this.idlePopoverView.dismiss();
		this.idlePopoverView = null;
		this.cancelResetTimer();
	}
	
	/**
	 * Cancels the reset timer.
	 */
	private void cancelResetTimer() {
		if (this.resetTimer != null) {
			this.resetTimer.cancel();
			this.resetTimer = null;
		}
	}
	
	/**
	 * Starts the reset timer. After the timer fires, the program
	 * will present the start controller.
	 */
	private void startResetTimer() {
		if (this.resetTimer == null) {
			this.resetTimer = new Timer();
			this.resetTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					MainController mainController = (MainController) getParentController();
					mainController.presentStartAction();
				}
			}, Configuration.getInstance().getResetTimeout());
		}
	}
	
	/**
	 * Cancels an idle detection timer.
	 */
	private void cancelIdleDetectionTimer() {
		if (this.idleDetectionTimer != null) {
			this.idleDetectionTimer.cancel();
			this.idleDetectionTimer = null;
		}
	}
	
	/**
	 * Starts the idle detection timer. The idle detection fires if a user
	 * doesn't perform any input for a given period of time.
	 */
	private void startIdleDetectionTimer() {
		if (this.idleDetectionTimer == null) {
			// Create a new timer if the idle popover is currently not already active.
			this.idleDetectionTimer = new Timer();
			this.idleDetectionTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					presentIdlePopover();
				}
			}, Configuration.getInstance().getIdleTimeout());
		}
	}

	/**
	 * Shows a popover displaying given help.
	 * 
	 */
	public void presentHelpPopover() {
		if (this.helpPopoverView != null) {
			this.dismissHelpPopover();
		}
		if (this.idlePopoverView != null) {
			this.dismissIdlePopover();
		}
		
		String helpText = this.getCurrentVisualizationController().getHelp();
		if (helpText == null) {
			// Do not present help if no help is available.
			return;
		}
		
		this.helpPopoverView = new HelpPopoverView(helpText);
		this.helpPopoverView.getCloseButton().addMouseListener(new MouseListener() {
			
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
				dismissHelpPopover();
				
			}
		});
		this.helpPopoverView.present(this.getView().getHelpButton());
	}
	
	/**
	 * Function for unloading the helpView.
	 */
	public void dismissHelpPopover() {
		this.helpPopoverView.dismiss();
		this.helpPopoverView = null;
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
			this.getView().getContentView().remove(oldController.getView());
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
		this.getView().getContentView().add(newController.getView(), BorderLayout.CENTER);
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

	/**
	 * Presents the start controller
	 */
	public void presentStartController() {
		if (this.helpPopoverView != null) {
			this.dismissHelpPopover();
		}
		
		MainController mainController = (MainController) this
				.getParentController();
		mainController.presentStartAction();
	}
	
	/**
	 * @return the helpView
	 */
	public HelpPopoverView getHelpPopoverView() {
		return helpPopoverView;
	}
}
