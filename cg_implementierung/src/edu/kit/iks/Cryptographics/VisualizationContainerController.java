package edu.kit.iks.Cryptographics;

import javax.swing.JButton;
import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class VisualizationContainerController extends AbstractController {
	private VisualizationContainerView _containerView;
	
	private AbstractVisualizationInfo _visualizationInfo;
	
	private AbstractVisualizationController _visualizationController;
	
	public VisualizationContainerController(AbstractVisualizationInfo visualizationInfo) {
		_visualizationInfo = visualizationInfo;
		_loadVisualizationController();
	}
	
	public AbstractVisualizationInfo getVisualizationInfo() {
		return _visualizationInfo;
	}
	
	private void _loadVisualizationController() {
		
	}
}
