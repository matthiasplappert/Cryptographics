package edu.kit.iks.Cryptographics.Caesar;

import edu.kit.iks.CryptographicsLib.AbstractCipherContext;
import edu.kit.iks.CryptographicsLib.CipherStepable;

public class CipherStep implements CipherStepable {
	private int _index = 0;
	
	public CipherStep(int index) {
		this._index = index;
	}
	
	@Override
	public void perform(AbstractCipherContext context) {
		// Handle current index
		String message = context.getMessage();
		int offset = Integer.parseInt(context.getKey());
		// TODO add proper handling of modulo
		context.getCipherBuilder().append(message.charAt(this._index) + offset);
		
		int nextIndex = this._index + 1;
		if (nextIndex < message.length()) {
			context.setNextStep(new CipherStep(nextIndex));
		} else {
			context.setNextStep(null);
		}
	}
	
	@Override
	public void undo(AbstractCipherContext context) {
		context.getCipherBuilder().deleteCharAt(this._index);
	}
}
