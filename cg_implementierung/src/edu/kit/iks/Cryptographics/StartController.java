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
		this.loadView();
		this.timelineView.getButtons()[0].addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent event) {
				//unloadView();
				startVisualizationAction(visualizationInfos.get(0));
			}

		});

	}

	/**
	 * Loads the view
	 */
	@Override
	public void loadView() {
		this.view = new JPanel();

		this.popoverView = new PopoverView();
		this.view.add(this.popoverView);

		this.welcomeView = new WelcomeView();
		this.view.add(this.welcomeView);

		this.timelineView = new TimelineView(visualizationInfos);
		this.view.add(this.timelineView);
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

	}

	/**
	 * Dismisses the popover
	 */
	public void dismissPopoverAction() {

	}

	/**
	 * Starts the visualization of a procedure from given {visualizationInfo}
	 * 
	 * @param visualizationInfo
	 *            Object of {VisualizationInfo} containing the data to
	 *            instantiate related controllers from
	 */
	public void startVisualizationAction(
			AbstractVisualizationInfo visualizationInfo) {
		VisualizationContainerController container = new VisualizationContainerController(
				visualizationInfo);
		container.loadView();
		container.setCurrentVisualizationControllerIndex(0);
	}

	/**
	 * Helper method to initialize {_visualizationInfos}
	 */
	private void loadAllVisualizationInfos() {
		this.visualizationInfos = VisualizationInfoLoader
				.loadAllVisualizationInfos();
	}
}
