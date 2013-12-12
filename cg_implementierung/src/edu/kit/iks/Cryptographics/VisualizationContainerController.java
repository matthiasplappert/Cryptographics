package edu.kit.iks.Cryptographics;

import javax.swing.JButton;
import javax.swing.JLabel;

import edu.kit.iks.CryptographicsLib.AbstractController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class VisualizationContainerController extends AbstractController {
	private JLabel _nameLabel;
	
	private JButton _exitButton;
	
	private JButton _helpButton;
	
	private AbstractVisualizationInfo _visualizationInfo;
	
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
