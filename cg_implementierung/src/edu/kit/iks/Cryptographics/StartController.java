package edu.kit.iks.Cryptographics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		this.view = new JPanel();

		this.welcomeView = new WelcomeView();
		this.view.add(this.welcomeView);

		this.timelineView = new TimelineView(visualizationInfos);
		this.view.add(this.timelineView);

		for (VisualizationButton button : this.timelineView.getButtons()) {
			button.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent event) {
					// TODO: check if getSource() is the right method
					VisualizationButton button = (VisualizationButton) event
							.getSource();
					presentPopoverAction(button.getVisualizationInfo());

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});

		}
		this.view.revalidate();
	}

	/**
	 * Unloads the view by setting all object references to null
	 */
	@Override
	public void unloadView() {
		// TODO: Unload the view correctly.
		this.view.remove(welcomeView);
		this.view.remove(timelineView);
		this.view.validate();
		this.popoverView = null;
		this.welcomeView = null;
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
		this.popoverView = new TimelinePopoverView(vsInfo);
		this.view.add(this.popoverView);
		this.popoverView.validate();
		// call needed to re-layout the new view. Else popoverView is not
		// visible.
		this.view.revalidate();
	}

	/**
	 * Shows a popover with information from given {visualizationInfo}
	 * 
	 * @param visualizationInfo
	 *            Object of {VisualizationInfo} containing the metadata to
	 *            display
	 */
	public void presentPopoverAction(AbstractVisualizationInfo visualizationInfo) {

		loadPopoverView(visualizationInfo);
		this.popoverView.getStartButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent event) {
				VisualizationButton startButton = (VisualizationButton)event.getSource();
				startVisualizationAction(startButton.getVisualizationInfo());
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});
		this.popoverView.getCloseButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		// TODO: get visualizationInfo from actionevent and call
		// this.startVisualizationAction(visualizationInfo);

		// TODO: assign action listener for close button that calls
		// dismissPopoverAction()
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
	public void startVisualizationAction(
			AbstractVisualizationInfo visualizationInfo) {
		MainController mainController = (MainController) this
				.getParentController();
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
