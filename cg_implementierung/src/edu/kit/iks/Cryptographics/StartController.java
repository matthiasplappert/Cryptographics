package edu.kit.iks.Cryptographics;

import java.util.List;
import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class StartController extends AbstractController {
	
	private PopoverView popoverView;
	
	private WelcomeView welcomeView;
	
	private TimelineView timelineView;
	
	private List<AbstractVisualizationInfo> _visualizationInfos;
	
	public StartController() {
		super();
		
		this.popoverView = new PopoverView();
		this.welcomeView = new WelcomeView();
		this.timelineView = new TimelineView();
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
	
	public void dismissPopoverAction() {
		
	}
	
	public void startVisualizationAction(AbstractVisualizationInfo visualizationInfo) {
		
	}
	
	private void loadAllVisualizationInfos() {
		this._visualizationInfos = VisualizationInfoLoader.loadAllVisualizationInfos();
	}
}
