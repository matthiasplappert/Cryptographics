package edu.kit.iks.Cryptographics.DiffieHellman;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import edu.kit.iks.Cryptographics.DiffieHellman.State.DHFirstState;
import edu.kit.iks.Cryptographics.DiffieHellman.State.DHStateController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationInfo;

public class DemonstrationController extends AbstractVisualizationController {
	private Model model;
	
	public DemonstrationController(AbstractVisualizationInfo visualizationInfo) {
		super(visualizationInfo);
		this.model = new Model();
	}
	
	public void nextStateListener(ActionEvent event) {
		// TODO go to next state
	}
	
	public void previousStateListener(ActionEvent event) {
		// TODO go to previous state
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadView() {
		// TODO Auto-generated method stub
	}
}
