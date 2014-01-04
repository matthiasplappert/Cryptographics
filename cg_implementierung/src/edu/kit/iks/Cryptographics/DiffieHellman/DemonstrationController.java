package edu.kit.iks.Cryptographics.DiffieHellman;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import edu.kit.iks.Cryptographics.DiffieHellman.State.DHFirstState;
import edu.kit.iks.CryptographicsLib.AbstractStepController;
import edu.kit.iks.CryptographicsLib.AbstractVisualizationSequenceController;

public class DemonstrationController extends AbstractVisualizationSequenceController {
	private DiffieHellmanModel model = new DiffieHellmanModel();
	
	@Override
	public AbstractStepController getInitialStep() {
		return new DHFirstState();
	}
}
