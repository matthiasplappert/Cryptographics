package edu.kit.iks.Cryptographics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;
import edu.kit.iks.CryptographicsLib.Logger;
import edu.kit.iks.CryptographicsLib.MouseClickListener;
import edu.kit.iks.CryptographicsLib.VisualizationButton;
import edu.kit.iks.CryptographicsLib.VisualizationInfoLoader;

/**
 * An instance of this class is the start controller showing teasers
 * 
 * @author Christian Dreher
 */
public class StartController extends AbstractController {

	/**
	 * An instance of the popover view
	 */
	private TimelinePopoverView popoverView;

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
		this.view = new JPanel(new GridBagLayout());
		this.view.setName("start-controller-view");
		
		// Add welcome view and its layout
		GridBagConstraints welcomeViewLayout = new GridBagConstraints();
		welcomeViewLayout.fill = GridBagConstraints.HORIZONTAL;
		welcomeViewLayout.gridy = 0;
		welcomeViewLayout.weighty = 0.95f;
		this.welcomeView = new WelcomeView();
		this.view.add(this.welcomeView, welcomeViewLayout);

		// Add timeline view and its layout
		GridBagConstraints timelineViewLayout = new GridBagConstraints();
		timelineViewLayout.fill = GridBagConstraints.HORIZONTAL;
		timelineViewLayout.weightx = 1.0f;
		timelineViewLayout.weighty = 0.05f;
		timelineViewLayout.gridy = 1;
		this.timelineView = new TimelineView(visualizationInfos);
		this.view.add(this.timelineView, timelineViewLayout);

		// Add event handlers
		for (VisualizationButton button : this.timelineView.getButtons()) {
			button.addMouseListener(new MouseClickListener() {
				@Override
				public void clicked(MouseEvent event) {
					VisualizationButton button = (VisualizationButton)event.getSource();
					presentPopoverAction(button.getVisualizationInfo(), button);
				}
			});
		}
		
		this.view.validate();
	}

	/**
	 * Unloads the view by setting all object references to null
	 */
	@Override
	public void unloadView() {
		this.view.removeAll();
		this.view.revalidate();
		
		if (this.popoverView != null) {
			this.dismissPopoverAction();
		}
		this.popoverView = null;
		this.welcomeView = null;
		this.timelineView = null;
		this.view = null;
	}

	/**
	 * Loads the view for the popover which gives the user all needed
	 * informations about the cipher he clicked.
	 * 
	 * @param vsInfo
	 *            Information about the cipher.
	 */
	private void loadPopoverView(AbstractVisualizationInfo vsInfo) {
		if (this.popoverView != null) {
			this.dismissPopoverAction();
		}
		
		this.popoverView = new TimelinePopoverView(vsInfo);
	}

	/**
	 * Shows a popover with information from given {visualizationInfo}
	 * 
	 * @param visualizationInfo
	 *            Object of {VisualizationInfo} containing the metadata to
	 *            display
	 */
	public void presentPopoverAction(AbstractVisualizationInfo visualizationInfo, JComponent sender) {
		loadPopoverView(visualizationInfo);
		this.popoverView.present(sender);
		this.popoverView.getStartButton().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent event) {
				VisualizationButton startButton = (VisualizationButton)event.getSource();
				startVisualizationAction(startButton.getVisualizationInfo());
			}
		});
		this.popoverView.getCloseButton().addMouseListener(new MouseClickListener() {
			@Override
			public void clicked(MouseEvent event) {
				dismissPopoverAction();
			}
		});
	}

	/**
	 * Dismisses the popover
	 */
	public void dismissPopoverAction() {
		this.popoverView.dismiss();
		this.popoverView = null;
	}

	/**
	 * Starts the visualization of a procedure from given {visualizationInfo}
	 * 
	 * @param visualizationInfo
	 *            Object of {VisualizationInfo} containing the data to
	 *            instantiate related controllers from
	 */
	public void startVisualizationAction(AbstractVisualizationInfo visualizationInfo) {
		this.dismissPopoverAction();
		MainController mainController = (MainController) this.getParentController();
		Logger.log("User chose " + visualizationInfo.getId());
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
