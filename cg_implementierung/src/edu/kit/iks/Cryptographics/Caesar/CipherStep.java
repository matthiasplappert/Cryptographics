package edu.kit.iks.Cryptographics.Caesar;

import edu.kit.iks.CryptograhicsLib.AbstractCipherContext;
import edu.kit.iks.CryptograhicsLib.CipherStepable;

public class CipherStep implements CipherStepable {
	private int index = 0;
	
	public CipherStep(int index) {
		this.index = index;
	}
	
	@Override
	public void perform(AbstractCipherContext context) {
		// Handle current index
		String message = context.getMessage();
		int offset = Integer.parseInt(context.getKey());
		// TODO: add proper handling of modulo
		context.getCipherBuilder().append(message.charAt(this.index) + offset);
		
		int nextIndex = this.index + 1;
		if (nextIndex < message.length()) {
			context.setNextStep(new CipherStep(nextIndex));
		} else {
			context.setNextStep(null);
		}
	}
	
	@Override
	public void undo(AbstractCipherContext context) {
		context.getCipherBuilder().deleteCharAt(this.index);
	}
}
