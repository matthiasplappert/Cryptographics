package edu.kit.iks.Cryptographics;

import java.util.List;
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
	 */	private TimelineView timelineView;
	
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
		super();
		
		this.popoverView = new PopoverView();
		this.welcomeView = new WelcomeView();
		this.timelineView = new TimelineView();

		this.loadAllVisualizationInfos();
	}
	
	@Override
	public void loadView() {
		this._view.add(this.popoverView);
		this._view.add(this.welcomeView);
		this._view.add(this.timelineView);
	}
	
	@Override
	public void unloadView() {
		this.popoverView = null;
		this.welcomeView = null;
		this.timelineView = null;
		this._view = null;
	}
	
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
	 * @param visualizationInfo Object of {VisualizationInfo} containing the
	 * data to instantiate related controllers from
	 */
	public void startVisualizationAction(AbstractVisualizationInfo visualizationInfo) {
		
	}
	
	/**
	 * Helper method to initialize {_visualizationInfos} 
	 */
	private void loadAllVisualizationInfos() {

		this.visualizationInfos = VisualizationInfoLoader.loadAllVisualizationInfos();
	}
}
