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
	private PopoverView _popoverView;
	
	/**
	 * An instance of the timeline view
	 */
	private TimelineView _timelineView;
	
	/**
	 * An instance of the welcome view
	 */
	private WelcomeView _welcomeView;
	
	/**
	 * A list of all VisualizationInfo-objects 
	 */
	private List<AbstractVisualizationInfo> _visualizationInfos;
	
	/**
	 * Constructor initializing a new instance of {StartController}
	 */
	public StartController() {
		super();
		this._loadAllVisualizationInfos();
	}
	
	/**
	 * Shows a popover with information from given {visualizationInfo}
	 * 
	 * @param visualizationInfo Object of {VisualizationInfo} containing the
	 * metadata to display
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
	 * @param visualizationInfo Object of {VisualizationInfo} containing the
	 * data to instantiate related controllers from
	 */
	public void startVisualizationAction(AbstractVisualizationInfo visualizationInfo) {
		
	}
	
	/**
	 * Helper method to initialize {_visualizationInfos} 
	 */
	private void _loadAllVisualizationInfos() {
		this._visualizationInfos = VisualizationInfoLoader.loadAllVisualizationInfos();
	}
}
