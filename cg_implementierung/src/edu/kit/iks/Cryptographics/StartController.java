package edu.kit.iks.Cryptographics;

import java.util.List;
import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class StartController extends AbstractController {
	private PopoverView _popoverView;
	
	private TimelineView _timelineView;
	
	private WelcomeView _welcomeView;
	
	private List<AbstractVisualizationInfo> _visualizationInfos;
	
	public void presentPopoverAction(AbstractVisualizationInfo visualizationInfo) {
		
	}
	
	public void dismissPopoverAction() {
		
	}
	
	public void startVisualizationAction(AbstractVisualizationInfo visualizationInfo) {
		
	}
	
	private void _loadAllVisualizationInfos() {
		this._visualizationInfos = VisualizationInfoLoader.loadAllVisualizationInfos();
	}
}
