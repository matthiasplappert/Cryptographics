package edu.kit.iks.Cryptographics.DiffieHellman;

import javax.swing.JPanel;

import edu.kit.iks.Cryptographics.DiffieHellman.State.DHFirstState;
import edu.kit.iks.Cryptographics.DiffieHellman.State.DHStateController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;

public class DemonstrationController extends AbstractVisualizationController {
	private JPanel view;
	
	private DHStateController state;
	
	private DiffieHellmanModel model;
	
	private VisualizationInfo _visualizationInfo;
	
	public DemonstrationController() {
		super();
		this._visualizationInfo = new VisualizationInfo();
		this.state = new DHFirstState();
		this.view = this.state.getView();
		this.model = new DiffieHellmanModel();
	}
	
	public JPanel getView() {
		return this.view;
	}
}
