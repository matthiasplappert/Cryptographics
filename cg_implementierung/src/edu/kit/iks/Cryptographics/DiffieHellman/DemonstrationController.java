package edu.kit.iks.Cryptographics.DiffieHellman;

import java.awt.event.ActionEvent;

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
	
	public void nextStateListener(ActionEvent event) {
		push(state)
		this.state = this.state.nextState();
		this.view = this.state.getView();
	}
	
	public void prevStateListener(ActionEvent event) {
		this.state = this.state.previousState();
		this.view = this.state.getView();
	}
}
