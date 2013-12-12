package edu.kit.iks.Cryptographics.Caesar;

import edu.kit.iks.CryptograhicsLib.AbstractCipherContext;
import edu.kit.iks.CryptograhicsLib.CipherStepable;

public class CipherContext extends AbstractCipherContext {
	public CipherContext(String message, String key) {
		super(message, key);
	}

	public CipherStepable getInitialStep() {
		return new CipherStep(0);
	}
}
