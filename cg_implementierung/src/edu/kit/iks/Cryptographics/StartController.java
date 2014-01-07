package edu.kit.iks.Cryptographics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

/**
 * An instance of this class is the start controller showing teasers
 * 
 * @author Christian Dreher
 */
public class StartController extends AbstractController {

	/**
	 * An instance of the popover view
	 */
	private PopoverView popoverView;

	/**
	 * An instance of the timeline view
	 */
	private TimelineView timelineView;

	/**
	 * An instance of the welcome view
	 */
	private WelcomeView welcomeView;

	/**
	 * A list of all VisualizationInfo-objects
	 */
	private List<AbstractVisualizationInfo> visualizationInfos;

	/**
	 * Constructor initializing a new instance of {StartController}
	 */
	public StartController() {
		this.loadAllVisualizationInfos();
	}

	/**
	 * Loads the view
	 */
	@Override
	public void loadView() {
		this.view = new JPanel();		

		//this.popoverView = new PopoverView();
		//this.view.add(this.popoverView);

		this.welcomeView = new WelcomeView();
		this.view.add(this.welcomeView);

		this.timelineView = new TimelineView(visualizationInfos);
		this.view.add(this.timelineView);
		
		// TODO: use MouseButtonClick listener
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO: check if getSource() is the right method
				TimelineViewButton button = (TimelineViewButton)event.getSource();
				presentPopoverAction(button.getVisualizationInfo());
			}
		};
		// TODO: loop through all buttons and add action listener
	}

	/**
	 * Unloads the view by setting all object references to null
	 */
	@Override
	public void unloadView() {
	    this.view.remove(welcomeView);
	    this.view.remove(timelineView);
	    this.view.validate();
		this.popoverView = null;
		this.welcomeView = null;
		this.view = null;
	}

	/**
	 * Shows a popover with information from given {visualizationInfo}
	 * 
	 * @param visualizationInfo
	 *            Object of {VisualizationInfo} containing the metadata to
	 *            display
	 */
	public void presentPopoverAction(AbstractVisualizationInfo visualizationInfo) {
		// TODO: load PopoverView
		// TODO: assign action listener to popover view for start button
		// TODO: get visualizationInfo from actionevent and call
		//        this.startVisualizationAction(visualizationInfo);
		
		// TODO: assign action listener for close button that calls dismissPopoverAction()
	}

	/**
	 * Dismisses the popover
	 */
	public void dismissPopoverAction() {
		// TODO: dismiss popover
	}

	/**
	 * Starts the visualization of a procedure from given {visualizationInfo}
	 * 
	 * @param visualizationInfo
	 *            Object of {VisualizationInfo} containing the data to
	 *            instantiate related controllers from
	 */
	public void startVisualizationAction(AbstractVisualizationInfo visualizationInfo) {
		MainController mainController = (MainController)this.getParentController();
		mainController.presentVisualizationAction(visualizationInfo);
	}

	/**
	 * Helper method to initialize {_visualizationInfos}
	 */
	private void loadAllVisualizationInfos() {
		this.visualizationInfos = VisualizationInfoLoader
				.loadAllVisualizationInfos();
	}
}
