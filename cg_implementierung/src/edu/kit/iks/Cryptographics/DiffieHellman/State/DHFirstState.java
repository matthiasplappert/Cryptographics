package edu.kit.iks.Cryptographics.DiffieHellman.State;

import edu.kit.iks.CryptographicsLib.AbstractStepController;

public class DHFirstState extends AbstractStepController {
	public void loadView() {
		this.view = new DHFirstView();
	}

	@Override
	public AbstractStepController getNextStep() {
		// TODO: return second state.
		return null;
	}

	@Override
	public boolean hasNextStep() {
		return true;
	}
}
